package com.covoiturage.beans;

import java.io.Serializable;

public class Trajet implements Serializable {
    private static final long serialVersionUID = -9145861415727573123L;
    private Long idTrajet;
    private String villeDepart;
    //private String quartierDepart;
   // private String rueDepart;
    private String villeDestination;
    //private String quartierDestination;
    private String rueDestination;

    public Trajet() {
        super();
    }

    public Trajet(Long idTrajet,
                  String villeDestination,
                  String villeDepart) {
        this.idTrajet = idTrajet;
        this.villeDepart = villeDepart;
        //this.quartierDepart = quartierDepart;
        //this.rueDepart = rueDepart;
        this.villeDestination = villeDestination;
        //this.quartierDestination = quartierDestination;
        //this.rueDestination = rueDestination;
    }

    public Long getIdTrajet() {
        return idTrajet;
    }

    public void setIdTrajet(Long idTrajet) {
        this.idTrajet = idTrajet;
    }

    public String getVilleDepart() {
        return villeDepart;
    }

    public void setVilleDepart(String villeDepart) {
        this.villeDepart = villeDepart;
    }

   // public String getQuartierDepart() {
       // return quartierDepart;
   // }

   // public void setQuartierDepart(String quartierDepart) {
      //  this.quartierDepart = quartierDepart;
   // }

   // public String getRueDepart() {
        //return rueDepart;
    //}

    //public void setRueDepart(String rueDepart) {
       // this.rueDepart = rueDepart;
   // }

    public String getVilleDestination() {
        return villeDestination;
    }

    public void setVilleDestination(String villeDestination) {
        this.villeDestination = villeDestination;
    }



    public String getRueDestination() {
        return rueDestination;
    }

    public void setRueDestination(String rueDestination) {
        this.rueDestination = rueDestination;
    }
}
