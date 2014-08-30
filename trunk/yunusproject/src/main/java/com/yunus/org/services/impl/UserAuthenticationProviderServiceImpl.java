/**
 * 
 */
package com.yunus.org.services.impl;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;

import com.yunus.org.domain.UserEntity;
import com.yunus.org.services.UserAuthenticationProviderService;

/**
 * Provides processing service to set user 
 * authentication session
 * 
 * @author BAYRAMOV Matin
 *
 */
public class UserAuthenticationProviderServiceImpl implements
		UserAuthenticationProviderService {

	private AuthenticationManager authenticationManager;
	
	/**
	 * Provides user authentication
	 */
	public boolean processUserAuthentication(UserEntity user) {
		
		try {
			Authentication request = new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
			Authentication result = authenticationManager.authenticate(request);
			SecurityContextHolder.getContext().setAuthentication(result);
			return true;			
		} catch (AuthenticationException e) {
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Sorry!"));
			return false;
		}
	}

	/**
	 * @return the authenticationManager
	 */
	public AuthenticationManager getAuthenticationManager() {
		return authenticationManager;
	}

	/**
	 * @param authenticationManager the authenticationManager to set
	 */
	public void setAuthenticationManager(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

}
