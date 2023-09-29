package sk.StudentFinal.Service;

import sk.StudentFinal.model.Result;

import java.util.List;
import java.util.Optional;

public interface GenericService<T, ID> {

    Optional<T> findById(ID id);

    List<T> findAll();

    void save(T t);

    void deleteById(ID id);
}
