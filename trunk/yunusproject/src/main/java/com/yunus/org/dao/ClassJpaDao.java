/**
 * 
 */
package com.yunus.org.dao;

import javax.persistence.Query;

import org.springframework.util.Assert;

import com.yunus.org.commons.dao.GenericJpaDao;
import com.yunus.org.domain.ClassEntity;

/**
 * @author BAYRAMOV Matin
 *
 */
public class ClassJpaDao extends GenericJpaDao<ClassEntity, Long> implements
		ClassDao {

	public ClassJpaDao() {
		super(ClassEntity.class);
	}

	public boolean checkAvailable(String name) {
		Assert.notNull(name);
		Query query = getEntityManager().createQuery("select count(*) from " + getPersistentClass().getSimpleName() + 
				" u where u.name = :name").setParameter("name", name);
		
		Long count = (Long) query.getSingleResult();
		return count < 1;
	}

}
