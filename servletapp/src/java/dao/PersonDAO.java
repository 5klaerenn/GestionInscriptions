/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dao;

import model.Person;
import java.util.List;

/**
 *
 * @author Sklaerenn
 */
public interface PersonDAO {
    
    void create(Person p);
    
    void update(Person p);
    
    void delete(String id);

    List<Person> findAll();

    Person findById(String id);

}
