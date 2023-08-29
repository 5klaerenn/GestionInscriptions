package org.sklaerenn.DaoImpl;

import org.sklaerenn.connection.ConnectionFactory;
import org.sklaerenn.DaoInterface.CoursDao;
import org.sklaerenn.model.Cours;

import java.sql.*;
import java.util.*;

public class CoursDaoImpl implements CoursDao {

    Connection connection = ConnectionFactory.getConnection();

    @Override
    public void create(Cours c) throws SQLException {
    	//Vérification de la contrainte de clé primaire lors de l'ajout d'un nouveau cours
    	String checkQuery = "SELECT * FROM cours WHERE coursId = ?";
	    PreparedStatement checkPs = connection.prepareStatement(checkQuery);
    		checkPs.setString(1, c.getCoursId());

	    	ResultSet rs = checkPs.executeQuery();
	    	
	    if (rs.next()) { // Si l'ID du cours existe déjà, on retourne un message d'erreur et on ramène l'utilisateur à l'écran d'accueil
	        System.out.println("Erreur : L'ID de l'étudiant existe déjà. Veuillez entrer un ID unique.");
	    } else {
	    	String createQuery = "INSERT INTO cours(coursId, nomCours) " +
                "VALUES (?,?)";

	        PreparedStatement ps = connection.prepareStatement(createQuery);
	        ps.setString(1, c.getCoursId());
	        ps.setString(2, c.getNomCours());
        
        	ps.executeUpdate();
        	ps.close();
        
	    }
    }

    @Override
    public Cours findById(String coursId) throws SQLException {
        String findByIdQuery = "SELECT * FROM cours " +
                "WHERE coursId = ? ";
        PreparedStatement ps = connection.prepareStatement(findByIdQuery);
        ps.setString(1, coursId);

        ResultSet rs = ps.executeQuery();
        
        if (!rs.next()) { // Si aucun cours avec cet id n'a été trouvé, on l'indique à l'utilisateur
            System.out.println("Il n'existe pas de cours avec cet ID. Veuillez réessayer.");
            Scanner scanner = new Scanner(System.in);
            boolean found = false;
            
            while (!found) {
            	System.out.print("Saisissez un nouvel ID de cours : ");
                coursId = scanner.nextLine().toUpperCase();

                ps.setString(1, coursId);
                rs = ps.executeQuery();
                
                if (rs.next()) {
                    found = true; 
                } else {
              	  System.out.println("Il n'existe pas de cours avec cet ID. Veuillez réessayer.");
                }
         	}
        }

        return new Cours(
                rs.getString(1),
                rs.getString(2));
    }

    @Override
    public List<Cours> findAll() throws SQLException {
        List<Cours> coursList = new ArrayList<>();

        String findAllQuery = "SELECT * FROM cours";
        PreparedStatement ps = connection.prepareStatement(findAllQuery);
        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            Cours c = new Cours(
                    rs.getString(1),
                    rs.getString(2));
            coursList.add(c);
        }

        return coursList;
    }

    @Override
    public void update(Cours c) throws SQLException {
        String updateQuery = "UPDATE cours " +
                "SET nomCours = ? " +
                "WHERE coursId = ?";
        PreparedStatement ps = connection.prepareStatement(updateQuery);
        ps.setString(1, c.getNomCours());
        ps.setString(2, c.getCoursId());
        
        int rowsAffected = ps.executeUpdate();
        ps.close();
        
        if(rowsAffected == 0) {
        	System.out.println("Erreur, il n'y a pas de cours correspondant à cet ID.");
        } else {
        	System.out.println("Modification réussie !");
        }
        
    }

    @Override
    public void delete(String coursId) throws SQLException {

        String deleteQuery = "DELETE FROM cours "+
                "WHERE coursId = ?";
        PreparedStatement ps = connection.prepareStatement(deleteQuery);
        ps.setString(1, coursId);

        int rowsAffected = ps.executeUpdate();
        ps.close();
        
        /*
         * Message pour l'utilisateur : 
         * Si rowsAffected = 0, c'est qu'aucun changement n'a eu lieu et donc qu'il n'y avait pas d'étudiant avec l'ID entré. On affiche donc une erreur à l'utilisateur. 
         * Sinon, on affiche que la suppression a bien eu lieu. 
         */
        
        if(rowsAffected == 0) {
        	System.out.println("Erreur, il n'y a pas de cours avec cet ID.");
        } else {
        	System.out.println("Suppression réussie !");
        }
    }
}
