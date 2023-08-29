package org.sklaerenn.DaoImpl;

import org.sklaerenn.DaoInterface.EtudiantDao;
import org.sklaerenn.connection.ConnectionFactory;
import org.sklaerenn.model.Etudiant;

import java.sql.*;
import java.util.*;


public class EtudiantDaoImpl implements EtudiantDao {

    Connection connection = ConnectionFactory.getConnection();

    @Override
    public void create(Etudiant e) throws SQLException {
    	//Vérification de la contrainte de clé primaire lors de l'ajout d'un nouvel étudiant
    	 String checkQuery = "SELECT * FROM etudiants WHERE etudiantId = ?";
    	    PreparedStatement checkPs = connection.prepareStatement(checkQuery);
    	    checkPs.setInt(1, e.getEtudiantId());

    	    ResultSet rs = checkPs.executeQuery();
    	    if (rs.next()) { // Si l'ID de l'étudiant existe déjà, on retourne un message d'erreur et on ramène l'utilisateur à l'écran d'accueil
    	        System.out.println("Erreur : L'ID de l'étudiant existe déjà. Veuillez entrer un ID unique.");
    	    } else { // Si l'ID de l'étudiant que l'on souhaite ajouter est unique, on procède à l'ajout : 
		        String createQuery = "INSERT INTO etudiants(etudiantid, nom, prenom) " +
		                "VALUES (?,?,?)";
		
		        PreparedStatement ps = connection.prepareStatement(createQuery);
		        ps.setInt(1, e.getEtudiantId());
		        ps.setString(2, e.getNom());
		        ps.setString(3, e.getPrenom());
		        ps.executeUpdate();
		        ps.close();
    	    }
    }

    @Override
    public Etudiant findById(int etudantId) throws SQLException {
        String findByIdQuery = "SELECT * FROM etudiants " +
                "WHERE etudiantId = ? ";
        PreparedStatement ps = connection.prepareStatement(findByIdQuery);
        ps.setInt(1, etudantId);

        ResultSet rs = ps.executeQuery();
        
        if(!rs.next()) { // Vérification que l'ID entré pour l'étudiant existe. S'il n'existe pas, on redemande à l'utilisateur d'entrer l'ID d'étudiant. 
        	System.out.println("Aucun étudiant avec cet ID n'a été trouvé. Veuillez réessayer. ");
        	Scanner scanner = new Scanner(System.in);
        	boolean found = false;
             
            while (!found) {
            	System.out.println("Entrez l'id de l'étudiant à rechercher : ");
        		int etudiantId = scanner.nextInt();
        		scanner.nextLine();
        		
        		ps.setInt(1,  etudiantId);
        		rs = ps.executeQuery();
                 
                 if (rs.next()) {
                     found = true; 
                 } else {
               	  System.out.println("Il n'existe pas de cours avec cet ID. Veuillez réessayer.");
                 }
          	}
        }
        
        return new Etudiant(
        		rs.getInt(1),
                rs.getString(2),
                rs.getString(3));
    }

    @Override
    public List<Etudiant> findAll() throws SQLException {

        List<Etudiant> etuList = new ArrayList<>();

        String findAllQuery = "SELECT * FROM etudiants";
        PreparedStatement ps = connection.prepareStatement(findAllQuery);
        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            Etudiant e = new Etudiant(
            		rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3));
            etuList.add(e);
        }
        return etuList;
    }

    @Override
    public void update(Etudiant e) throws SQLException {

        String updateQuery = "UPDATE etudiants " +
                "SET nom = ?, " +
                "prenom = ?" +
                "WHERE etudiantID = ?";
        PreparedStatement ps = connection.prepareStatement(updateQuery);
        ps.setString(1, e.getNom());
        ps.setString(2, e.getPrenom());
        ps.setInt(3, e.getEtudiantId());

        int rowsAffected = ps.executeUpdate();
        ps.close();
        
        /*
         * Message pour l'utilisateur : 
         * Si rowsAffected = 0, c'est qu'aucun changement n'a eu lieu et donc qu'il n'y avait pas d'étudiant avec l'ID entré. On affiche donc une erreur à l'utilisateur. 
         * Sinon, on affiche que la modification a bien eu lieu. 
         */
        
        if(rowsAffected == 0) {
        	System.out.println("Erreur, il n'y a pas d'étudiant avec cet ID.");
        } else {
        	System.out.println("Modification réussie !");
        }
                
    }

    @Override
    public void delete(int etudiantId) throws SQLException {

        String deleteQuery = "DELETE FROM etudiants " +
                "WHERE etudiantId = ?";
        PreparedStatement ps = connection.prepareStatement(deleteQuery);
        ps.setInt(1, etudiantId);

        int rowsAffected = ps.executeUpdate();
        ps.close();
        
/*
 * Message pour l'utilisateur : 
 * Si rowsAffected = 0, c'est qu'aucun changement n'a eu lieu et donc qu'il n'y avait pas d'étudiant avec l'ID entré. On affiche donc une erreur à l'utilisateur. 
 * Sinon, on affiche que la suppression a bien eu lieu. 
 */
        if(rowsAffected == 0) {
        	System.out.println("Erreur, il n'y a pas d'étudiant avec cet ID.");
        } else {
        	System.out.println("Suppression réussie !");
        }

    }
}
