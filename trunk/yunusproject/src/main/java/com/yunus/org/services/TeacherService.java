/**
 * 
 */
package com.yunus.org.services;

import java.util.List;

import com.yunus.org.domain.TeacherEntity;

/**
 * @author BAYRAMOV Matin
 *
 */
public interface TeacherService {
	
	boolean create(TeacherEntity entity);
	
	boolean update(TeacherEntity entity);
	
	boolean delete(TeacherEntity entity);
	
	List<TeacherEntity> list();

}
