package com.ofss.student.dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ofss.student.model.Student;
import com.ofss.student.util.StudentUtil;

public class StudentDAO {
	
	public void addUpdateStudent(Student student) {
		SessionFactory sessionFactory = StudentUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(student);
		transaction.commit();
		session.close();
		
	}

		public Student findStudentByStudentId(String studentId) {
		SessionFactory sessionFactory = StudentUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		return session.find(Student.class, studentId);	
	}
		
		public List<Student> findAllStudents() {
			SessionFactory sessionFactory = StudentUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			return session.createQuery("from Student", Student.class).getResultList();
		}
		
		public void deleteStudentById(String studentId) {
			Student student = findStudentByStudentId(studentId);
			SessionFactory sessionFactory = StudentUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.delete(student);
			transaction.commit();
			session.close();

		}
}
