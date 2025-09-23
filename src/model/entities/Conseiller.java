package model.entities;

import java.util.ArrayList;
import java.util.List;

public class Conseiller extends Person {

    private List<Client> clients;

    public Conseiller(int id, String nom, String prenom, String email) {
        super(id, nom, prenom, email);
        this.clients = new ArrayList<>();
    }

    public Conseiller() {
        super();
        this.clients = new ArrayList<>();
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }


    public void ajouterClient(Client client) {
        clients.add(client);
        client.setConseiller(this);
    }

    public void supprimerClient(Client client) {
        clients.remove(client);
        client.setConseiller(null);
    }

    @Override
    public String toString() {
        return "Conseiller : " + getNom() + " " + getPrenom() +
                ", Email : " + getEmail() +
                ", Nombre de clients : " + clients.size();
    }
}
