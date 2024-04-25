package org.example.educational_portal.repositories;

import org.example.educational_portal.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Интерфейс репозитория для сущности Курс
 **/
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
