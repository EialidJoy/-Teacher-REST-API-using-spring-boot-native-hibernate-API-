package org.eialid.joy.springboot.crudrestteacher.service;

import java.util.List;

import org.eialid.joy.springboot.crudrestteacher.entity.Teacher;

public interface TeacherService {
	
	public List<Teacher> allTeachersList();

	public Teacher teacherFindById(int teacherId);
	
	public void saveTeacher(Teacher theTeacher);
	
	public void deleteTeacherById(int teacherId);

}
