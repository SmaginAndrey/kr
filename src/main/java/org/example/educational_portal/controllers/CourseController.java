package org.example.educational_portal.controllers;

import lombok.AllArgsConstructor;
import org.example.educational_portal.dto.CoursePojo;
import org.example.educational_portal.services.CourseServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Контроллер для работы с Курсами
 **/
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/courses")
@AllArgsConstructor
public class CourseController {

	private final CourseServiceImpl courseServiceImpl;

	@GetMapping
	public List<CoursePojo> findAllCourses() {
		return courseServiceImpl.findAll();
	}

	@GetMapping("/{id}")
	public CoursePojo findCourseById(@PathVariable long id) {
		return courseServiceImpl.findById(id);
	}

	@PostMapping
	public CoursePojo createAndAddNewCourse(@RequestBody CoursePojo pojo) {
		return courseServiceImpl.createOrUpdate(pojo);
	}

	@PutMapping
	public CoursePojo updateCourse(@RequestBody CoursePojo pojo) {
		return courseServiceImpl.createOrUpdate(pojo);
	}

	@DeleteMapping
	public boolean deleteCourseById(@RequestParam long id) {
		return courseServiceImpl.deleteById(id);
	}

}
