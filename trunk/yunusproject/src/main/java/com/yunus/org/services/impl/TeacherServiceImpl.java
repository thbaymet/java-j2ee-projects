/**
 * 
 */
package com.yunus.org.services.impl;

import java.util.List;

import com.yunus.org.dao.TeacherDao;
import com.yunus.org.domain.TeacherEntity;
import com.yunus.org.services.TeacherService;

/**
 * @author BAYRAMOV Matin
 *
 */
public class TeacherServiceImpl implements TeacherService {
	
	private TeacherDao teacherDao;

	public boolean create(TeacherEntity entity) {
		teacherDao.save(entity);
		return true;
	}

	public boolean update(TeacherEntity entity) {
		teacherDao.update(entity);
		return true;
	}

	public boolean delete(TeacherEntity entity) {
		teacherDao.delete(entity);
		return true;
	}

	public List<TeacherEntity> list() {
		List<TeacherEntity> entities = null;
		entities = teacherDao.findAll();
		return entities;
	}

	/**
	 * @return the teacherDao
	 */
	public TeacherDao getTeacherDao() {
		return teacherDao;
	}

	/**
	 * @param teacherDao the teacherDao to set
	 */
	public void setTeacherDao(TeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}

}
