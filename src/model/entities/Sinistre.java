package model.entities;

import model.enums.TypeSinistre;

import java.time.LocalDate;

public class Sinistre {

    private int id;
    private TypeSinistre type;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private double montant;
    private String description;
    private Contrat contrat;

    public Sinistre(int id, TypeSinistre type, LocalDate dateDebut, LocalDate dateFin, double montant, String description, Contrat contrat) {
        this.id = id;
        this.type = type;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.montant = montant;
        this.description = description;
        this.contrat = contrat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TypeSinistre getType() {
        return type;
    }

    public void setType(TypeSinistre type) {
        this.type = type;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Contrat getContrat() {
        return contrat;
    }

    public void setContrat(Contrat contrat) {
        this.contrat = contrat;
    }

    @Override
    public String toString() {
        return "Sinistre ID : " + id +
                ", Type : " + type +
                ", Début : " + dateDebut +
                ", Fin : " + dateFin +
                ", Montant : " + montant +
                ", Description : " + description +
                ", Contrat ID : " + (contrat != null ? contrat.getId() : "Non assigné");
    }
}
