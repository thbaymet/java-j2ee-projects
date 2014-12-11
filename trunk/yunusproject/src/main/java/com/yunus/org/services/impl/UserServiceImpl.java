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
			FacesMessage message = constructErrorMessage(String.format(getMessageBundle().getString("userExistsMsg"), 
					userEntity.getUserName()), null);
			getFacesContext().addMessage(null, message);
			return false;
		}
		
		try {
			userDao.save(userEntity);			
		} catch (Exception e) {
			FacesMessage message = constructFatalMessage(e.getMessage(), null);
			getFacesContext().addMessage(null, message);
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
			throw new UsernameNotFoundException(String.format(getMessageBundle().getString("badCredentials"), userName));
		}
		
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		
		User userDetails = new User(user.getUserName(), user.getPassword(), authorities);
		
		return userDetails;
	}
	
	
	public UserEntity loadUserEntityByUsername(String userName) {
		return userDao.loadUserByUserName(userName);
	}

	protected FacesMessage constructErrorMessage(String message, String detail) {
		return new FacesMessage(FacesMessage.SEVERITY_ERROR, message, detail);
	}
	
	protected FacesMessage constructInfoMessage(String message, String detail) {
		return new FacesMessage(FacesMessage.SEVERITY_INFO, message, detail);
	}
	
	protected FacesMessage constructFatalMessage(String message, String detail) {
		return new FacesMessage(FacesMessage.SEVERITY_FATAL, message, detail);
	}
	
	protected FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}
	
	protected ResourceBundle getMessageBundle() {
		
		Locale local = new Locale("az", "AZ");
		ResourceBundle bundle = ResourceBundle.getBundle("message-labels", local);
		
		return bundle;
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
			FacesMessage message = constructErrorMessage(null, String.format(getMessageBundle().getString("userExistsMsg"), value));
			getFacesContext().addMessage(event.getComponent().getClientId(), message);
		} else {
			FacesMessage message = constructInfoMessage(null, String.format(getMessageBundle().getString("userAvailableMsg"), value));
			getFacesContext().addMessage(event.getComponent().getClientId(), message);
		}
		
		return available;
	}
	

}
