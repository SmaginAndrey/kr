package org.example.educational_portal.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.educational_portal.entities.Course;
import org.example.educational_portal.entities.Mark;
import org.example.educational_portal.entities.Student;
import org.example.educational_portal.enums.MarkType;

import java.util.Date;

/**
 * POJO-класс для сущности Оценка
 **/
@Getter
@Setter
public class MarkPojo {

	private long id;
	private Date date;
	private MarkType value;

	private Course course;
	private Student student;

	public static MarkPojo fromEntity(Mark mark) {
		MarkPojo markPojo = new MarkPojo();
		markPojo.setId(mark.getId());
		markPojo.setValue(mark.getValue());
		markPojo.setDate(mark.getDate());

		if (mark.getCourse() != null) {
			markPojo.setCourse(CoursePojo.getSimpleEntityInfo(mark.getCourse()));
		}

		if (mark.getStudent() != null) {
			markPojo.setStudent(StudentPojo.getSimpleEntityInfo(mark.getStudent()));
		}

		return markPojo;
	}

	public static Mark toEntity(MarkPojo markPojo) {
		Mark mark = new Mark();
		mark.setId(markPojo.getId());
		mark.setValue(markPojo.getValue());
		mark.setDate(markPojo.getDate());

		return mark;
	}

}
