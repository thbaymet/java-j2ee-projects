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
@Table(name="mb_class")
public class ClassEntity extends BaseEntity {

	private static final long serialVersionUID = -796277390471541181L;
	
	private String name;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	

}
