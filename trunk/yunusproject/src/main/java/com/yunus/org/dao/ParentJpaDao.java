/**
 * 
 */
package com.yunus.org.dao;

import com.yunus.org.commons.dao.GenericJpaDao;
import com.yunus.org.domain.ParentEntity;

/**
 * @author BAYRAMOV Matin
 *
 */
public class ParentJpaDao extends GenericJpaDao<ParentEntity, Long> implements
		ParentDao {

	public ParentJpaDao() {
		super(ParentEntity.class);
	}

}
