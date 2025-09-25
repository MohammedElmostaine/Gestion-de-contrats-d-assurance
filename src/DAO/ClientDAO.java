package DAO;

import java.sql.Connection;

import model.entities.Client;
import java.sql.*;


public class ClientDAO {

    private Connection con;

    public ClientDAO(Connection con) {
        con = DatabaseConnection.getInstance().getConnection();
    }
    public void  ajouterClient(Client client) {
         try {
             String sql = "INSERT INTO client (nom, prenom, email, conseiller_id) VALUES (?, ?, ?, ?)";
                PreparedStatement stmt = con.prepareStatement(sql);

         }catch (SQLException e) {
             System.out.println("Erreur lors de l'ajout du client : " + e.getMessage());
         }

    }

    public  void supprimerClient(Client client) {
        try {
            String sql = "DELETE FROM client WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, client.getId());
            stmt.executeUpdate();
            System.out.println("Client supprime !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression  du client : " + e.getMessage());
        }
    }

    public void modifierClient(Client client ){
        try {
            String sql  = "UPDATE client SET nom = ? , prenom = ? , email = ? , conseiller_id = ? WHERE id = ? ";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, client.getNom());
            stmt.setString(2, client.getPrenom());
            stmt.setString(3, client.getEmail());
            stmt.setInt(4, client.getConseiller().getId());
            stmt.setInt(5, client.getId());
            stmt.executeUpdate();
            System.out.println("Client modifie !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de la modification du client : " + e.getMessage());
        }

    }

    public Client rechercherClient(int id ){
        Client client = null ;

        try {
            String sql  = "SELECT * FROM client WHERE id = ? ";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                client = new Client();
                client.setId(rs.getInt("id"));
                client.setNom(rs.getString("nom"));
                client.setPrenom(rs.getString("prenom"));
                client.setEmail(rs.getString("email"));
                // Vous pouvez également récupérer et définir le conseiller si nécessaire
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la recherche du client : " + e.getMessage());
        }
        return  client ;
    }
}
