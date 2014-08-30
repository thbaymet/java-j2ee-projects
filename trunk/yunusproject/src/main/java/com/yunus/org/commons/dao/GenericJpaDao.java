/**
 * 
 */
package com.yunus.org.commons.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.yunus.org.commons.domain.BaseEntity;

/**
 * Provides generic common implementation
 * of GenericDao interface persistence methods. 
 * 
 * Extend this abstract class to implement 
 * DAO for your specific needs. 
 * 
 * 
 * @author BAYRAMOV Matin
 *
 */
@Transactional
public abstract class GenericJpaDao<T, ID extends Serializable> implements GenericDao<T, ID> {
	
	private Class<T> persistentClass;
	
	private EntityManager entityManager;
	
	public GenericJpaDao(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	/**
	 * @return the persistentClass
	 */
	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	/**
	 * @return the entityManager
	 */
	protected EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * @param entityManager the entityManager to set
	 */
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	
	public T save(T entity) {
		getEntityManager().persist(entity);
		return entity;
	}
	
	public T update(T entity) {
		T mergedEntity = getEntityManager().merge(entity);
		return mergedEntity;
	}
	
	public void delete(T entity) {
		if (BaseEntity.class.isAssignableFrom(persistentClass)) {
			getEntityManager().remove(
					getEntityManager().getReference(entity.getClass(), 
							((BaseEntity) entity).getId()));
		} else {
			entity = getEntityManager().merge(entity);
			getEntityManager().remove(entity);
		}
	}
	
	@Transactional(readOnly=true)
	public T findById(ID id) {
		T entity = (T) getEntityManager().find(getPersistentClass(), id);
		return entity;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<T> findAll() {
		return getEntityManager()
				.createQuery("select x from "+getPersistentClass().getSimpleName() + " x")
				.getResultList();
	}
	
	public void flush() {
		getEntityManager().flush();
	}
	

	
}










