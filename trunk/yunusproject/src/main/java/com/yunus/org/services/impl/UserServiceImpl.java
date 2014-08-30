/**
 * 
 */
package com.yunus.org.services.impl;

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
public class UserServiceImpl implements UserService {

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

}
