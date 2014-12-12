/**
 * 
 */
package com.yunus.org.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.yunus.org.commons.domain.BaseEntity;

/**
 * @author BAYRAMOV Matin
 *
 */
@Entity
@Table(name="mb_student")
public class StudentEntity extends BaseEntity {

	private static final long serialVersionUID = 592311989622198523L;
	
	private String firstName;
	
	private String lastName;
	
	private String address;
	
	private int type;

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
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}

}
