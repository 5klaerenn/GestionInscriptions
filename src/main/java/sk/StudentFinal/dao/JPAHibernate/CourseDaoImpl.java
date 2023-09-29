package sk.StudentFinal.dao.JPAHibernate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sk.StudentFinal.model.Course;

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
    @Transactional
    public void create(Course course) {
        entityManager.persist(course);
    }

    @Override
    @Transactional
    public void update(Course course) {
        entityManager.merge(course);
    }

    @Override
    @Transactional
    public void delete(String id) {
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);
    }
}
