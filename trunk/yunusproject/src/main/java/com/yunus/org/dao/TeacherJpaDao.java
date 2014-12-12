/**
 * 
 */
package com.yunus.org.dao;

import com.yunus.org.commons.dao.GenericJpaDao;
import com.yunus.org.domain.TeacherEntity;

/**
 * @author BAYRAMOV Matin
 *
 */
public class TeacherJpaDao extends GenericJpaDao<TeacherEntity, Long> implements TeacherDao {

	public TeacherJpaDao() {
		super(TeacherEntity.class);
	}

}
