package org.example.educational_portal.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.educational_portal.entities.Material;
import org.example.educational_portal.enums.MaterialType;

/**
 * POJO-класс для сущности Учебный материал
 **/
@Getter
@Setter
public class MaterialPojo {

	private long id;
	private String name;
	private MaterialType type;
	private String link;

	public static MaterialPojo fromEntity(Material material) {
		MaterialPojo materialPojo = new MaterialPojo();
		materialPojo.setId(material.getId());
		materialPojo.setName(material.getName());
		materialPojo.setType(material.getType());
		materialPojo.setLink(material.getLink());

		return materialPojo;
	}

	public static Material toEntity(MaterialPojo materialPojo) {
		Material material = new Material();
		material.setId(materialPojo.getId());
		material.setName(materialPojo.getName());
		material.setType(materialPojo.getType());
		material.setLink(materialPojo.getLink());

		return material;
	}

	public static Material getSimpleEntityInfo(Material material) {
		Material simpleMaterial = new Material();

		simpleMaterial.setId(material.getId());
		simpleMaterial.setName(material.getName());

		return simpleMaterial;
	}

}
