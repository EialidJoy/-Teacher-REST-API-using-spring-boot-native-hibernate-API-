package org.eialid.joy.springboot.crudrestteacher.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.eialid.joy.springboot.crudrestteacher.entity.Teacher;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class TeacherDaoHibernateImpl implements TeacherDao {
	
	private EntityManager entityManager;
	
	
	@Autowired
	public TeacherDaoHibernateImpl(EntityManager theEntityManager) {
		entityManager=theEntityManager;
	}
	
	@Override
	@Transactional
	public List<Teacher> allTeachersList() {
		
		//create the session
		Session newSession=entityManager.unwrap(Session.class);
		
		
		//create the query
		Query<Teacher> theQuery=newSession.createQuery("from Teacher",Teacher.class);
		
		//execute query and get the resultset
		List<Teacher> teachersList=theQuery.getResultList();
		
		//return the list
		
		return teachersList;
	}

	@Override
	@Transactional
	public Teacher teacherFindById(int teacherId) {
		
		Session newSession=entityManager.unwrap(Session.class);
		Teacher theTeacher=newSession.get(Teacher.class, teacherId);
		return theTeacher;
	}

	@Override
	@Transactional
	public void saveTeacher(Teacher theTeacher) {
		
		Session newSession=entityManager.unwrap(Session.class);
		newSession.saveOrUpdate(theTeacher);
	}

	@Override
	@Transactional
	public void deleteTeacherById(int teacherId) {
		
		Session newSession=entityManager.unwrap(Session.class);
		Query<Teacher> theQuery=newSession.createQuery("delete from Teacher where id=:theId");
		theQuery.setParameter("theId", teacherId);
		
		theQuery.executeUpdate();
	}

}














