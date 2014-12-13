/**
 * 
 */
package com.yunus.org.services;

import java.util.List;

import com.yunus.org.domain.ParentEntity;

/**
 * @author BAYRAMOV Matin
 *
 */
public interface ParentService {
	
	boolean create(ParentEntity entity);
	
	boolean update(ParentEntity entity);
	
	boolean delete(ParentEntity entity);
	
	List<ParentEntity> list();

}
