package com.prowings.dao;

import java.util.List;


import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.prowings.entities.StudentEntity;
import com.prowings.model.Student;

public class StudentDaoImpl implements StudentDao {
	SessionFactory factory = HibernateUtil.getSessionFactory();
	@Override
	public boolean createStudent(StudentEntity std) {
		try {
			Session session = factory.openSession();
			org.hibernate.Transaction tx = session.beginTransaction();
			session.save(std);
			tx.commit();
			session.close();
			System.out.println("Student record saved to DB successfully !!");
			return true;
		}
		catch(Exception e) {
			System.out.println("Unable to store student record to DB");
			e.printStackTrace();
			return false;
		}
		finally {
			HibernateUtil.close();
		}
	
	}

	@Override
	public StudentEntity getStudentByRoll(int roll) {
		StudentEntity entity;
		Session session=null;
		String query ="From StudentEntity student where student.roll= :roll";
		try {
			session = factory.openSession();
			Transaction tx = session.beginTransaction();
			Query qr = session.createQuery(query);
			qr.setParameter("roll", roll);
			entity = (StudentEntity)qr.uniqueResult();
			
			tx.commit();
			System.out.println("Student record fetched successfully");
			return entity;
			}catch(Exception ex){
				System.out.println("Unable to fetch student record from DB");
				ex.printStackTrace();
				return null;
			}
			finally{
				session.close();
			}
			
	
	}

	@Override
	public List<StudentEntity> getAllStudents() {
		List<StudentEntity> entity;
		Session session = null;
		String query = "From StudentEntity student";
		try {
			session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Query q=session.createQuery(query);
		entity = q.list();
		
		tx.commit();
		System.out.println("All Student records fetched successfully");
		return entity;
		}catch(Exception ex){
			System.out.println("Unable to fetch student records from DB");
			ex.printStackTrace();
			return null;
		}
		finally{
			session.close();
		}
	}

	

	@Override
	public boolean deleteStudent(int roll) {
		Session session = null;
		String query = "delete from StudentEntity student where student.roll = :roll";
		try {
			session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Query q=session.createQuery(query);
		q.setParameter("roll", roll);
		q.executeUpdate();
		
		tx.commit();
		System.out.println("Student record deleted successfully");
		return true;
		}catch(Exception ex){
			System.out.println("Unable to delete student record from DB");
			ex.printStackTrace();
			return false;
		}
		finally{
			session.close();
		}
	}

	@Override
	public boolean updateStudent(StudentEntity std, int roll) {
		Session session = null;
		String q = "update StudentEntities set address =:a where rollnum =: q";
		try {
			session = factory.openSession();
			Transaction tx = session.beginTransaction();
            Query query = session.createQuery(q);
			query.setParameter("q",roll);
			query.setParameter("a", std.getAddress());

			int r = query.executeUpdate();
			System.out.println("Updated...");
			System.out.println(r);
			tx.commit();

			System.out.println("update operation get succesfully completed..");
			return true;

		} catch (Exception e) {
			System.out.println("oops data not get uppdated...");
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
		

}
}
