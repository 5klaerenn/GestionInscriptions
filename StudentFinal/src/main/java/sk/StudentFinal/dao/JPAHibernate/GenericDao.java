package sk.StudentFinal.dao.JPAHibernate;

import sk.StudentFinal.model.Student;

import java.util.List;
import java.util.Optional;

public interface GenericDao<T, ID> {

    Optional<T> findById(ID id);

    List<T> findAll();

    void create(T t);

    void update(T t);

    void delete(ID id);
}
