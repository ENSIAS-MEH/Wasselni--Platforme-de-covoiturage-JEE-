package com.covoiturage.beans;

import java.io.Serializable;
import java.util.Date;

public class DetailsTrajet implements Serializable {
    private static final long serialVersionUID = -3068506332086499721L;
    private int idDetailsTrajet;
    private Date dateDepart;
    private Date dateArrivee;
    private int prixPlace;
    private String typeVoiture;
    private int effectif;

    public DetailsTrajet() {
        super();
    }

    public DetailsTrajet(int idDetailsTrajet,
                         Date dateDepart,
                         Date dateArrivee,
                         int prixPlace,
                         String typeVoiture,
                         int effectif) {
        this.idDetailsTrajet = idDetailsTrajet;
        this.dateDepart = dateDepart;
        this.dateArrivee = dateArrivee;
        this.prixPlace = prixPlace;
        this.typeVoiture = typeVoiture;
        this.effectif = effectif;
    }

    public int getIdDetailsTrajet() {
        return idDetailsTrajet;
    }

    public void setIdDetailsTrajet(int idDetailsTrajet) {
        this.idDetailsTrajet = idDetailsTrajet;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    public Date getDateArrivee() {
        return dateArrivee;
    }

    public void setDateArrivee(Date dateArrivee) {
        this.dateArrivee = dateArrivee;
    }

    public int getPrixPlace() {
        return prixPlace;
    }

    public void setPrixPlace(int prixPlace) {
        this.prixPlace = prixPlace;
    }

    public String getTypeVoiture() {
        return typeVoiture;
    }

    public void setTypeVoiture(String typeVoiture) {
        this.typeVoiture = typeVoiture;
    }

    public int getEffectif() {
        return effectif;
    }

    public void setEffectif(int effectif) {
        this.effectif = effectif;
    }
}
