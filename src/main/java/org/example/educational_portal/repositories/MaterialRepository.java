package org.example.educational_portal.repositories;

import org.example.educational_portal.entities.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Интерфейс репозитория для сущности Учебный материал
 **/
@Repository
public interface MaterialRepository extends JpaRepository<Material, Long> {

}
