package org.example.educational_portal.services.interfaces;

import org.example.educational_portal.dto.CoursePojo;

import java.util.List;

/**
 * Интерфейс сервиса для сущности Курс
 */
public interface CourseService {

	List<CoursePojo> findAll();

	CoursePojo findById(long id);

	CoursePojo createOrUpdate(CoursePojo pojo);

	boolean deleteById(long id);

}
