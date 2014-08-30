/**
 * 
 */
package com.yunus.org.services.impl;

import java.util.ArrayList;
import java.util.Collection;

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
	
	/**
	 * 
	 */
	public boolean createUser(UserEntity userEntity) {
		userDao.save(userEntity);
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
			throw new UsernameNotFoundException(String.format("No such user with name provided '%s'", userName));
		}
		
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		
		User userDetails = new User(user.getUserName(), user.getPassword(), authorities);
		
		return userDetails;
	}

}
