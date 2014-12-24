/**
 * 
 */
package com.baymet.dolu.main;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import com.baymet.dolu.domain.Student;

/**
 * @author mabay
 *
 */
public class StudentTest {

	Session session = HibernateTest.beginGetSession();
	
	@Test
	public void testAddStudents() {
		for (int i = 0; i < 10; i++) {
			Student student = HibernateTest.createRandomStudent();
			session.save(student);			
		}
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void testGetStudents() {
		Query q = session.createQuery("from Student");
		List<Student> result = HibernateTest.castList(Student.class, q.list());
		System.out.println("num of students : "+result.size());
		for (Student next : result) {
			System.out.println("next student: "+next);
		}
	}
	
	@Test
	public void testGetStudentById() {
		Query query = session.createQuery("from Student S where S.id = :student_id");
		query.setParameter("student_id", (long) 3);
		List l = query.list();
		System.out.println("student with id 3 : "+l.toString());
	}
	
	@Test
	public void testGetStudentByFirstname() {
		Query query = session.createQuery("from Student S where S.firstName = :student_firstName");
		query.setParameter("student_firstName", "BAYRAMOV");
		List l = query.list();
		System.out.println("student with firstname MATIN : "+l.toString());
	}
	

}
