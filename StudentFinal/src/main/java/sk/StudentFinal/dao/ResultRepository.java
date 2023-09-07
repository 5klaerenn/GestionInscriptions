package sk.StudentFinal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.StudentFinal.Service.GenericService;
import sk.StudentFinal.model.Result;

public interface ResultRepository extends JpaRepository<Result, String> {


}
