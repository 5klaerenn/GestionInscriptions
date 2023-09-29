package sk.StudentFinal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.StudentFinal.model.Result;
import sk.StudentFinal.model.ResultId;

import java.util.List;

public interface ResultRepository extends JpaRepository<Result, ResultId> {

    List<Result> findResultByStudent_StudentId(int studentId);

    List<Result> findResultByCourse_CourseId(String courseId);
    Result findResultById(ResultId resultId);


}

