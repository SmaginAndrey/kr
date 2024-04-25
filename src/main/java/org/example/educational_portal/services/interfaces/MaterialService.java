package org.example.educational_portal.services.interfaces;

import org.example.educational_portal.dto.MaterialPojo;

import java.util.List;

/**
 * Интерфейс сервиса для сущности Учебный материал
 */
public interface MaterialService {

	List<MaterialPojo> findAll();

	MaterialPojo findById(long id);

	MaterialPojo createOrUpdate(MaterialPojo pojo);

	boolean deleteById(long id);

}
