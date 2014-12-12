/**
 * 
 */
package com.yunus.org.services;

import java.util.List;

import javax.faces.event.AjaxBehaviorEvent;

import com.yunus.org.domain.ClassEntity;

/**
 * @author BAYRAMOV Matin
 *
 */
public interface ClassService {
	
	boolean create(ClassEntity entity);
	
	boolean update(ClassEntity entity);
	
	boolean delete(ClassEntity entity);
	
	List<ClassEntity> list();
	
	/**
	 * Check class name availability. UI Ajax use.
	 * 
	 * @param event
	 * @return
	 */
	boolean checkAvailable(AjaxBehaviorEvent event);

}
