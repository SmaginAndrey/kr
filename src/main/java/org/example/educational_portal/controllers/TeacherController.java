package org.example.educational_portal.controllers;

import lombok.AllArgsConstructor;
import org.example.educational_portal.dto.TeacherPojo;
import org.example.educational_portal.services.TeacherServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Контроллер для работы с Учителями
 **/
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/teachers")
@AllArgsConstructor
public class TeacherController {

	private final TeacherServiceImpl teacherServiceImpl;

	@GetMapping
	public List<TeacherPojo> findAllTeachers() {
		return teacherServiceImpl.findAll();
	}

	@GetMapping("/{id}")
	public TeacherPojo findTeacherById(@PathVariable long id) {
		return teacherServiceImpl.findById(id);
	}

	@PostMapping
	public TeacherPojo createAndAddNewTeacher(@RequestBody TeacherPojo pojo) {
		return teacherServiceImpl.createOrUpdate(pojo);
	}

	@PutMapping
	public TeacherPojo updateTeacher(@RequestBody TeacherPojo pojo) {
		return teacherServiceImpl.createOrUpdate(pojo);
	}

	@DeleteMapping
	public boolean deleteTeacherById(@RequestParam long id) {
		return teacherServiceImpl.deleteById(id);
	}

}
