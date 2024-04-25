package org.example.educational_portal.services.interfaces;

import org.example.educational_portal.dto.MarkPojo;

import java.util.List;

/**
 * Интерфейс сервиса для сущности Оценка
 */
public interface MarkService {

	List<MarkPojo> findAll();

	MarkPojo findById(long id);

	MarkPojo createOrUpdate(MarkPojo pojo);

	boolean deleteById(long id);

}
