/**
 * 
 */
package com.yunus.org.ui.utils;

import java.io.Serializable;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

/**
 * Helper util to assist in user interface
 * 
 * @author BAYRAMOV Matin
 *
 */
public class UIUtils implements Serializable {

	private static final long serialVersionUID = -8779949812423289122L;
	
	private int viewLoadCount = 0;
	
	public void greetOnViewLoad(ComponentSystemEvent event) {
		FacesContext context = FacesContext.getCurrentInstance();
		
		if (viewLoadCount < 1 && !context.isPostback()) {
			String firstName = (String) event.getComponent().getAttributes().get("firstName");
			String lastName = (String) event.getComponent().getAttributes().get("lastName");
			
			FacesMessage message = new FacesMessage(String.format("Welcome to your account %s %s ", firstName, lastName));
			context.addMessage("growlMessages", message);
			
			viewLoadCount++;
		}
	}
	
	public static ResourceBundle getMessageBundle() {
		Locale local = new Locale("fr", "FR");
		ResourceBundle bundle = ResourceBundle.getBundle("message-labels", local);
		return bundle;
	}
	
	public static FacesMessage constructErrorMessage(String message, String detail) {
		return new FacesMessage(FacesMessage.SEVERITY_ERROR, message, detail);
	}
	
	public static FacesMessage constructInfoMessage(String message, String detail) {
		return new FacesMessage(FacesMessage.SEVERITY_INFO, message, detail);
	}
	
	public static FacesMessage constructFatalMessage(String message, String detail) {
		return new FacesMessage(FacesMessage.SEVERITY_FATAL, message, detail);
	}
	
	public static FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}

}
