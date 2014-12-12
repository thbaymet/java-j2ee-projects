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

import com.yunus.org.domain.TeacherEntity;
import com.yunus.org.services.TeacherService;
import com.yunus.org.services.impl.UserServiceImpl;

/**
 * @author BAYRAMOV Matin
 *
 */
@ManagedBean(name = "dtTeachersView")
@ViewScoped
public class TeachersView implements Serializable {

	private static final long serialVersionUID = 2166939047434781069L;
	
	static Logger log = Logger.getLogger(UserServiceImpl.class.getName());
	
	private List<TeacherEntity> teachers;
	
	private List<TeacherEntity> filteredTeachers;
	
	@ManagedProperty("#{teacherService}")
	private TeacherService teacherService;
	
	@PostConstruct
	public void init() {
		teachers = teacherService.list();
		log.debug("Teachers retreived : "+teachers.size()+" teachers.");
	}

	/**
	 * @return the teachers
	 */
	public List<TeacherEntity> getTeachers() {
		return teachers;
	}

	/**
	 * @param teachers the teachers to set
	 */
	public void setTeachers(List<TeacherEntity> teachers) {
		this.teachers = teachers;
	}

	/**
	 * @return the filteredTeachers
	 */
	public List<TeacherEntity> getFilteredTeachers() {
		return filteredTeachers;
	}

	/**
	 * @param filteredTeachers the filteredTeachers to set
	 */
	public void setFilteredTeachers(List<TeacherEntity> filteredTeachers) {
		this.filteredTeachers = filteredTeachers;
	}

	/**
	 * @return the teacherService
	 */
	public TeacherService getTeacherService() {
		return teacherService;
	}

	/**
	 * @param teacherService the teacherService to set
	 */
	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

}
