package org.eialid.joy.springboot.crudrestteacher.dao;

import java.util.List;

import org.eialid.joy.springboot.crudrestteacher.entity.Teacher;

public interface TeacherDao {
	
	public List<Teacher> allTeachersList();

	public Teacher teacherFindById(int teacherId);
	
	public void saveTeacher(Teacher theTeacher);
	
	public void deleteTeacherById(int teacherId);

}
