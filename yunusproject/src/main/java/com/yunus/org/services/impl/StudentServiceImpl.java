/**
 * 
 */
package com.yunus.org.services.impl;

import java.util.List;

import com.yunus.org.dao.StudentDao;
import com.yunus.org.domain.StudentEntity;
import com.yunus.org.services.StudentService;

/**
 * @author BAYRAMOV Matin
 *
 */
public class StudentServiceImpl implements StudentService {
	
	private StudentDao studentDao;

	public boolean create(StudentEntity entity) {
		studentDao.save(entity);
		return true;
	}

	public boolean update(StudentEntity entity) {
		studentDao.update(entity);
		return true;
	}

	public boolean delete(StudentEntity entity) {
		studentDao.delete(entity);
		return true;
	}

	public List<StudentEntity> list() {
		List<StudentEntity> entities = null;
		entities = studentDao.findAll();
		return entities;
	}

	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}



}
