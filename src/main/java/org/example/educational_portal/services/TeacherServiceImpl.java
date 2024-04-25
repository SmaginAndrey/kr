package org.example.educational_portal.services;

import lombok.RequiredArgsConstructor;
import org.example.educational_portal.dto.TeacherPojo;
import org.example.educational_portal.entities.Course;
import org.example.educational_portal.entities.Teacher;
import org.example.educational_portal.repositories.CourseRepository;
import org.example.educational_portal.repositories.TeacherRepository;
import org.example.educational_portal.services.interfaces.TeacherService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Реализация интерфейса для работы с объектом Учитель
 **/
@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

	private final TeacherRepository teacherRepository;
	private final CourseRepository courseRepository;

	@Override
	@Transactional
	public List<TeacherPojo> findAll() {
		List<TeacherPojo> result = new ArrayList<>();

		for (Teacher teacher : teacherRepository.findAll()) {
			result.add(TeacherPojo.fromEntity(teacher));
		}

		return result;
	}

	@Override
	@Transactional
	public TeacherPojo findById(long id) {
		return TeacherPojo.fromEntity(teacherRepository.findById(id).orElseThrow());
	}

	@Override
	@Transactional
	public TeacherPojo createOrUpdate(TeacherPojo teacherPojo) {
		Teacher teacher = TeacherPojo.toEntity(teacherPojo);

		return TeacherPojo.fromEntity(teacherRepository.save(teacher));
	}

	@Override
	@Transactional
	public boolean deleteById(long id) {
		if (teacherRepository.existsById(id)) {
			// На учителя может ссылаться курс, поэтому при удалении учителя
			// также небходимо обнулить ссылку на этого учителя у курса
			final List<Course> coursesList = courseRepository.findAll();
			for (Course course : coursesList) {
				if (course.getTeacher().getId() == id) {
					course.setTeacher(null);
					courseRepository.save(course);
				}
			}

			teacherRepository.deleteById(id);

			return true;
		}

		return false;
	}

}
