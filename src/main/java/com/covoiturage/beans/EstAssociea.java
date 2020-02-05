package com.covoiturage.beans;

import java.io.Serializable;
import java.time.LocalDateTime;

public class EstAssociea implements Serializable {
    private static final long serialVersionUID = 6685041004718402373L;
    private Long idDetailsTrajet;
    private Long idUser;
    private String typeAssociation;
    private LocalDateTime dateAssociation;

    public EstAssociea() {
        super();
    }

    public EstAssociea(Long idDetailsTrajet, Long idUser, String typeAssociation, LocalDateTime dateAssociation) {
        this.idDetailsTrajet = idDetailsTrajet;
        this.idUser = idUser;
        this.typeAssociation = typeAssociation;
        this.dateAssociation = dateAssociation;
    }

    public Long getIdDetailsTrajet() {
        return idDetailsTrajet;
    }

    public void setIdDetailsTrajet(Long idDetailsTrajet) {
        this.idDetailsTrajet = idDetailsTrajet;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getTypeAssociation() {
        return typeAssociation;
    }

    public void setTypeAssociation(String typeAssociation) {
        this.typeAssociation = typeAssociation;
    }

    public LocalDateTime getDateAssociation() {
        return dateAssociation;
    }

    public void setDateAssociation(LocalDateTime dateAssociation) {
        this.dateAssociation = dateAssociation;
    }
}
