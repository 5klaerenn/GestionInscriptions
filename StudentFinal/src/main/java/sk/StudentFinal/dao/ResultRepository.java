package sk.StudentFinal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.StudentFinal.model.Result;

import java.util.List;

public interface ResultRepository extends JpaRepository<Result, String> {

    List<Result> findResultByStudent_StudentId(int studentId);


}

