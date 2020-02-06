package com.covoiturage.beans;

import org.apache.tomcat.jni.Local;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

public class DetailsTrajet implements Serializable {
    private static final long serialVersionUID = -3068506332086499721L;
    private Long idDetailsTrajet;
    /**
     * dateDepart est de type LocalDateTime dont la format est : "yyyy-MM-dd HH:mm"
     * dont on peut extraire l'heure et les minutes en utilisant les methodes
     *
     * dateDepart.getHour() the hour-of-day, from 0 to 23
     * getMinute() the minute of hour, from 0 to 59
     *
     * or you can simply format the date by .format() method
     */
    private LocalDateTime dateDepart;
    private int prixPlace;
    private String typeVoiture;
    private String modeleVoiture;
    private String marqueVoiture;
    private int climatisationVoiture;
    private int effectif;
    private Long idTrajetChoisie;
    private int bagage;

    public int getBagage() {
        return bagage;
    }

    public void setBagage(int bagage) {
        this.bagage = bagage;
    }

    public DetailsTrajet() {
        super();
    }

    public DetailsTrajet(Long idDetailsTrajet,
                         LocalDateTime dateDepart,
                         int prixPlace, String typeVoiture,
                         String modeleVoiture,
                         String marqueVoiture,
                         int climatisationVoiture,
                         int effectif,
                         Long idTrajetChoisie,
                         int bagage) {
        this.idDetailsTrajet = idDetailsTrajet;
        this.dateDepart = dateDepart;
        this.prixPlace = prixPlace;
        this.typeVoiture = typeVoiture;
        this.modeleVoiture = modeleVoiture;
        this.marqueVoiture = marqueVoiture;
        this.climatisationVoiture = climatisationVoiture;
        this.effectif = effectif;
        this.idTrajetChoisie = idTrajetChoisie;
        this.bagage = bagage;
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

    public String getModeleVoiture() {
        return modeleVoiture;
    }

    public void setModeleVoiture(String modeleVoiture) {
        this.modeleVoiture = modeleVoiture;
    }

    public String getMarqueVoiture() {
        return marqueVoiture;
    }

    public void setMarqueVoiture(String marqueVoiture) {
        this.marqueVoiture = marqueVoiture;
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
