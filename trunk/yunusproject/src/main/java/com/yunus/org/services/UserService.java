/**
 * 
 */
package com.yunus.org.services;

import com.yunus.org.domain.UserEntity;

/**
 * Service providing service methods to 
 * work with user data and entity
 * 
 * @author BAYRAMOV Matin
 *
 */
public interface UserService {

	/**
	 * Create user - persist to database
	 * @param userEntity
	 * @return true if success
	 */
	boolean createUser(UserEntity userEntity);
}
