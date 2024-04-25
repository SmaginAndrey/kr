package org.example.educational_portal.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.educational_portal.entities.Teacher;

/**
 * POJO-класс для сущности Учитель
 **/
@Getter
@Setter
public class TeacherPojo {

	private long id;
	private String fio;
	private String email;
	private String specialization;

	public static TeacherPojo fromEntity(Teacher teacher) {
		TeacherPojo teacherPojo = new TeacherPojo();
		teacherPojo.setId(teacher.getId());
		teacherPojo.setFio(teacher.getFio());
		teacherPojo.setEmail(teacher.getEmail());
		teacherPojo.setSpecialization(teacher.getSpecialization());

		return teacherPojo;
	}

	public static Teacher toEntity(TeacherPojo teacherPojo) {
		Teacher teacher = new Teacher();
		teacher.setId(teacherPojo.getId());
		teacher.setFio(teacherPojo.getFio());
		teacher.setEmail(teacherPojo.getEmail());
		teacher.setSpecialization(teacherPojo.getSpecialization());

		return teacher;
	}

	public static Teacher getSimpleEntityInfo(Teacher teacher) {
		Teacher simpleTeacher = new Teacher();

		simpleTeacher.setId(teacher.getId());
		simpleTeacher.setFio(teacher.getFio());

		return simpleTeacher;
	}

}
