package sk.StudentFinal.dao.JPAHibernate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sk.StudentFinal.model.Result;

import java.util.List;
import java.util.Optional;

@Repository
public class ResultDaoImpl implements GenericDao<Result, String> {

    EntityManager entityManager;
    @Autowired
    public ResultDaoImpl(EntityManager entityManager){this.entityManager = entityManager;}


    @Override
    public Optional<Result> findById(String id) {
        Result result = entityManager.find(Result.class, id);
        return Optional.ofNullable(result);
    }

    @Override
    public List<Result> findAll() {
        TypedQuery<Result> query = entityManager.createQuery(
                "FROM Result", Result.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void create(Result result) {
        entityManager.persist(result);
    }

    @Override
    @Transactional
    public void update(Result result) {
        entityManager.merge(result);
    }

    @Override
    @Transactional
    public void delete(String id) {
        Result result = entityManager.find(Result.class, id);
        entityManager.remove(result);
    }
}
