package org.example.educational_portal.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.educational_portal.enums.MarkType;

import java.util.Date;

/**
 * Класс сущности Оценка
 **/
@Getter
@Setter
@Entity
@Table(name = "marks", uniqueConstraints = {@UniqueConstraint(columnNames = "id")})
public class Mark {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "value", nullable = false)
	private MarkType value;

	@Column(name = "date", nullable = false)
	private Date date;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "course_id", foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
	private Course course;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_id", foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
	private Student student;

}
