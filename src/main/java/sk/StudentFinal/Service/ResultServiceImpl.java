package sk.StudentFinal.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.StudentFinal.dao.ResultRepository;
import sk.StudentFinal.model.Course;
import sk.StudentFinal.model.Result;
import sk.StudentFinal.model.ResultId;

import java.util.List;
import java.util.Optional;

@Service
public class ResultServiceImpl implements GenericService<Result, ResultId> {

    private ResultRepository resRepo;
    @Autowired
    public ResultServiceImpl(ResultRepository resRepo){this.resRepo = resRepo;}

    @Override
    public Optional<Result> findById(ResultId resultId) {
        Optional<Result> result = resRepo.findById(resultId);
        Result resultat;

        if (result.isPresent()){
            resultat= result.get();
        } else {
            throw new RuntimeException("Did not find resultat id - " + resultId.toString());
        }

        return Optional.of(resultat);
    }

    @Override
    public List<Result> findAll() {
        return resRepo.findAll();
    }

    @Override
    public void save(Result result) {
        resRepo.save(result);
    }

    @Override
    public void deleteById(ResultId resultId) {
        resRepo.deleteById(resultId);
    }

    public List<Result> getResultByStudentId(int studentId) {
        return resRepo.findResultByStudent_StudentId(studentId);
    }

    public List<Result> getResultByCourses(String courseId) {
        return resRepo.findResultByCourse_CourseId(courseId);
    }
    public Result getResultById(ResultId resultId)  {
        return resRepo.findResultById(resultId);
    }


}
