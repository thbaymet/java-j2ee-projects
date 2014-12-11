/**
 * 
 */
package com.yunus.org.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.yunus.org.commons.domain.BaseEntity;

/**
 * 
 * Entity to hold application user data
 * 
 * @author BAYRAMOV Matin
 *
 */
@Entity
@Table(name="mb_user")
public class UserEntity extends BaseEntity {
	
	private static final long serialVersionUID = -967018192995446072L;

	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column
	private String userName;
	
	@Column
	private String password;

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);
		
		this.password = hashedPassword;
	}

}
