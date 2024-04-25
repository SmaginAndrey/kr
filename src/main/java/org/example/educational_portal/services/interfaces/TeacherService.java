package org.example.educational_portal.services.interfaces;

import org.example.educational_portal.dto.TeacherPojo;

import java.util.List;

/**
 * Интерфейс сервиса для сущности Учитель
 */
public interface TeacherService {

	List<TeacherPojo> findAll();

	TeacherPojo findById(long id);

	TeacherPojo createOrUpdate(TeacherPojo pojo);

	boolean deleteById(long id);

}
