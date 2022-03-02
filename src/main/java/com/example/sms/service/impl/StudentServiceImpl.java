package com.example.sms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.sms.entity.Student;
import com.example.sms.repository.StudentRepository;
import com.example.sms.service.StudentService;

// We use dependency injection that is being provided by spring and in order to achieve loose couple all the -
// dependency we goona use interface and a class to implement that interface.

@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepository studentRepository;

	// whenever a spring bean has only one constructor than we can avoid using @auto
	// annotation.
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> getAllStudents() {

		// StudentRepository basically provide all the CRUD method and findAll method
		// will return the list of student.
		return studentRepository.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student getStudentById(Long id) {
		return studentRepository.findById(id).get();
	}

	@Override
	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public void deleteStudentById(Long id) {
		studentRepository.deleteById(id);
	}

}
