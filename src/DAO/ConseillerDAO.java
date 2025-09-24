package DAO;

import java.sql.Connection;

import model.entities.Conseiller;
import java.sql.*;


public class ConseillerDAO {

    private Connection connection;

    public ConseillerDAO(   ) {
        connection = DatabaseConnection.getInstance().getConnection();
    }


    public void ajouterConseiller(Conseiller conseiller) {
        if (connection == null) {
            throw new IllegalStateException("DAO connection is null (constructor didn’t assign it).");
        }
        try {
            String sql = "INSERT INTO conseiller (nom, prenom, email) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, conseiller.getNom());
            stmt.setString(2, conseiller.getPrenom());
            stmt.setString(3, conseiller.getEmail());
            stmt.executeUpdate();
            System.out.println("Conseiller ajouté !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout du conseiller : " + e.getMessage());
        }
    }
    public void supprimerConseiller(Conseiller conseiller) {
        try {
            String sql = "DELETE FROM conseiller WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, conseiller.getId());
            stmt.executeUpdate();
            System.out.println("Conseiller supprime !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression  du conseiller : " + e.getMessage());
        }
    }

    public void modifierConseiller(Conseiller conseiller) {

        try {
            String sql  = "UPDATE conseiller SET nom = ? , prenom = ? , email = ? WHERE id = ? ";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, conseiller.getNom());
            stmt.setString(2, conseiller.getPrenom());
            stmt.setString(3, conseiller.getEmail());
            stmt.setInt(4, conseiller.getId());
            stmt.executeUpdate();
            System.out.println("Conseiller modifie !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de la modification du conseiller : " + e.getMessage());
        }

    }

    public Conseiller rechercherConseiller(int id) {
        Conseiller conseiller = null;
        try {
            String sql = "SELECT * FROM conseiller WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                conseiller = new Conseiller();
                conseiller.setId(rs.getInt("id"));
                conseiller.setNom(rs.getString("nom"));
                conseiller.setPrenom(rs.getString("prenom"));
                conseiller.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération du conseiller : " + e.getMessage());
        }
        return conseiller;
    }


}
