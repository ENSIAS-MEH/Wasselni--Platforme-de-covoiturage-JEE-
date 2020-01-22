package com.covoiturage.beans;

import java.io.Serializable;
import java.util.Date;

public class EstAssociea implements Serializable {
    private static final long serialVersionUID = 6685041004718402373L;
    private Long idDetailsTrajet;
    private String cinUser;
    private String TypeAssociation;
    private Date DateAssociation;

    public EstAssociea() {
        super();
    }

    public EstAssociea(Long idDetailsTrajet, String cinUser, String typeAssociation, Date dateAssociation) {
        this.idDetailsTrajet = idDetailsTrajet;
        this.cinUser = cinUser;
        TypeAssociation = typeAssociation;
        DateAssociation = dateAssociation;
    }

    public Long getIdDetailsTrajet() {
        return idDetailsTrajet;
    }

    public void setIdDetailsTrajet(Long idDetailsTrajet) {
        this.idDetailsTrajet = idDetailsTrajet;
    }

    public String getCinUser() {
        return cinUser;
    }

    public void setCinUser(String cinUser) {
        this.cinUser = cinUser;
    }

    public String getTypeAssociation() {
        return TypeAssociation;
    }

    public void setTypeAssociation(String typeAssociation) {
        TypeAssociation = typeAssociation;
    }

    public Date getDateAssociation() {
        return DateAssociation;
    }

    public void setDateAssociation(Date dateAssociation) {
        DateAssociation = dateAssociation;
    }
}
