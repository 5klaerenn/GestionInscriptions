package sk.StudentFinal.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.StudentFinal.dao.ResultRepository;
import sk.StudentFinal.model.Course;
import sk.StudentFinal.model.Result;

import java.util.List;
import java.util.Optional;

@Service
public class ResultServiceImpl implements GenericService<Result, String> {

    private ResultRepository resRepo;
    @Autowired
    public ResultServiceImpl(ResultRepository resRepo){this.resRepo = resRepo;}

    @Override
    public Optional<Result> findById(String id) {
        Optional<Result> result = resRepo.findById(id);
        Result resultat;

        if (result.isPresent()){
            resultat= result.get();
        } else {
            throw new RuntimeException("Did not find resultat id - " + id);
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
    public void deleteById(String id) {
        resRepo.deleteById(id);
    }

    public List<Result> getResultByStudentId(int studentId) {
        return resRepo.findResultByStudent_StudentId(studentId);
    }


}
