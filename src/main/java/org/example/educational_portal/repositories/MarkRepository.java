package org.example.educational_portal.repositories;

import org.example.educational_portal.entities.Mark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Интерфейс репозитория для сущности Оценка
 **/
@Repository
public interface MarkRepository extends JpaRepository<Mark, Long> {

}
