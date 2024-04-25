package org.example.educational_portal.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.educational_portal.enums.MaterialType;

import java.util.List;

/**
 * Класс сущности Учебный материал
 **/
@Getter
@Setter
@Entity
@Table(name = "materials", uniqueConstraints = {@UniqueConstraint(columnNames = {"id", "name"})})
public class Material {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "type", nullable = false)
	private MaterialType type;

	@Column(name = "link")
	private String link;

	@OneToMany(mappedBy = "material", fetch = FetchType.LAZY)
	private List<Course> courses;

}
