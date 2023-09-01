package sk.StudentFinal.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sk.StudentFinal.model.Course;
import sk.StudentFinal.model.Student;

import java.util.List;
import java.util.Optional;

@Repository
public class CourseDaoImpl implements GenericDao<Course, String> {

    private EntityManager entityManager;

    @Autowired
    public CourseDaoImpl(EntityManager entityManager){this.entityManager = entityManager;}

    @Override
    public Optional<Course> findById(String id) {
        Course course = entityManager.find(Course.class, id);
        return Optional.ofNullable(course);
    }

    @Override
    public List<Course> findAll() {
        TypedQuery<Course> query = entityManager.createQuery(
                "FROM Course", Course.class);

        return query.getResultList();
    }

    @Override
    public void create(Course course) {
        entityManager.persist(course);
    }

    @Override
    public void update(Course course) {
        entityManager.merge(course);
    }

    @Override
    public void delete(String id) {
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);
    }
}
