package sk.StudentFinal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.StudentFinal.model.Course;

public interface CourseRepository extends JpaRepository<Course, String> {
}
