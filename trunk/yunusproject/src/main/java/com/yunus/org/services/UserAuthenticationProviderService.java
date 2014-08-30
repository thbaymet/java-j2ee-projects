/**
 * 
 */
package com.yunus.org.services;

import com.yunus.org.domain.UserEntity;

/**
 * Provides processing service to set user 
 * authentication session
 * 
 * @author BAYRAMOV Matin
 *
 */
public interface UserAuthenticationProviderService {
	
	/**
	 * Process user authentication
	 * 
	 * @param user
	 * @return
	 */
	boolean processUserAuthentication(UserEntity user);

}
