package model.entities;

import java.util.ArrayList;
import java.util.List;

public class Client extends Person {
    private List<Contrat> contrats;
    private Conseiller conseiller;

    public Client(int id, String nom, String prenom, String email , Conseiller conseiller) {
        super(id, nom, prenom, email);
        this.conseiller = conseiller ;
        this.contrats= new ArrayList<>();
    }
    public Client() {
        super();
        this.contrats = new ArrayList<>();
    }

    public List<Contrat> getContrats() {
        return contrats;
    }

    public void setContrats(List<Contrat> contrats) {
        this.contrats = contrats;
    }

    public Conseiller getConseiller() {
        return conseiller;
    }

    public void setConseiller(Conseiller conseiller) {
        this.conseiller = conseiller;
    }


    public void ajouterContrat(Contrat contrat) {
        contrats.add(contrat);
    }

    public void supprimerContrat(Contrat contrat) {
        contrats.remove(contrat);
    }


    @Override
    public String toString() {
        return "Client : " + getNom() + " " + getPrenom() +
                ", Email : " + getEmail() +
                ", Conseiller : " + (conseiller != null ? conseiller.getNom() : "Non assigné") +
                ", Nombre de contrats : " + contrats.size();
    }
}
