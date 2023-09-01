package sk.StudentFinal.Service;

import sk.StudentFinal.model.Student;

import java.util.List;
import java.util.Optional;

public interface GenericService<T, ID> {

    Optional<T> findById(ID id);

    List<T> findAll();

    Student create(T t);

    Student update(T t);

    void delete(ID id);
}
