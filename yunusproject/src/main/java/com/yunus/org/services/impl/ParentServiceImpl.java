/**
 * 
 */
package com.yunus.org.services.impl;

import java.util.List;

import com.yunus.org.dao.ParentDao;
import com.yunus.org.domain.ParentEntity;
import com.yunus.org.services.ParentService;

/**
 * @author BAYRAMOV Matin
 *
 */
public class ParentServiceImpl implements ParentService {
	
	private ParentDao parentDao;

	public boolean create(ParentEntity entity) {
		parentDao.save(entity);
		return true;
	}

	public boolean update(ParentEntity entity) {
		parentDao.update(entity);
		return true;
	}

	public boolean delete(ParentEntity entity) {
		parentDao.delete(entity);
		return true;
	}

	public List<ParentEntity> list() {
		List<ParentEntity> entities = null;
		entities = parentDao.findAll();
		return entities;
	}

	/**
	 * @return the parentDao
	 */
	public ParentDao getParentDao() {
		return parentDao;
	}

	/**
	 * @param parentDao the parentDao to set
	 */
	public void setParentDao(ParentDao parentDao) {
		this.parentDao = parentDao;
	}

}
