/**
 * 
 */
package com.yunus.org.dao;

import com.yunus.org.commons.dao.GenericDao;
import com.yunus.org.domain.ClassEntity;

/**
 * @author BAYRAMOV Matin
 *
 */
public interface ClassDao extends GenericDao<ClassEntity, Long> {

	boolean checkAvailable(String name);
	
}
