package DaoImp;

import config.HibernateConf;
import interfaceDao.PersonDao;
import java.util.ArrayList;
import java.util.List;
import model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

//        Session session = null;
//        Transaction transaction = null;
//        
//    // Constructor 
//    public PersonDAOImplementation() {
//
//    }

public class PersonDAOImplementation implements PersonDao{
    
    private SessionFactory sessionFactory;
   
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void create(Person person) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(person);
    }
        
    @Override
    public Person findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Person.class, id);
    }
    
    @Override
    public List<Person> findAll() {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Person p ORDER BY p.id";
        return session.createQuery(hql, Person.class).getResultList();
    }
    
    

    @Override
    @Transactional
    public void update(Person person) {
        Session session = sessionFactory.getCurrentSession();
        session.merge(person);
        
    }

    @Override
    @Transactional
    public void delete(int id) {
        
        Session session = sessionFactory.getCurrentSession();
        Person person = session.get(Person.class, id);
        session.remove(person);
    }   

}
