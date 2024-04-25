package org.example.educational_portal.controllers;

import lombok.AllArgsConstructor;
import org.example.educational_portal.dto.MaterialPojo;
import org.example.educational_portal.services.MaterialServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Контроллер для работы с Учебными материалами
 **/
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/materials")
@AllArgsConstructor
public class MaterialController {

	private final MaterialServiceImpl materialServiceImpl;

	@GetMapping
	public List<MaterialPojo> findAllMaterials() {
		return materialServiceImpl.findAll();
	}

	@GetMapping("/{id}")
	public MaterialPojo findMaterialById(@PathVariable long id) {
		return materialServiceImpl.findById(id);
	}

	@PostMapping
	public MaterialPojo createAndAddNewMaterial(@RequestBody MaterialPojo pojo) {
		return materialServiceImpl.createOrUpdate(pojo);
	}

	@PutMapping
	public MaterialPojo updateMaterial(@RequestBody MaterialPojo pojo) {
		return materialServiceImpl.createOrUpdate(pojo);
	}

	@DeleteMapping
	public boolean deleteMaterialById(@RequestParam long id) {
		return materialServiceImpl.deleteById(id);
	}

}
