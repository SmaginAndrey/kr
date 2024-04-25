package org.example.educational_portal.services;

import lombok.RequiredArgsConstructor;
import org.example.educational_portal.dto.MaterialPojo;
import org.example.educational_portal.entities.Course;
import org.example.educational_portal.entities.Material;
import org.example.educational_portal.repositories.CourseRepository;
import org.example.educational_portal.repositories.MaterialRepository;
import org.example.educational_portal.services.interfaces.MaterialService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Реализация интерфейса для работы с объектом Учебный материал
 **/
@Service
@RequiredArgsConstructor
public class MaterialServiceImpl implements MaterialService {

	private final MaterialRepository materialRepository;
	private final CourseRepository courseRepository;

	@Override
	@Transactional
	public List<MaterialPojo> findAll() {
		List<MaterialPojo> result = new ArrayList<>();

		for (Material material : materialRepository.findAll()) {
			result.add(MaterialPojo.fromEntity(material));
		}

		return result;
	}

	@Override
	@Transactional
	public MaterialPojo findById(long id) {
		return MaterialPojo.fromEntity(materialRepository.findById(id).orElseThrow());
	}

	@Override
	@Transactional
	public MaterialPojo createOrUpdate(MaterialPojo materialPojo) {
		Material material = MaterialPojo.toEntity(materialPojo);

		return MaterialPojo.fromEntity(materialRepository.save(material));
	}

	@Override
	@Transactional
	public boolean deleteById(long id) {
		if (materialRepository.existsById(id)) {
			// На учебный материал может ссылаться курс, поэтому при удалении материала
			// также небходимо обнулить ссылку на этот материал у курса
			final List<Course> coursesList = courseRepository.findAll();
			for (Course course : coursesList) {
				if (course.getMaterial().getId() == id) {
					course.setMaterial(null);
					courseRepository.save(course);
				}
			}

			materialRepository.deleteById(id);

			return true;
		}

		return false;
	}

}
