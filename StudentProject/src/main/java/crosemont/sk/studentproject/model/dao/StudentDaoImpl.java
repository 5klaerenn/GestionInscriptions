package crosemont.sk.studentproject.model.dao;

import crosemont.sk.studentproject.model.entity.Student;
import org.hibernate.*;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class StudentDaoImpl implements StudentDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Student student) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.save(student);
        tx.commit();
    }

    @Override
    public void update(Student student) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.update(student);
        tx.commit();
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        Student student = session.get(Student.class, id);
        if (student != null) {
            session.delete(student);
        }
        tx.commit();
    }

    @Override
    public List<Student> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query<Student> query =
                session.createQuery("from Student", Student.class);
        List<Student> students = query.getResultList();
        tx.commit();
        return students;
    }

    @Override
    public Student findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        Student student = session.get(Student.class, id);
        tx.commit();
        return student;
    }

}
