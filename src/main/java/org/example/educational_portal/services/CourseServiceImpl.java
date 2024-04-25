package org.example.educational_portal.services;

import lombok.RequiredArgsConstructor;
import org.example.educational_portal.dto.CoursePojo;
import org.example.educational_portal.entities.Course;
import org.example.educational_portal.entities.Mark;
import org.example.educational_portal.entities.Material;
import org.example.educational_portal.entities.Teacher;
import org.example.educational_portal.repositories.CourseRepository;
import org.example.educational_portal.repositories.MarkRepository;
import org.example.educational_portal.repositories.MaterialRepository;
import org.example.educational_portal.repositories.TeacherRepository;
import org.example.educational_portal.services.interfaces.CourseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Реализация интерфейса для работы с объектом Курс
 **/
@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

	private final CourseRepository courseRepository;
	private final TeacherRepository teacherRepository;
	private final MaterialRepository materialRepository;
	private final MarkRepository markRepository;

	@Override
	@Transactional
	public List<CoursePojo> findAll() {
		List<CoursePojo> result = new ArrayList<>();

		for (Course course : courseRepository.findAll()) {
			result.add(CoursePojo.fromEntity(course));
		}

		return result;
	}

	@Override
	@Transactional
	public CoursePojo findById(long id) {
		return CoursePojo.fromEntity(courseRepository.findById(id).orElseThrow());
	}

	@Override
	@Transactional
	public CoursePojo createOrUpdate(CoursePojo coursePojo) {
		final Course course = CoursePojo.toEntity(coursePojo);
		final Teacher courseTeacher = coursePojo.getTeacher();
		final Material courseMaterial = coursePojo.getMaterial();

		if (courseTeacher != null) {
			final Teacher teacherInfo = teacherRepository.findById(courseTeacher.getId()).orElse(null);
			course.setTeacher(teacherInfo);
		}

		if (courseMaterial != null) {
			final Material materialInfo = materialRepository.findById(courseMaterial.getId()).orElse(null);
			course.setMaterial(materialInfo);
		}

		return CoursePojo.fromEntity(courseRepository.save(course));
	}

	@Override
	@Transactional
	public boolean deleteById(long id) {
		if (courseRepository.existsById(id)) {
			// На Курс может ссылаться оценка, поэтому при удалении курса
			// также небходимо обнулить ссылку на него у оценки
			final List<Mark> marksList = markRepository.findAll();
			for (Mark mark : marksList) {
				if (mark.getCourse().getId() == id) {
					mark.setCourse(null);
					markRepository.save(mark);
				}
			}

			courseRepository.deleteById(id);

			return true;
		}

		return false;
	}

}
