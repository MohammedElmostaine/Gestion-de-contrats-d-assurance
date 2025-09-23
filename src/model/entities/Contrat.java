package model.entities;

import model.enums.TypeContrat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contrat {

    private int  id;
    private TypeContrat typeContrat;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private Client client;
    private List<Sinistre> sinistres;

    public Contrat(int id, TypeContrat typeContrat, LocalDate dateDebut, LocalDate dateFin, Client client) {
        this.id = id;
        this.typeContrat = typeContrat;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.client = client;
        this.sinistres = new ArrayList<>();
    }

    public TypeContrat getTypeContrat() {
        return typeContrat;
    }

    public void setTypeContrat(TypeContrat typeContrat) {
        this.typeContrat = typeContrat;
    }

    @Override
    public String toString() {
        return "Contrat ID : " + id +
                ", Type : " + typeContrat +
                ", Début : " + dateDebut +
                ", Fin : " + dateFin +
                ", Client : " + (client != null ? client.getNom() : "Non assigné");
    }

    public int  getId() {
        return  id ;
    }
}
