package service;

import DaoImp.PersonDAOImplementation;
import model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDAOImplementation personDao;

    @Override
    public void createPerson(Person person) {
        personDao.create(person);
    }

    @Override
    public Person getPersonById(int id) {
        return personDao.findById(id);
    }

    @Override
    public List<Person> getAllPersons() {
        return personDao.findAll();
    }

    @Override
    public void updatePerson(Person person) {
        personDao.update(person);
    }

    @Override
    public void deletePerson(int id) {
        personDao.delete(id);
    }
}
