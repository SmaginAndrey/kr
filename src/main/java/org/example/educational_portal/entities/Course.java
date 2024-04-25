package org.example.educational_portal.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Класс сущности Курс
 **/
@Getter
@Setter
@Entity
@Table(name = "courses", uniqueConstraints = {@UniqueConstraint(columnNames = {"id", "name"})})
public class Course {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "duration", nullable = false)
	private String duration;

	@Column(name = "description", nullable = false)
	private String description;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "teacher_id", foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
	private Teacher teacher;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "material_id", foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
	private Material material;

	@OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
	private List<Mark> marks;

}
