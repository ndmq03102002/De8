package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {
	@Autowired
	private StudentRepository repo;
	@Autowired
	private StudentService service;
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	@GetMapping("/student")
	public String viewStudent(Model model) {
		List<Student> student = repo.findByApprovedEquals(0);
		model.addAttribute("student", student);
		return "view_student";
	}
	
	@PostMapping("/student/{id}/approved")
	public String ApprovedStudent(@PathVariable String id) {
		Student student = service.get(id);
		if(student!=null) {
			student.setApproved(1);
			repo.save(student);
		}
		return "redirect:/student";
	}
	
	@PostMapping("/student/{id}/delete")
	public String viewDelete(Model model, @PathVariable String id) {
		Student student = service.get(id);
		model.addAttribute("Student", student);
		return "student_detail";
	}
	@PostMapping("/delete")
	public String delete(@ModelAttribute("Student") Student student, 
			@RequestParam(name="confirmdelete" , required=false) String confirmdelete, 
			@RequestParam(name="cancel", required=false) String cancel ) {
		if(confirmdelete!=null) {
			repo.delete(student);
		}
		return "redirect:/student";
	}
}
