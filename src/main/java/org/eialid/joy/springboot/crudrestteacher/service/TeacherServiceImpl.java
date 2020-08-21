package org.eialid.joy.springboot.crudrestteacher.service;

import java.util.List;

import org.eialid.joy.springboot.crudrestteacher.dao.TeacherDao;
import org.eialid.joy.springboot.crudrestteacher.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TeacherServiceImpl implements TeacherService {
	private TeacherDao teacherDao;
	
	@Autowired
	public TeacherServiceImpl(TeacherDao theTeacherDao) {
		teacherDao=theTeacherDao;
	}


	@Override
	@Transactional
	public List<Teacher> allTeachersList() {
		
		return teacherDao.allTeachersList();
	}

	@Override
	@Transactional
	public Teacher teacherFindById(int teacherId) {
		
		return teacherDao.teacherFindById(teacherId);
	}

	@Override
	
	public void saveTeacher(Teacher theTeacher) {
		
		teacherDao.saveTeacher(theTeacher);
	}

	@Override
	
	public void deleteTeacherById(int teacherId) {
		
		teacherDao.deleteTeacherById(teacherId);
	}

}
