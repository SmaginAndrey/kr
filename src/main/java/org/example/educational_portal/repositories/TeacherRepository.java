package org.example.educational_portal.repositories;

import org.example.educational_portal.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Интерфейс репозитория для сущности Учитель
 **/
@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
