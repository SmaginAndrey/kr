package org.example.educational_portal.repositories;

import org.example.educational_portal.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Интерфейс репозитория для сущности Студент
 **/
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
