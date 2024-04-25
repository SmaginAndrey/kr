package org.example.educational_portal.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * Класс сущности Студент
 **/
@Getter
@Setter
@Entity
@Table(name = "students", uniqueConstraints = {@UniqueConstraint(columnNames = {"id", "fio", "birthday", "email"})})
public class Student {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "fio", nullable = false)
	private String fio;

	@Column(name = "birthday", nullable = false)
	private Date birthday;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "student_group", nullable = false)
	private String group;

	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
	private List<Mark> marks;

}
