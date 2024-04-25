package org.example.educational_portal.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.educational_portal.entities.Course;
import org.example.educational_portal.entities.Material;
import org.example.educational_portal.entities.Teacher;

/**
 * POJO-класс для сущности Курс
 **/
@Getter
@Setter
public class CoursePojo {

	private long id;
	private String name;
	private String duration;
	private String description;

	private Teacher teacher;
	private Material material;

	public static CoursePojo fromEntity(Course course) {
		CoursePojo coursePojo = new CoursePojo();
		coursePojo.setId(course.getId());
		coursePojo.setName(course.getName());
		coursePojo.setDuration(course.getDuration());
		coursePojo.setDescription(course.getDescription());

		if (course.getTeacher() != null) {
			coursePojo.setTeacher(TeacherPojo.getSimpleEntityInfo(course.getTeacher()));
		}

		if (course.getMaterial() != null) {
			coursePojo.setMaterial(MaterialPojo.getSimpleEntityInfo(course.getMaterial()));
		}

		return coursePojo;
	}

	public static Course toEntity(CoursePojo coursePojo) {
		Course course = new Course();
		course.setId(coursePojo.getId());
		course.setName(coursePojo.getName());
		course.setDuration(coursePojo.getDuration());
		course.setDescription(coursePojo.getDescription());

		return course;
	}

	public static Course getSimpleEntityInfo(Course course) {
		Course simpleCourse = new Course();

		simpleCourse.setId(course.getId());
		simpleCourse.setName(course.getName());

		return simpleCourse;
	}

}
