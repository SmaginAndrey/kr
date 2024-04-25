package org.example.educational_portal.services;

import lombok.RequiredArgsConstructor;
import org.example.educational_portal.dto.MarkPojo;
import org.example.educational_portal.entities.Course;
import org.example.educational_portal.entities.Mark;
import org.example.educational_portal.entities.Student;
import org.example.educational_portal.repositories.CourseRepository;
import org.example.educational_portal.repositories.MarkRepository;
import org.example.educational_portal.repositories.StudentRepository;
import org.example.educational_portal.services.interfaces.MarkService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Реализация интерфейса для работы с объектом Оценка
 **/
@Service
@RequiredArgsConstructor
public class MarkServiceImpl implements MarkService {

	private final MarkRepository markRepository;
	private final CourseRepository courseRepository;
	private final StudentRepository studentRepository;

	@Override
	@Transactional
	public List<MarkPojo> findAll() {
		List<MarkPojo> result = new ArrayList<>();

		for (Mark mark : markRepository.findAll()) {
			result.add(MarkPojo.fromEntity(mark));
		}

		return result;
	}

	@Override
	@Transactional
	public MarkPojo findById(long id) {
		return MarkPojo.fromEntity(markRepository.findById(id).orElseThrow());
	}

	@Override
	@Transactional
	public MarkPojo createOrUpdate(MarkPojo markPojo) {
		final Mark mark = MarkPojo.toEntity(markPojo);
		final Course markCourse = markPojo.getCourse();
		final Student markStudent = markPojo.getStudent();

		if (markCourse != null) {
			final Course courseInfo = courseRepository.findById(markCourse.getId()).orElse(null);
			mark.setCourse(courseInfo);
		}

		if (markStudent != null) {
			final Student studentInfo = studentRepository.findById(markStudent.getId()).orElse(null);
			mark.setStudent(studentInfo);
		}

		return MarkPojo.fromEntity(markRepository.save(mark));
	}

	@Override
	@Transactional
	public boolean deleteById(long id) {
		if (markRepository.existsById(id)) {
			markRepository.deleteById(id);

			return true;
		}

		return false;
	}

}
