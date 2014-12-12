/**
 * 
 */
package com.yunus.org.data.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;

import com.yunus.org.domain.ClassEntity;
import com.yunus.org.domain.StudentEntity;
import com.yunus.org.services.ClassService;
import com.yunus.org.services.StudentService;
import com.yunus.org.services.impl.UserServiceImpl;

/**
 * @author BAYRAMOV Matin
 *
 */
@ManagedBean(name = "dtClassesView")
@ViewScoped
public class ClassesView implements Serializable {

	private static final long serialVersionUID = -6262905108626541625L;
	
	static Logger log = Logger.getLogger(UserServiceImpl.class.getName());
	
	private List<ClassEntity> classes;
	
	private List<ClassEntity> filteredClasses;
	
	@ManagedProperty("#{classService}")
	private ClassService classService;
	
	@PostConstruct
	public void init() {
		classes = classService.list();
		log.debug("Classes retreived : "+classes.size()+" classes.");
	}

	/**
	 * @return the classes
	 */
	public List<ClassEntity> getClasses() {
		return classes;
	}

	/**
	 * @param classes the classes to set
	 */
	public void setClasses(List<ClassEntity> classes) {
		this.classes = classes;
	}

	/**
	 * @return the filteredClasses
	 */
	public List<ClassEntity> getFilteredClasses() {
		return filteredClasses;
	}

	/**
	 * @param filteredClasses the filteredClasses to set
	 */
	public void setFilteredClasses(List<ClassEntity> filteredClasses) {
		this.filteredClasses = filteredClasses;
	}

	/**
	 * @return the classService
	 */
	public ClassService getClassService() {
		return classService;
	}

	/**
	 * @param classService the classService to set
	 */
	public void setClassService(ClassService classService) {
		this.classService = classService;
	}

}
