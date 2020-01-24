package com.covoiturage.beans;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class DetailsTrajet implements Serializable {
    private static final long serialVersionUID = -3068506332086499721L;
    private Long idDetailsTrajet;
    private LocalDateTime dateDepart;
    private LocalDateTime dateArrivee;
    private int prixPlace;
    private String typeVoiture;
    private String marqueVoiture;
    private String modeleVoiture;
    private int climatisationVoiture;
    private int effectif;
    private Long idTrajetChoisie;

    public DetailsTrajet() {
        super();
    }

    public DetailsTrajet( Long idDetailsTrajet,
                         LocalDateTime dateDepart,
                         LocalDateTime dateArrivee,
                         int prixPlace,
                         String typeVoiture,
                         String marqueVoiture,
                         String modeleVoiture,
                         int climatisationVoiture,
                         int effectif,
                         Long idTrajetChoisie) {
        this.idDetailsTrajet = idDetailsTrajet;
        this.dateDepart = dateDepart;
        this.dateArrivee = dateArrivee;
        this.prixPlace = prixPlace;
        this.typeVoiture = typeVoiture;
        this.marqueVoiture = marqueVoiture;
        this.modeleVoiture = modeleVoiture;
        this.climatisationVoiture = climatisationVoiture;
        this.effectif = effectif;
        this.idTrajetChoisie = idTrajetChoisie;
    }

    public Long getIdDetailsTrajet() {
        return idDetailsTrajet;
    }

    public void setIdDetailsTrajet(Long idDetailsTrajet) {
        this.idDetailsTrajet = idDetailsTrajet;
    }

    public LocalDateTime getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(LocalDateTime dateDepart) {
        this.dateDepart = dateDepart;
    }

    public LocalDateTime getDateArrivee() {
        return dateArrivee;
    }

    public void setDateArrivee(LocalDateTime dateArrivee) {
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

    public String getMarqueVoiture() {
        return marqueVoiture;
    }

    public void setMarqueVoiture(String marqueVoiture) {
        this.marqueVoiture = marqueVoiture;
    }

    public String getModeleVoiture() {
        return modeleVoiture;
    }

    public void setModeleVoiture(String modeleVoiture) {
        this.modeleVoiture = modeleVoiture;
    }

    public int getClimatisationVoiture() {
        return climatisationVoiture;
    }

    public void setClimatisationVoiture(int climatisationVoiture) {
        this.climatisationVoiture = climatisationVoiture;
    }

    public int getEffectif() {
        return effectif;
    }

    public void setEffectif(int effectif) {
        this.effectif = effectif;
    }

    public Long getIdTrajetChoisie() {
        return idTrajetChoisie;
    }

    public void setIdTrajetChoisie(Long idTrajetChoisie) {
        this.idTrajetChoisie = idTrajetChoisie;
    }
}
