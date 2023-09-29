package DaoImp;

import connection.HibernateUtil;
import interfaceDao.PersonDao;
import java.util.ArrayList;
import java.util.List;
import model.Person;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


public class PersonDAOImplementation implements PersonDao{
    
        Session session = null;
        Transaction transaction = null;
        
    // Constructor 
    public PersonDAOImplementation() {

    }

    // Create a new Person
    public void create(Person person) {

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            // Save the person entity
            session.persist(person);

            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
        
    @Override
    public Person findById(int id) {
        
        Person person = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            // Retrieve the person entity by id
            person = session.get(Person.class, id);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return person;
    }
    
    
    @Override
     public List<Person> findAll() {

        List<Person> persons = new ArrayList<>();

        try {
            session = HibernateUtil.getSessionFactory().openSession();

            // Create an HQL query to retrieve all Person entities
            String hql = "FROM Person p ORDER BY p.id";
            Query<Person> query = session.createQuery(hql, Person.class);
            persons = query.getResultList();

        } catch (Exception ex) {
            ex.printStackTrace();

        } finally {
            if (session != null) {
                session.close();
            }
        }

        return persons;
    }
    
    

    // Update person's info
    public void update(Person person) {
        
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            // Update the person entity
            session.merge(person);

            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    // Delete person
    public void delete(int id) {

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            // Retrieve the person entity by id
            Person person = session.get(Person.class, id);

            if (person != null) {
                // Delete the person entity
                session.remove(person);
            }

            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

}
