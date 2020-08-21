package org.eialid.joy.springboot.crudrestteacher.rest;

import java.util.List;

import org.eialid.joy.springboot.crudrestteacher.entity.Teacher;
import org.eialid.joy.springboot.crudrestteacher.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TeacherRestController {
	
	private TeacherService teacherService;
	
	@Autowired
	public TeacherRestController(TeacherService theTeacherService) {
		teacherService=theTeacherService;
	}
	
	@GetMapping("/teachers")
	public List<Teacher> allTeachersList(){
		return teacherService.allTeachersList();
	}
	
	@GetMapping("/teachers/{teacherId}")
	public Teacher teacherFindById(@PathVariable int teacherId){
		
		Teacher theTeacher=teacherService.teacherFindById(teacherId);
		
		if(theTeacher==null) {
			throw new RuntimeException("Teacher id is not found = " + teacherId);
		}

		return teacherService.teacherFindById(teacherId);
	}
	
	@PostMapping("/teachers")
	public Teacher saveTeacher(@RequestBody Teacher theTeacher){
		
		theTeacher.setId(0);
		teacherService.saveTeacher(theTeacher);
		return theTeacher;
		
	}
	
	@PutMapping("/teachers")
	public Teacher updateTeacher(@RequestBody Teacher theTeacher) {
		
		teacherService.saveTeacher(theTeacher);
		return theTeacher;
	}
	
	
	
	@DeleteMapping("/teachers/{teacherId}")
	public String deleteTeacherById(@PathVariable int teacherId) {
		
		Teacher theTeacher=teacherService.teacherFindById(teacherId);
		
		if(theTeacher==null) {
			throw new RuntimeException("Teacher id is not found = " + teacherId);
		}
		
		teacherService.deleteTeacherById(teacherId);
		return teacherId + " has been deleted seccessfully";
	}

	
}













