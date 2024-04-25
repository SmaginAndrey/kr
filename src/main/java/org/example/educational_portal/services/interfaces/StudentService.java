package org.example.educational_portal.services.interfaces;

import org.example.educational_portal.dto.StudentPojo;

import java.util.List;

/**
 * Интерфейс сервиса для сущности Студент
 */
public interface StudentService {

	List<StudentPojo> findAll();

	StudentPojo findById(long id);

	StudentPojo createOrUpdate(StudentPojo pojo);

	boolean deleteById(long id);

}
