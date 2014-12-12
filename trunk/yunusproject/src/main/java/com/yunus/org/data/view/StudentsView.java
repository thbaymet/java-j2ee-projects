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

import com.yunus.org.domain.StudentEntity;
import com.yunus.org.services.StudentService;
import com.yunus.org.services.impl.UserServiceImpl;

/**
 * @author BAYRAMOV Matin
 *
 */
@ManagedBean(name = "dtStudentsView")
@ViewScoped
public class StudentsView implements Serializable {

	private static final long serialVersionUID = -67358431070897856L;
	
	static Logger log = Logger.getLogger(UserServiceImpl.class.getName());
	
	private List<StudentEntity> students;
	
	private List<StudentEntity> filteredStudents;
	
	@ManagedProperty("#{studentService}")
	private StudentService studentService;
	
	@PostConstruct
	public void init() {
		students = studentService.list();
		log.debug("Students retreived : "+students.size()+" students.");
	}

	/**
	 * @return the students
	 */
	public List<StudentEntity> getStudents() {
		return students;
	}

	/**
	 * @param students the students to set
	 */
	public void setStudents(List<StudentEntity> students) {
		this.students = students;
	}

	/**
	 * @return the filteredStudents
	 */
	public List<StudentEntity> getFilteredStudents() {
		return filteredStudents;
	}

	/**
	 * @param filteredStudents the filteredStudents to set
	 */
	public void setFilteredStudents(List<StudentEntity> filteredStudents) {
		this.filteredStudents = filteredStudents;
	}

	/**
	 * @return the studentService
	 */
	public StudentService getStudentService() {
		return studentService;
	}

	/**
	 * @param studentService the studentService to set
	 */
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

}
