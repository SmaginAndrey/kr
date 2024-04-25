package org.example.educational_portal.controllers;

import lombok.AllArgsConstructor;
import org.example.educational_portal.dto.StudentPojo;
import org.example.educational_portal.services.StudentServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Контроллер для работы сс Студентами
 **/
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/students")
@AllArgsConstructor
public class StudentController {

	private final StudentServiceImpl studentServiceImpl;

	@GetMapping
	public List<StudentPojo> findAllStudents() {
		return studentServiceImpl.findAll();
	}

	@GetMapping("/{id}")
	public StudentPojo findStudentById(@PathVariable long id) {
		return studentServiceImpl.findById(id);
	}

	@PostMapping
	public StudentPojo createAndAddNewStudent(@RequestBody StudentPojo pojo) {
		return studentServiceImpl.createOrUpdate(pojo);
	}

	@PutMapping
	public void updateStudent(@RequestBody StudentPojo pojo) {
		studentServiceImpl.createOrUpdate(pojo);
	}

	@DeleteMapping
	public boolean deleteStudentById(@RequestParam long id) {
		return studentServiceImpl.deleteById(id);
	}

}
