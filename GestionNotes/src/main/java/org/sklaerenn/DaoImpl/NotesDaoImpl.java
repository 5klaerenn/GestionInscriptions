package org.sklaerenn.DaoImpl;

import org.sklaerenn.DaoInterface.NotesDao;
import org.sklaerenn.connection.ConnectionFactory;
import org.sklaerenn.model.Note;

import java.sql.*;
import java.util.*;

public class NotesDaoImpl implements NotesDao {

    Connection connection = ConnectionFactory.getConnection();

    @Override
    public void create(Note n) throws SQLException {
    	// Première vérification pour s'assurer que l'étudiant entré existe bien dans la table ÉTUDIANTS
    	String checkEtu = "SELECT * FROM etudiants "
    			+ "WHERE etudiantID = ?";
	    PreparedStatement checkEtuPS = connection.prepareStatement(checkEtu);
    	checkEtuPS.setInt(1, n.getEtudiantId());
	    ResultSet rs = checkEtuPS.executeQuery();
	    
	    if(rs.next()) {
	    	// Deuxième vérification pour s'assurer que le cours entré existe bien dans la table COURS
	    	String checkCours = "SELECT * FROM cours "
	    			+ "WHERE coursId = ?";
		    PreparedStatement checkCoursPS = connection.prepareStatement(checkCours);
		    checkCoursPS.setString(1, n.getCoursId());
		    rs = checkCoursPS.executeQuery();
		    
		    if(rs.next()) {
		    	/*
		    	 * Si l'étudiant ET le cours existent dans la base de données :
		    	 * Vérification de la contrainte de clé primaire lors de l'ajout d'une nouvelle note. 
		    	 */
		    	String checkQuery = "SELECT * FROM notes "
		    			+ " WHERE coursId = ? "
		    			+ "AND etudiantID = ?";
			    PreparedStatement checkPs = connection.prepareStatement(checkQuery);
		    	checkPs.setString(1, n.getCoursId());
		    	checkPs.setInt(2, n.getEtudiantId());
			    rs = checkPs.executeQuery();
			    	
				if (rs.next()) { // Si l'ID du cours existe déjà, on retourne un message d'erreur et on ramène l'utilisateur à l'écran d'accueil
					System.out.println("Erreur : Une entrée pour cet étudiant et ce cours existe déjà. Réessayez.");
			    } else { // Sinon, la note peut être ajoutée
			        String createQuery = "INSERT INTO notes(etudiantid, coursid, note1, note2) " +
				                "VALUES (?,?,?,?)";
				
			        PreparedStatement ps = connection.prepareStatement(createQuery);
			        ps.setInt(1, n.getEtudiantId());
			        ps.setString(2, n.getCoursId());
			        ps.setInt(3, n.getNote1());
			        ps.setInt(4, n.getNote2());
			        ps.executeUpdate();
			        ps.close();
			    }
		    } else {
		    	System.out.println("Erreur : Le cours indiqué n'existe pas.");
		    }
	    } else {
	    	System.out.println("Erreur : L'étudiant indiqué n'existe pas.");
	    }
    	
    }

    @Override
    public Note findById(int etudiantId, String coursId) throws SQLException {
        String findByIdQuery = "SELECT * FROM notes " +
                "WHERE etudiantId = ? " +
                "AND coursId = ?";
        PreparedStatement ps = connection.prepareStatement(findByIdQuery);
        ps.setInt(1, etudiantId);
        ps.setString(2, coursId);

        ResultSet rs = ps.executeQuery();
        
        if(!rs.next()) {
        	System.out.println("Cet étudiant n'a pas de note pour ce cours. Veuillez réessayer.");
        	Scanner scanner = new Scanner(System.in);
        	boolean found = false;
              
        	while (!found) {
                  System.out.println("Saisissez un nouvel ID d'étudiant : ");
                  etudiantId = scanner.nextInt();
                  scanner.nextLine();
                  
                  System.out.println("Saisissez un nouvel ID de cours : ");
                  coursId = scanner.nextLine().toUpperCase();
                  
                  ps.setInt(1, etudiantId);
                  ps.setString(2, coursId);
                  
                  rs = ps.executeQuery();  
                  
                  if (rs.next()) {
                      found = true; 
                  } else {
                	  System.out.println("Cet étudiant n'a pas de note pour ce cours. Veuillez réessayer.");
                  }
           	}
        }

        return new Note(
                rs.getInt(1),
                rs.getString(2),
                rs.getInt(3),
                rs.getInt(4));
    }

    @Override
    public List<Note> findAll() throws SQLException {
        List<Note> noteList = new ArrayList<>();

        String findAllQuery = "SELECT * FROM notes";
        PreparedStatement ps = connection.prepareStatement(findAllQuery);
        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            Note n = new Note(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getInt(4));
            noteList.add(n);
        }
        return noteList;    }

    @Override
    public void update(Note n) throws SQLException {

        String updateQuery = "UPDATE notes " +
                "SET note1 = ?, " +
                "note2 = ?" +
                "WHERE etudiantID = ? " +
                "AND coursId = ?";
        PreparedStatement ps = connection.prepareStatement(updateQuery);
        ps.setInt(1, n.getNote1());
        ps.setInt(2, n.getNote2());
        ps.setInt(3, n.getEtudiantId());
        ps.setString(4, n.getCoursId());

        int rowsAffected = ps.executeUpdate();
        ps.close();
        
        /*
         * Message pour l'utilisateur : 
         * Si rowsAffected = 0, c'est qu'aucun changement n'a eu lieu et donc qu'il n'y avait pas d'étudiant avec l'ID entré. On affiche donc une erreur à l'utilisateur. 
         * Sinon, on affiche que la modification a bien eu lieu. 
         */
        
        if(rowsAffected == 0) {
        	System.out.println("Erreur : Il n'y a pas de note pour cet étudiant dans ce cours.");
        } else {
        	System.out.println("Modification réussie !");
        }

    }

    @Override
    public void delete(int etudiantId, String coursId) throws SQLException {
        String deleteQuery = "DELETE FROM notes " +
                "WHERE etudiantId = ? " +
                "AND coursId = ?";
        PreparedStatement ps = connection.prepareStatement(deleteQuery);
        ps.setInt(1, etudiantId);
        ps.setString(2, coursId);

        int rowsAffected = ps.executeUpdate();
        ps.close();
        
        /*
         * Message pour l'utilisateur : 
         * Si rowsAffected = 0, c'est qu'aucun changement n'a eu lieu et donc qu'il n'y avait pas d'étudiant avec l'ID entré. On affiche donc une erreur à l'utilisateur. 
         * Sinon, on affiche que la suppression a bien eu lieu. 
         */
        
        if(rowsAffected == 0) {
        	System.out.println("Erreur : Il n'y a pas de note pour cet étudiant dans ce cours.");
        } else {
        	System.out.println("Suppression réussie !");
        }

    }
}
