package org.example;

import java.util.*;
import java.sql.*;


public class Main {
    public static void main(String[] args)throws SQLException  {

        Map<String, String> hashDep = findAll();

        for (Map.Entry dep : hashDep.entrySet()) {
            System.out.println(dep.getKey()
                    + " : "
                    + dep.getValue());
        }
    }

    static Map<String, String> findAll() throws SQLException {
        String query = "SELECT * "
                + "FROM departement";

        Map<String, String> hashDep = new HashMap<>();

        PreparedStatement ps = getConnection().prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String id = rs.getString(1);
            String name = rs.getString(2);

            hashDep.put(id, name);
        }
        return hashDep;
    }

    static Connection getConnection() throws SQLException {
        String url = "jdbc:oracle:thin:@//localhost:1521/xe";
        Connection con
                = DriverManager.getConnection(url, "sk", "user1");
        return con;
    }

}