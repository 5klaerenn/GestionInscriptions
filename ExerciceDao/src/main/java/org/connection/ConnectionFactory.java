package org.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {
    private static Connection connection = null;

    public static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    public static final String USER = "sk";
    public static final String PASS = "user1";

    public static Connection getConnection()  {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {

            connection = DriverManager.getConnection(URL, USER, PASS);
            return connection;
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }

    public void closeConnection() throws SQLException {

        if (connection != null) {
            connection.close();
        }
    }

}
