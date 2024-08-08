package com.mongodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.dao.ObjectDao;
import com.mongodb.model.Student;

@RestController
@RequestMapping(value = "/student")
public class StudentController {
	
	@Autowired
	private ObjectDao objectDao;
	
	@PostMapping("/save")
	public void saveStudent(@RequestBody Student student) throws Exception {
		objectDao.saveObject(student);
	}
	
	@GetMapping("/get-student/{id}")
	public Student getStudentById(@PathVariable String id)throws Exception{
		return objectDao.getObjectById(Student.class, id);
	}
	
	@PutMapping("/update")
	public Student updateStudent(@RequestBody Student student) {
		Student studentDB=objectDao.getObjectById(Student.class, student.getId());
		studentDB.setName(student.getName());
		objectDao.updateObject(studentDB);
		return studentDB;
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable String id)throws Exception{
		Student s=objectDao.getObjectById(Student.class, id);
		objectDao.deleteObject(s);
//		objectDao.deleteByParam("student_details", "id", id);
	}
	

}
