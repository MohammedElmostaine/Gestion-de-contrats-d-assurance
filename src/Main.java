import DAO.ClientDAO;
import DAO.ConseillerDAO;
import DAO.DatabaseConnection;
import model.entities.Client;
import model.entities.Conseiller;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        DatabaseConnection dbCon = DatabaseConnection.getInstance();
        ClientDAO clientDAO = new ClientDAO(dbCon.getConnection());
        ConseillerDAO conseillerDAO = new ConseillerDAO();
        Conseiller conseiller = new Conseiller(1,"med","mesta","consa@gmail.com");
        conseillerDAO.ajouterConseiller(conseiller);

        clientDAO.ajouterClient(new Client(1,"med","mesta","mesta@gmail.com",conseiller));
    }
}