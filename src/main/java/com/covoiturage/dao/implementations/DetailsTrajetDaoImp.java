package com.covoiturage.dao.implementations;

import com.covoiturage.beans.DetailsTrajet;
import com.covoiturage.dao.DAOFactory;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DetailsTrajetDaoImp {

    public DetailsTrajet findSpecificDetailsTrajet(DetailsTrajet detailsTrajet) throws SQLException {
        String sql = "SELECT ID_DETAILS_TRAJET, DATETIME_DEPART, DATETIME_ARRIVEE, PRIX_PLACE, TYPE_VOITURE, EFFECTIF, ID_TRAJET_CHOISIE " +
                "FROM DETAILS_TRAJET WHERE ID_DETAILS_TRAJET = ?";
        PreparedStatement preparedStmt = null;
        ResultSet resultset;
        Connection connection = DAOFactory.getInstance().getConnection();
        preparedStmt = connection.prepareStatement(sql);
        preparedStmt.setLong(1, detailsTrajet.getIdDetailsTrajet());
        resultset = preparedStmt.executeQuery();
        DetailsTrajet returnedDetailsTrajet;
        if( resultset.next() ) {
            Long idDetailsTrajet = resultset.getLong("ID_DETAILS_TRAJET");
            LocalDateTime dateDepart = resultset.getObject("DATETIME_DEPART", LocalDateTime.class);
            LocalDateTime dateArrivee = resultset.getObject("DATETIME_ARRIVEE", LocalDateTime.class);
            int prixPlace = resultset.getInt("PRIX_PLACE");
            String typeVoiture = resultset.getString("TYPE_VOITURE");
            int effectif = resultset.getInt("EFFECTIF");
            Long idTrajetChoisie = resultset.getLong("ID_TRAJET_CHOISIE");
            returnedDetailsTrajet = new DetailsTrajet(idDetailsTrajet, dateDepart,
                    dateArrivee, prixPlace, typeVoiture, effectif, idTrajetChoisie);
        } else {
            returnedDetailsTrajet = null;
        }

        preparedStmt.close();
        resultset.close();
        connection.close();

        return returnedDetailsTrajet;
    }

    public List<DetailsTrajet> findAllDetailsTrajets() throws SQLException {
        List<DetailsTrajet> listofDetailsTrajets = new ArrayList<DetailsTrajet>();
        String sql = "SELECT ID_DETAILS_TRAJET, DATETIME_DEPART, DATETIME_ARRIVEE, PRIX_PLACE, TYPE_VOITURE, EFFECTIF, ID_TRAJET_CHOISIE " +
                "FROM DETAILS_TRAJET";
        Statement stmt = null;
        ResultSet resultset;
        Connection connection = DAOFactory.getInstance().getConnection();
        stmt = connection.createStatement();
        resultset = stmt.executeQuery(sql);
        while( resultset.next()) {
            Long idDetailsTrajet = resultset.getLong("ID_DETAILS_TRAJET");
            LocalDateTime dateDepart = resultset.getObject("DATETIME_DEPART", LocalDateTime.class);
            LocalDateTime dateArrivee = resultset.getObject("DATETIME_ARRIVEE", LocalDateTime.class);
            int prixPlace = resultset.getInt("PRIX_PLACE");
            String typeVoiture = resultset.getString("TYPE_VOITURE");
            int effectif = resultset.getInt("EFFECTIF");
            Long idTrajetChoisie = resultset.getLong("ID_TRAJET_CHOISIE");
            DetailsTrajet detailsTrajetToAdd = new DetailsTrajet(idDetailsTrajet, dateDepart,
                    dateArrivee, prixPlace, typeVoiture, effectif, idTrajetChoisie);
            listofDetailsTrajets.add(detailsTrajetToAdd);
        }

        stmt.close();
        resultset.close();
        connection.close();

        return listofDetailsTrajets;
    }

    public Long insertDetailsTrajet(DetailsTrajet detailsTrajet) throws SQLException {
        Long idrowInserted;
        String sql = "INSERT INTO DETAILS_TRAJET(DATETIME_DEPART,DATETIME_ARRIVEE," +
                "PRIX_PLACE,TYPE_VOITURE,EFFECTIF,ID_TRAJET_CHOISIE) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStmt;
        ResultSet resultset;
        Connection connection = DAOFactory.getInstance().getConnection();
        preparedStmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preparedStmt.setObject(1, detailsTrajet.getDateDepart());
        preparedStmt.setObject(2, detailsTrajet.getDateArrivee());
        preparedStmt.setInt(3, detailsTrajet.getPrixPlace());
        preparedStmt.setString(4, detailsTrajet.getTypeVoiture());
        preparedStmt.setInt(5, detailsTrajet.getEffectif());
        preparedStmt.setLong(6, detailsTrajet.getIdTrajetChoisie());
        preparedStmt.execute();
        resultset = preparedStmt.getGeneratedKeys();

        if (resultset.next()) {
            idrowInserted = resultset.getLong(1);
            connection.commit();
        } else {
            idrowInserted = -1L;
        }

        preparedStmt.close();
        resultset.close();
        connection.close();

        return idrowInserted;
    }

    public boolean updateDetailsTrajet(DetailsTrajet detailsTrajet) throws SQLException {
        boolean rowUpdated;
        String sql = "UPDATE DETAILS_TRAJET SET DATETIME_DEPART = ?, DATETIME_ARRIVEE = ?, PRIX_PLACE = ?," +
                " TYPE_VOITURE = ?, EFFECTIF = ?, ID_TRAJET_CHOISIE = ? WHERE ID_DETAILS_TRAJET = ?";
        PreparedStatement preparedStmt;
        Connection connection = DAOFactory.getInstance().getConnection();
        preparedStmt = connection.prepareStatement(sql);
        preparedStmt.setObject(1, detailsTrajet.getDateDepart());
        preparedStmt.setObject(2, detailsTrajet.getDateArrivee());
        preparedStmt.setInt(3, detailsTrajet.getPrixPlace());
        preparedStmt.setString(4, detailsTrajet.getTypeVoiture());
        preparedStmt.setLong(5, detailsTrajet.getIdTrajetChoisie());
        preparedStmt.setLong(6, detailsTrajet.getIdDetailsTrajet());
        rowUpdated = preparedStmt.executeUpdate() > 0;
        if( rowUpdated ) {
            connection.commit();
        }

        preparedStmt.close();
        connection.close();

        return rowUpdated;
    }
}
