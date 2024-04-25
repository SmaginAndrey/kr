package org.example.educational_portal.enums;

import lombok.Getter;

/**
 * Перечисление типов оценки
 **/
@Getter
public enum MarkType {

	GREAT(5), GOOD(4), ACCEPTABLE(3), BAD(2);

	private final int mark;

	MarkType(int mark) {
		this.mark = mark;
	}

}
