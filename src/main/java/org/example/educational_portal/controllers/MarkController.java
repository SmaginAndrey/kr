package org.example.educational_portal.controllers;

import lombok.AllArgsConstructor;
import org.example.educational_portal.dto.MarkPojo;
import org.example.educational_portal.services.MarkServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Контроллер для работы с Оценками
 **/
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/marks")
@AllArgsConstructor
public class MarkController {

	private final MarkServiceImpl markServiceImpl;

	@GetMapping
	public List<MarkPojo> findAllMarks() {
		return markServiceImpl.findAll();
	}

	@GetMapping("/{id}")
	public MarkPojo findMarkById(@PathVariable long id) {
		return markServiceImpl.findById(id);
	}

	@PostMapping
	public MarkPojo createAndAddNewMark(@RequestBody MarkPojo pojo) {
		return markServiceImpl.createOrUpdate(pojo);
	}

	@PutMapping
	public MarkPojo updateMark(@RequestBody MarkPojo pojo) {
		return markServiceImpl.createOrUpdate(pojo);
	}

	@DeleteMapping
	public boolean deleteMarkById(@RequestParam long id) {
		return markServiceImpl.deleteById(id);
	}

}
