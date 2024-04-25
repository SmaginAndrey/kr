package org.example.educational_portal.enums;

import lombok.Getter;

/**
 * Перечисление типов учебного матриала
 **/
@Getter
public enum MaterialType {

	LINK("Инетрнет-ресурс"), TEXTBOOK("Учебник"), AUDIO("Аудиоформат");

	private final String code;

	MaterialType(String code) {
		this.code = code;
	}

}
