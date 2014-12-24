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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
        session.save(student);
        
        //=====================
		Course course = new Course("History", "History course");
		Subject sub0 = new Subject("Empire Ottoman", "The Ottoman Empire");
		Subject sub1 = new Subject("Saladin", "Saladin with the crusades");
		
		session.save(sub0);
		session.save(sub1);
		session.save(course);

		sub0.setCourse(course);
		sub1.setCourse(course);
        
      
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
        
    }
	
	public Session beginGetSession() {
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        return session;
	}
	
	public <T> List<T> castList(Class<? extends T> clazz, Collection<?> c) {
	    List<T> r = new ArrayList<T>(c.size());
	    for(Object o: c)
	      r.add(clazz.cast(o));
	    return r;
	}
}
