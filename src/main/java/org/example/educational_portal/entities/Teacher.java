package org.example.educational_portal.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Класс сущности Учитель
 **/
@Getter
@Setter
@Entity
@Table(name = "teachers", uniqueConstraints = {@UniqueConstraint(columnNames = {"id", "fio", "email"})})
public class Teacher {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "fio", nullable = false)
	private String fio;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "specialization", nullable = false)
	private String specialization;

	@OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY)
	private List<Course> courses;

}
