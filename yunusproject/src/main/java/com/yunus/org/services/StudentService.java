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
	
	boolean createStudent(StudentEntity entity);
	
	boolean updateStudent(StudentEntity entity);
	
	boolean deleteStudent(StudentEntity entity);
	
	List<StudentEntity> list();

}
