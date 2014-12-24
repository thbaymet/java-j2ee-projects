/**
 * 
 */
package com.baymet.dolu.main;

import org.hibernate.Session;
import org.junit.Test;

import com.baymet.dolu.domain.Course;

/**
 * @author mabay
 *
 */
public class CourseTest {
	
	@Test
	public void testAddCourses() {
		Session session = HibernateTest.beginGetSession();
		for (int i = 0; i < 10; i++) {
			Course e = HibernateTest.createRandomCourse();
			session.save(e);			
		}
		session.getTransaction().commit();
		session.close();		
	}

}
