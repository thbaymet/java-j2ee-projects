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

import com.yunus.org.domain.ParentEntity;
import com.yunus.org.services.ParentService;
import com.yunus.org.services.impl.UserServiceImpl;

/**
 * @author BAYRAMOV Matin
 *
 */
@ManagedBean(name = "dtParentsView")
@ViewScoped
public class ParentsView implements Serializable {

	private static final long serialVersionUID = 3050829541374424941L;
	
	static Logger log = Logger.getLogger(UserServiceImpl.class.getName());
	
	private List<ParentEntity> parents;
	
	private List<ParentEntity> filteredParents;
	
	@ManagedProperty("#{parentService}")
	private ParentService parentService;
	
	@PostConstruct
	public void init() {
		parents = parentService.list();
		log.debug("Parents retreived : "+parents.size()+" parents.");
	}

	/**
	 * @return the parents
	 */
	public List<ParentEntity> getParents() {
		return parents;
	}

	/**
	 * @param parents the parents to set
	 */
	public void setParents(List<ParentEntity> parents) {
		this.parents = parents;
	}

	/**
	 * @return the filteredParents
	 */
	public List<ParentEntity> getFilteredParents() {
		return filteredParents;
	}

	/**
	 * @param filteredParents the filteredParents to set
	 */
	public void setFilteredParents(List<ParentEntity> filteredParents) {
		this.filteredParents = filteredParents;
	}

	/**
	 * @return the parentService
	 */
	public ParentService getParentService() {
		return parentService;
	}

	/**
	 * @param parentService the parentService to set
	 */
	public void setParentService(ParentService parentService) {
		this.parentService = parentService;
	}

}
