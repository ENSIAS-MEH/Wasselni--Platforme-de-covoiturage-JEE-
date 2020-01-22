package com.covoiturage.beans;

import java.io.Serializable;

public class Trajet implements Serializable {
    private static final long serialVersionUID = -9145861415727573123L;
    private int idTrajet;
    private String DepartTrajet;
    private String DestinationTrajet;

    public Trajet() {
        super();
    }

    public Trajet(int idTrajet, String departTrajet, String destinationTrajet) {
        this.idTrajet = idTrajet;
        DepartTrajet = departTrajet;
        DestinationTrajet = destinationTrajet;
    }

    public int getIdTrajet() {
        return idTrajet;
    }

    public void setIdTrajet(int idTrajet) {
        this.idTrajet = idTrajet;
    }

    public String getDepartTrajet() {
        return DepartTrajet;
    }

    public void setDepartTrajet(String departTrajet) {
        DepartTrajet = departTrajet;
    }

    public String getDestinationTrajet() {
        return DestinationTrajet;
    }

    public void setDestinationTrajet(String destinationTrajet) {
        DestinationTrajet = destinationTrajet;
    }
}
