package org.example.educational_portal.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.educational_portal.entities.Student;

import java.util.Date;

/**
 * POJO-класс для сущности Студент
 **/
@Getter
@Setter
public class StudentPojo {

	private long id;
	private String fio;
	private Date birthday;
	private String email;
	private String group;

	public static StudentPojo fromEntity(Student student) {
		StudentPojo studentPojo = new StudentPojo();
		studentPojo.setId(student.getId());
		studentPojo.setFio(student.getFio());
		studentPojo.setBirthday(student.getBirthday());
		studentPojo.setEmail(student.getEmail());
		studentPojo.setGroup(student.getGroup());

		return studentPojo;
	}

	public static Student toEntity(StudentPojo studentPojo) {
		Student student = new Student();
		student.setId(studentPojo.getId());
		student.setFio(studentPojo.getFio());
		student.setBirthday(studentPojo.getBirthday());
		student.setEmail(studentPojo.getEmail());
		student.setGroup(studentPojo.getGroup());

		return student;
	}

	public static Student getSimpleEntityInfo(Student student) {
		Student simpleStudent = new Student();

		simpleStudent.setId(student.getId());
		simpleStudent.setFio(student.getFio());

		return simpleStudent;
	}

}
