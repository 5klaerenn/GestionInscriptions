/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Sklaerenn
 */
public class ViewMenu extends JFrame implements ActionListener{
    
    JPanel p = new JPanel();
    JLabel lab1;
    JButton btn1, btn2, btn3, btn4, btn5, btn6;
    
    
    public ViewMenu(){
        
        this.setTitle("Gestion des étudiants");        
        this.setSize(500, 500);
        this.setDefaultCloseOperation(3); 
        p.setLayout(new GridLayout(7,1));
         
        lab1 = new JLabel("Faites votre choix");
        p.add(lab1);
        
        btn1 = new JButton("Ajouter un étudiant");
        p.add(btn1);

        btn2 = new JButton("Modifier un étudiant");
        p.add(btn2);

        btn3 = new JButton("Supprimer un étudiant");
        p.add(btn3);

        btn4 = new JButton("Afficher les étudiants");
        p.add(btn4);

        btn5 = new JButton("Rechercher un étudiant");
        p.add(btn5);

        btn6 = new JButton("Quitter");
        p.add(btn6);
        
        this.add(p);
        
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        btn5.addActionListener(this);
        btn6.addActionListener(this);

        
    }
    
    public void actionPerformed(ActionEvent e){

        
        
    } 
    

}
