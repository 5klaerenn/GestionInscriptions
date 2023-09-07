package sk.StudentFinal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.StudentFinal.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
