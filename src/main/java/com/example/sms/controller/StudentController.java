package com.example.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.sms.entity.Student;
import com.example.sms.service.StudentService;

// The annotation is because we need to make this class a spring MVC class to handle the request from browser
@Controller
public class StudentController {

	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	// Now we create a handler method to handle list student and return model and
	// view .
	// Annotation for mapping HTTP GET requests onto specific handler methods.

	@GetMapping("/students")
	public String listStudents(Model model) {

		// This information is coming from the database through studentService and its
		// method getAllStudent.
		model.addAttribute("students", studentService.getAllStudents());
		// here the "students" is the view which we are returning
		return "students";

	}

	@GetMapping("/students/new")
	public String createStudentForm(Model model) {

		// create student object to hold student from data
		Student student = new Student();
		model.addAttribute("student", student);
		return "create_student";

	}

	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";
	}

	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.getStudentById(id));
		return "edit_student";
	}

	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model) {

		// get student from database by id
		Student existingStudent = studentService.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());

		// save updated student object
		studentService.updateStudent(existingStudent);
		return "redirect:/students";
	}

	// handler method to handle delete student request

	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudentById(id);
		return "redirect:/students";
	}

}
