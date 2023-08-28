package interfaceDao;


import java.util.List;
import model.Person;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public interface PersonDao {
    



    void create(Person p);
    
    void update(Person p);
    
    void delete(int id);

    List<Person> findAll();

    Person findById(int id);
}
