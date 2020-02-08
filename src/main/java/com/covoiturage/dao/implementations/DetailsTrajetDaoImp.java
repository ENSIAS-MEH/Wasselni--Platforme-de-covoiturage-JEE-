package com.covoiturage.dao.implementations;

import com.covoiturage.beans.DetailsTrajet;
import com.covoiturage.dao.DAOFactory;
import com.covoiturage.dao.interfaces.DetailsTrajetDao;


import javax.naming.PartialResultException;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DetailsTrajetDaoImp implements DetailsTrajetDao {
    DAOFactory daoFactory;

    public DetailsTrajetDaoImp(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    public DetailsTrajet findSpecificDetailsTrajet(DetailsTrajet detailsTrajet) throws SQLException {
        String sql = "SELECT ID_DETAILS_TRAJET, DATETIME_DEPART, PRIX_PLACE, TYPE_VOITURE, MARQUE_VOITURE, " +
                " MODELE_VOITURE, CLIMATISATION_VOITURE, EFFECTIF, ID_TRAJET_CHOISIE, bagage " +
                "FROM DETAILS_TRAJET WHERE ID_TRAJET_CHOISIE = ?";
        PreparedStatement preparedStmt = null;
        ResultSet resultset;
        Connection connection = DAOFactory.getInstance().getConnection();
        preparedStmt = connection.prepareStatement(sql);
        preparedStmt.setLong(1, detailsTrajet.getIdTrajetChoisie());
        resultset = preparedStmt.executeQuery();
        DetailsTrajet returnedDetailsTrajet;
        if( resultset.next() ) {
            Long idDetailsTrajet = resultset.getLong("ID_DETAILS_TRAJET");
            LocalDateTime dateDepart = resultset.getObject("DATETIME_DEPART", LocalDateTime.class);
            int prixPlace = resultset.getInt("PRIX_PLACE");
            String typeVoiture = resultset.getString("TYPE_VOITURE");
            String marqueVoiture = resultset.getString("MARQUE_VOITURE");
            String modeleVoiture = resultset.getString("MODELE_VOITURE");
            int climatisationVoiture = resultset.getInt("CLIMATISATION_VOITURE");
            int effectif = resultset.getInt("EFFECTIF");
            Long idTrajetChoisie = resultset.getLong("ID_TRAJET_CHOISIE");
            int bagage = resultset.getInt("bagage");
            returnedDetailsTrajet = new DetailsTrajet(idDetailsTrajet, dateDepart,
                    prixPlace, typeVoiture, marqueVoiture,
                    modeleVoiture, climatisationVoiture, effectif, idTrajetChoisie,bagage);
        } else {
            returnedDetailsTrajet = null;
        }

        preparedStmt.close();
        resultset.close();

        return returnedDetailsTrajet;
    }


    public List<DetailsTrajet> findAllDetailsTrajets() throws SQLException {
        List<DetailsTrajet> listofDetailsTrajets = new ArrayList<DetailsTrajet>();
        String sql = "SELECT ID_DETAILS_TRAJET, DATETIME_DEPART, PRIX_PLACE, TYPE_VOITURE, MARQUE_VOITURE," +
                " MODELE_VOITURE, CLIMATISATION_VOITURE, EFFECTIF, ID_TRAJET_CHOISIE, bagage " +
                "FROM DETAILS_TRAJET";
        Statement stmt;
        ResultSet resultset;
        Connection connection = DAOFactory.getInstance().getConnection();
        stmt = connection.createStatement();
        resultset = stmt.executeQuery(sql);
        while( resultset.next()) {
            Long idDetailsTrajet = resultset.getLong("ID_DETAILS_TRAJET");
            LocalDateTime dateDepart = resultset.getObject("DATETIME_DEPART", LocalDateTime.class);
            int prixPlace = resultset.getInt("PRIX_PLACE");
            String typeVoiture = resultset.getString("TYPE_VOITURE");
            String marqueVoiture = resultset.getString("MARQUE_VOITURE");
            String modeleVoiture = resultset.getString("MODELE_VOITURE");
            int climatisationVoiture = resultset.getInt("CLIMATISATION_VOITURE");
            int effectif = resultset.getInt("EFFECTIF");
            Long idTrajetChoisie = resultset.getLong("ID_TRAJET_CHOISIE");
            int bagage = resultset.getInt("bagage");
            DetailsTrajet detailsTrajetToAdd = new DetailsTrajet(idDetailsTrajet, dateDepart,
                    prixPlace, typeVoiture, marqueVoiture,
                    modeleVoiture, climatisationVoiture, effectif, idTrajetChoisie, bagage);
            listofDetailsTrajets.add(detailsTrajetToAdd);
        }

        stmt.close();
        resultset.close();

        return listofDetailsTrajets;
    }

    public Long insertDetailsTrajet(DetailsTrajet detailsTrajet) throws SQLException {
        Long idrowInserted;
        String sql = "INSERT INTO DETAILS_TRAJET(DATETIME_DEPART," +
                "PRIX_PLACE,TYPE_VOITURE,MARQUE_VOITURE,MODELE_VOITURE,CLIMATISATION_VOITURE,EFFECTIF,ID_TRAJET_CHOISIE, bagage) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?,?)";
        PreparedStatement preparedStmt;
        ResultSet resultset;
        Connection connection = DAOFactory.getInstance().getConnection();
        preparedStmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preparedStmt.setObject(1, detailsTrajet.getDateDepart());
        preparedStmt.setInt(2, detailsTrajet.getPrixPlace());
        preparedStmt.setString(3, detailsTrajet.getTypeVoiture());
        preparedStmt.setString(4, detailsTrajet.getMarqueVoiture());
        preparedStmt.setString(5, detailsTrajet.getModeleVoiture());
        preparedStmt.setInt(6, detailsTrajet.getClimatisationVoiture());
        preparedStmt.setInt(7, detailsTrajet.getEffectif());
        preparedStmt.setLong(8, detailsTrajet.getIdTrajetChoisie());
        preparedStmt.setInt(9,detailsTrajet.getBagage());
        preparedStmt.execute();
        resultset = preparedStmt.getGeneratedKeys();

        if (resultset.next()) {
            idrowInserted = resultset.getLong(1);
        } else {
            idrowInserted = -1L;
        }

        preparedStmt.close();
        resultset.close();

        return idrowInserted;
    }

    /**
     * faut t'il utiliser if not null pour update de chaque column ?
     */

    public boolean updateDetailsTrajet(DetailsTrajet detailsTrajet) throws SQLException {
        boolean rowUpdated;
        String sql = "UPDATE DETAILS_TRAJET SET DATETIME_DEPART = ?, PRIX_PLACE = ?," +
                " TYPE_VOITURE = ?, MODELE_VOITURE = ?,MARQUE_VOITURE = ?, EFFECTIF = ?, ID_TRAJET_CHOISIE = ?," +
                " CLIMATISATION_VOITURE = ?, bagage = ? WHERE ID_DETAILS_TRAJET = ?";
        PreparedStatement preparedStmt;
        Connection connection = DAOFactory.getInstance().getConnection();
        preparedStmt = connection.prepareStatement(sql);
        preparedStmt.setObject(1, detailsTrajet.getDateDepart());
        preparedStmt.setInt(2, detailsTrajet.getPrixPlace());
        preparedStmt.setString(3, detailsTrajet.getTypeVoiture());
        preparedStmt.setString(4, detailsTrajet.getModeleVoiture());
        preparedStmt.setString(5, detailsTrajet.getMarqueVoiture());
        preparedStmt.setInt(6,detailsTrajet.getEffectif());
        preparedStmt.setLong(7, detailsTrajet.getIdTrajetChoisie());
        preparedStmt.setInt(8, detailsTrajet.getClimatisationVoiture());
        preparedStmt.setInt(9,detailsTrajet.getBagage());
        preparedStmt.setLong(10, detailsTrajet.getIdDetailsTrajet());
        rowUpdated = preparedStmt.executeUpdate() > 0;

        preparedStmt.close();

        return rowUpdated;
    }
}
