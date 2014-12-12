/**
 * 
 */
package com.yunus.org.services;

import java.util.List;

import com.yunus.org.domain.StudentEntity;

/**
 * @author BAYRAMOV Matin
 *
 */
public interface StudentService {
	
	boolean create(StudentEntity entity);
	
	boolean update(StudentEntity entity);
	
	boolean delete(StudentEntity entity);
	
	List<StudentEntity> list();

}
