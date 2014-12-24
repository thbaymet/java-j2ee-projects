/*
 * Copyright (c) 2014 BAYRAMOV Matin
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.baymet.dolu.main;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import com.baymet.dolu.domain.Address;
import com.baymet.dolu.domain.Course;
import com.baymet.dolu.domain.Department;
import com.baymet.dolu.domain.Employee;
import com.baymet.dolu.domain.Student;
import com.baymet.dolu.domain.Subject;
import com.baymet.dolu.util.HibernateUtil;

/**
 * @author BAYRAMOV Matin
 *
 */

public class HibernateTest {
	
	
	@Test
	public void test() {
        
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
 
        Department department = new Department("java");
        session.save(department);
 
        session.save(new Employee("Jakab Gipsz", department));
        session.save(new Employee("Captain Nemo", department));
        
        Address address = new Address("7 Rue Pierre Laplace", "2500");
        Student student = new Student("BAYRAMOV", "Matin");
        student.setAddress(address);
        session.save(address);
        
        //=====================
		Subject sub0 = new Subject("Empire Ottoman", "The Ottoman Empire");
		Subject sub1 = new Subject("Saladin", "Saladin with the crusades");
		session.save(sub0);
		session.save(sub1);
		
		Course course = new Course("History", "History course");
		sub0.setCourse(course);
		sub1.setCourse(course);
		session.save(course);
		
		Set<Student> students = new HashSet<Student>();
		students.add(student);
		course.setStudents(students);
		
//		Set<Course> courses = new HashSet<Course>();
//		courses.add(course);
//		student.setCourses(courses);
      
        session.save(student);
        session.getTransaction().commit();

        Query q = session.createQuery("From Employee ");
                 
        List<Employee> resultList = castList(Employee.class, q.list());
        
        System.out.println("num of employess:" + resultList.size());
        for (Employee next : resultList) {
            System.out.println("next employee: " + next);
        }
        
        q = session.createQuery("from Student");

        List<Student> result = castList(Student.class, q.list());
        System.out.println("num of students : "+result.size());
        for (Student next : result) {
        	System.out.println("next student: "+next);
        }
        
        q = session.createQuery("from Course");
        List<Course> courses = castList(Course.class, q.list());
        System.out.println("num of courses : "+courses.size());
        for (Course next : courses) {
        	System.out.println("next course : "+next);
        	System.out.println("student size: "+next.getStudents().size());
        	Set<Student> members = next.getStudents();
        	for (Student s : members) {
        		System.out.println("student : "+s.toString());
        	}
        }
        
    }
	
	public static Student createRandomStudent() {
		SecureRandom random = new SecureRandom();
		String randFirstName = new BigInteger(130, random).toString(32);
		String randLastName = new BigInteger(130, random).toString(32);
		return new Student(randFirstName, randLastName);
	}
	
	public static Course createRandomCourse() {
		SecureRandom random = new SecureRandom();
		String name = new BigInteger(130, random).toString(32);
		String description = new BigInteger(130, random).toString(32);
		return new Course(name, description);
	}
	
	public static Session beginGetSession() {
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        return session;
	}
	
	public static <T> List<T> castList(Class<? extends T> clazz, Collection<?> c) {
	    List<T> r = new ArrayList<T>(c.size());
	    for(Object o: c)
	      r.add(clazz.cast(o));
	    return r;
	}
}
