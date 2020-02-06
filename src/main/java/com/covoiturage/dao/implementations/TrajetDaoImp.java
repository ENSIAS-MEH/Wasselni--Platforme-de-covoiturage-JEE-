package com.covoiturage.dao.implementations;

import com.covoiturage.beans.DetailsTrajet;
import com.covoiturage.beans.Trajet;
import com.covoiturage.dao.DAOFactory;
import com.covoiturage.dao.interfaces.TrajetDao;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TrajetDaoImp implements TrajetDao {
    private DAOFactory daoFactory;

    public TrajetDaoImp(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    public Trajet findSpecificTrajet(Trajet trajet) throws SQLException {

        String sql = "SELECT ID_TRAJET, VILLE_DEPART, " +
                " VILLE_DESTINATION FROM TRAJET " +
                "WHERE VILLE_DEPART = ? " +
                " and VILLE_DESTINATION = ? ";
        PreparedStatement preparedStmt = null;
        ResultSet resultset;
        Connection connection = daoFactory.getConnection();
        preparedStmt = connection.prepareStatement(sql);
        preparedStmt.setString(1, trajet.getVilleDepart());
       // preparedStmt.setString(2, trajet.getQuartierDepart());
        //preparedStmt.setString(3, trajet.getRueDepart());
        preparedStmt.setString(2, trajet.getVilleDestination());
        //preparedStmt.setString(5, trajet.getQuartierDestination());
       // preparedStmt.setString(6, trajet.getRueDestination());

        resultset = preparedStmt.executeQuery();
        Trajet returnedTrajet;
        if( resultset.next() ) {
            Long idTrajet = resultset.getLong("ID_TRAJET");
            String villeDepart = resultset.getString("VILLE_DEPART");
            //String quartierDepart = resultset.getString("QUARTIER_DEPART");
            //String rueDepart = resultset.getString("RUE_DEPART");
            String villeDestination = resultset.getString("VILLE_DESTINATION");
            //String quartierDestination = resultset.getString("QUARTIER_DESTINATION");
            //String rueDestination = resultset.getString("RUE_DESTINATION");
            returnedTrajet = new Trajet(idTrajet,
                    villeDepart,
                    villeDestination);
        } else {
            returnedTrajet = null;
        }

        preparedStmt.close();
        resultset.close();

        return returnedTrajet;
    }
    public List<Trajet> findAllTrajets(Trajet trajet, DetailsTrajet detailsTrajet) throws SQLException {
        List<Trajet> listOfTrajets = new ArrayList<Trajet>();

        String sql = "SELECT ID_TRAJET, VILLE_DEPART," +
                " VILLE_DESTINATION FROM TRAJET where VILLE_DEPART like ? or VILLE_DESTINATION like  ? or ID_TRAJET in " +
                "(select ID_TRAJET_CHOISIE from details_trajet where EFFECTIF = ? or bagage = ? or DATETIME_DEPART = ?)";
        PreparedStatement preparedStmt = null;
        ResultSet resultset;
        Connection connection = daoFactory.getConnection();
        preparedStmt = connection.prepareStatement(sql);
        preparedStmt.setString(1, "%"+trajet.getVilleDepart()+"%");
        preparedStmt.setString(2,"%"+trajet.getVilleDestination()+"%");
        preparedStmt.setInt(3, detailsTrajet.getEffectif());
        preparedStmt.setInt(4, detailsTrajet.getBagage());
        preparedStmt.setObject(5, detailsTrajet.getDateDepart());

        resultset = preparedStmt.executeQuery();
        Long idTrajet;
        String villeDepart, villeDestination;
        Trajet TrajetToAdd;

        while( resultset.next() ) {
            idTrajet = resultset.getLong("ID_TRAJET");
            villeDepart = resultset.getString("VILLE_DEPART");
            villeDestination = resultset.getString("VILLE_DESTINATION");
            TrajetToAdd = new Trajet(idTrajet,villeDepart,
                    villeDestination);
            listOfTrajets.add(TrajetToAdd);
        }

        preparedStmt.close();
        resultset.close();

        return listOfTrajets;
    }
    public Long insertTrajet(Trajet trajet) throws SQLException {
        Long IdrowInserted;
        String sql = "INSERT INTO TRAJET(VILLE_DEPART, " +
                "VILLE_DESTINATION) " +
                "VALUES(?, ?)";
        PreparedStatement preparedStmt;
        ResultSet resultSet;
        Connection connection = DAOFactory.getInstance().getConnection();
        preparedStmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preparedStmt.setString(1, trajet.getVilleDepart());
        //preparedStmt.setString(2, trajet.getQuartierDepart());
        //preparedStmt.setString(3, trajet.getRueDepart());
        preparedStmt.setString(2, trajet.getVilleDestination());

        preparedStmt.execute();
        resultSet = preparedStmt.getGeneratedKeys();

        if(resultSet.next()) {
            IdrowInserted = resultSet.getLong(1);
        } else {
            IdrowInserted = -1L;
        }

        preparedStmt.close();

        return  IdrowInserted;
    }
}
