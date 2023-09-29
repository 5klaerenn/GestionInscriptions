package sk.StudentFinal.dao.JPAHibernate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import sk.StudentFinal.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class StudentDaoImpl implements GenericDao<Student, Integer> {

    private EntityManager entityManager;

    @Autowired
    public StudentDaoImpl(EntityManager entityManager){this.entityManager = entityManager;}

    @Override
    public Optional<Student> findById(Integer id) {
        Student student = entityManager.find(Student.class, id);
        return Optional.ofNullable(student);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = entityManager.createQuery(
                "FROM Student", Student.class);

        return query.getResultList();
    }

    @Override
    @Transactional
    public void create(Student student) {
        entityManager.persist(student);
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);

    }
}
