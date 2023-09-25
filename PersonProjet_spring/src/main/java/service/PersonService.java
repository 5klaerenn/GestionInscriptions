package service;

import model.Person;

import java.util.List;

public interface PersonService {

    void createPerson(Person person);

    Person getPersonById(int id);

    List<Person> getAllPersons();

    void updatePerson(Person person);

    void deletePerson(int id);
}
