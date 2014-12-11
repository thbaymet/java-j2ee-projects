/**
 * 
 */
package com.yunus.org.dao;

import com.yunus.org.commons.dao.GenericJpaDao;
import com.yunus.org.domain.StudentEntity;

/**
 * @author BAYRAMOV Matin
 *
 */
public class StudentJpaDao extends GenericJpaDao<StudentEntity, Long> implements StudentDao {

	public StudentJpaDao() {
		super(StudentEntity.class);
	}
	

}
