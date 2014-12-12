/**
 * 
 */
package com.yunus.org.services.impl;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.event.AjaxBehaviorEvent;

import org.primefaces.component.inputtext.InputText;

import com.yunus.org.dao.ClassDao;
import com.yunus.org.domain.ClassEntity;
import com.yunus.org.services.ClassService;
import com.yunus.org.ui.utils.UIUtils;

/**
 * @author BAYRAMOV Matin
 *
 */
public class ClassServiceImpl implements ClassService {

	private ClassDao classDao;

	public boolean create(ClassEntity entity) {
		
		if (!classDao.checkAvailable(entity.getName())) {
			FacesMessage message = UIUtils.constructErrorMessage(String.format(UIUtils.getMessageBundle().getString("message.already-exists"), 
					entity.getName()), null);
			UIUtils.getFacesContext().addMessage(null, message);
			return false;
		}
		
		classDao.save(entity);
		return true;
	}

	public boolean update(ClassEntity entity) {
		classDao.update(entity);
		return true;
	}

	public boolean delete(ClassEntity entity) {
		classDao.delete(entity);
		return true;
	}

	public List<ClassEntity> list() {
		List<ClassEntity> entities = null;
		entities = classDao.findAll();
		return entities;
	}

	/**
	 * @return the classDao
	 */
	public ClassDao getClassDao() {
		return classDao;
	}

	/**
	 * @param classDao the classDao to set
	 */
	public void setClassDao(ClassDao classDao) {
		this.classDao = classDao;
	}

	public boolean checkAvailable(AjaxBehaviorEvent event) {
		InputText inputText = (InputText) event.getSource();
		String value = (String) inputText.getValue();
		value = value.trim();
		
		boolean available = classDao.checkAvailable(value);
		
		if (!available) {
			FacesMessage message = UIUtils.constructErrorMessage(null, String.format(UIUtils.getMessageBundle().getString("message.already-exists"), value));
			UIUtils.getFacesContext().addMessage(event.getComponent().getClientId(), message);
		}
		
		return available;
	}
	
	
}
