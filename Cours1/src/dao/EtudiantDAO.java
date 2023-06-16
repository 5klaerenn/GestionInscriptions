/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import model.Etudiant;
import java.util.ArrayList;

/**
 *
 * @author Sklaerenn
 */
public interface EtudiantDAO {
    
    public abstract void create(Etudiant e);
    public abstract void update(Etudiant e);
    public abstract void delete(int id);
    public abstract Etudiant findById(int id);
    public abstract ArrayList<Etudiant> findAll();
    
    
}
