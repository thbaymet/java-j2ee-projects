/**
 * 
 */
package com.yunus.org.dao;

import com.yunus.org.commons.dao.GenericDao;
import com.yunus.org.domain.UserEntity;

/**
 * Data access object interface to work with
 * User entity database operations. 
 * 
 * @author BAYRAMOV Matin
 *
 */
public interface UserDao extends GenericDao<UserEntity, Long> {
	
	/**
	 * Queries database for user name availability 
	 * @param userName
	 * @return true if available
	 */
	boolean checkAvailable(String userName);
	
	/**
	 * Queries for user name
	 * @param userName
	 * @return User entity
	 */
	UserEntity loadUserByUserName(String userName);
}
