package DAO;

import java.sql.*;


public class DatabaseConnection {

    private static DatabaseConnection instance;
    private  Connection con;

    String url = "jdbc:postgresql://localhost:5432/gestion-D-assurance";
    String username = "postgres";
    String password = "123456";

    private DatabaseConnection() {
        try {
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Connexion etablie !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return con;
    }


}
