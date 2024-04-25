package org.example.educational_portal.services;

import lombok.RequiredArgsConstructor;
import org.example.educational_portal.dto.StudentPojo;
import org.example.educational_portal.entities.Mark;
import org.example.educational_portal.entities.Student;
import org.example.educational_portal.repositories.MarkRepository;
import org.example.educational_portal.repositories.StudentRepository;
import org.example.educational_portal.services.interfaces.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Реализация интерфейса для работы с объектом Студент
 **/
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

	private final StudentRepository studentRepository;
	private final MarkRepository markRepository;

	@Override
	@Transactional
	public List<StudentPojo> findAll() {
		List<StudentPojo> result = new ArrayList<>();

		for (Student student : studentRepository.findAll()) {
			result.add(StudentPojo.fromEntity(student));
		}

		return result;
	}

	@Override
	@Transactional
	public StudentPojo findById(long id) {
		return StudentPojo.fromEntity(studentRepository.findById(id).orElseThrow());
	}

	@Override
	@Transactional
	public StudentPojo createOrUpdate(StudentPojo studentPojo) {
		final Student student = StudentPojo.toEntity(studentPojo);

		return StudentPojo.fromEntity(studentRepository.save(student));
	}

	@Override
	@Transactional
	public boolean deleteById(long id) {
		if (studentRepository.existsById(id)) {
			// На студента может ссылаться оценка, поэтому при удалении студента
			// также небходимо обнулить ссылку на этого студента у оценки
			final List<Mark> marksList = markRepository.findAll();
			for (Mark mark : marksList) {
				if (mark.getStudent().getId() == id) {
					mark.setStudent(null);
					markRepository.save(mark);
				}
			}

			studentRepository.deleteById(id);

			return true;
		}

		return false;
	}

}
