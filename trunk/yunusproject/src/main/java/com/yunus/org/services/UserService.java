/**
 * 
 */
package com.yunus.org.services;

import javax.faces.event.AjaxBehaviorEvent;

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
	
	
	/**
	 * Check user name availability. UI Ajax use.
	 * 
	 * @param event
	 * @return
	 */
	boolean checkAvailable(AjaxBehaviorEvent event);
	
	
	/**
	 * Retrieves full user record from database by user name
	 * 
	 * @param userName
	 * @return
	 */
	UserEntity loadUserEntityByUsername(String userName);
}
