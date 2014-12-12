/**
 * 
 */
package com.yunus.org.services.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import org.apache.log4j.Logger;
import org.primefaces.component.inputtext.InputText;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.yunus.org.dao.UserDao;
import com.yunus.org.domain.UserEntity;
import com.yunus.org.services.UserService;
import com.yunus.org.ui.utils.UIUtils;

/**
 * Service providing service methods to 
 * work with user data and entity
 * 
 * @author BAYRAMOV Matin
 *
 */
public class UserServiceImpl implements UserService, UserDetailsService {

	private UserDao userDao;
	
	static Logger log = Logger.getLogger(UserServiceImpl.class.getName());
	
	/**
	 * 
	 */
	public boolean createUser(UserEntity userEntity) {
		
		if (!userDao.checkAvailable(userEntity.getUserName())) {
			FacesMessage message = UIUtils.constructErrorMessage(String.format(UIUtils.getMessageBundle().getString("message.already-exists"), 
					userEntity.getUserName()), null);
			UIUtils.getFacesContext().addMessage(null, message);
			return false;
		}
		
		try {
			userDao.save(userEntity);			
		} catch (Exception e) {
			FacesMessage message = UIUtils.constructFatalMessage(e.getMessage(), null);
			UIUtils.getFacesContext().addMessage(null, message);
		}
		
		return true;
	}

	/**
	 * @return the userDao
	 */
	public UserDao getUserDao() {
		return userDao;
	}

	/**
	 * @param userDao the userDao to set
	 */
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * Construct UserDetails instance required by spring security
	 */
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		UserEntity user = userDao.loadUserByUserName(userName);
		
		if (user == null) {
			throw new UsernameNotFoundException(String.format(UIUtils.getMessageBundle().getString("badCredentials"), userName));
		}
		
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		
		User userDetails = new User(user.getUserName(), user.getPassword(), authorities);
		
		return userDetails;
	}
	
	
	public UserEntity loadUserEntityByUsername(String userName) {
		return userDao.loadUserByUserName(userName);
	}

	/**
	 * 
	 */
	public boolean checkAvailable(AjaxBehaviorEvent event) {
		
		InputText inputText = (InputText) event.getSource();
		String value = (String) inputText.getValue();
		value = value.trim();
		
		boolean available = userDao.checkAvailable(value);
		
		if (!available) {
			FacesMessage message = UIUtils.constructErrorMessage(null, String.format(UIUtils.getMessageBundle().getString("message.already-exists"), value));
			UIUtils.getFacesContext().addMessage(event.getComponent().getClientId(), message);
		}
		
		return available;
	}
	

}
