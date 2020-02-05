package com.covoiturage.dao.implementations;

import com.covoiturage.beans.Trajet;
import com.covoiturage.dao.DAOFactory;
import com.covoiturage.dao.interfaces.TrajetDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TrajetDaoImp implements TrajetDao {
    private DAOFactory daoFactory;

    public TrajetDaoImp(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    public Trajet findSpecificTrajet(Trajet trajet) throws SQLException {

        String sql = "SELECT ID_TRAJET, VILLE_DEPART, QUARTIER_DEPART, RUE_DEPART," +
                " VILLE_DESTINATION, QUARTIER_DESTINATION, RUE_DESTINATION FROM TRAJET " +
                "WHERE VILLE_DEPART = ? and QUARTIER_DEPART = ? and RUE_DEPART = ?" +
                " and VILLE_DESTINATION = ? and QUARTIER_DESTINATION = ? and RUE_DESTINATION = ?";
        PreparedStatement preparedStmt = null;
        ResultSet resultset;
        Connection connection = daoFactory.getConnection();
        preparedStmt = connection.prepareStatement(sql);
        preparedStmt.setString(1, trajet.getVilleDepart());
        preparedStmt.setString(2, trajet.getQuartierDepart());
        preparedStmt.setString(3, trajet.getRueDepart());
        preparedStmt.setString(4, trajet.getVilleDestination());
        preparedStmt.setString(5, trajet.getQuartierDestination());
        preparedStmt.setString(6, trajet.getRueDestination());

        resultset = preparedStmt.executeQuery();
        Trajet returnedTrajet;
        if( resultset.next() ) {
            Long idTrajet = resultset.getLong("ID_TRAJET");
            String villeDepart = resultset.getString("VILLE_DEPART");
            String quartierDepart = resultset.getString("QUARTIER_DEPART");
            String rueDepart = resultset.getString("RUE_DEPART");
            String villeDestination = resultset.getString("VILLE_DESTINATION");
            String quartierDestination = resultset.getString("QUARTIER_DESTINATION");
            String rueDestination = resultset.getString("RUE_DESTINATION");
            returnedTrajet = new Trajet(idTrajet,
                    villeDepart, quartierDepart, rueDepart,
                    villeDestination, quartierDestination, rueDestination);
        } else {
            returnedTrajet = null;
        }

        preparedStmt.close();
        resultset.close();
        connection.close();

        return returnedTrajet;
    }
    public List<Trajet> findAllTrajets() throws SQLException {
        List<Trajet> listOfTrajets = new ArrayList<Trajet>();

        String sql = "SELECT ID_TRAJET, VILLE_DEPART, QUARTIER_DEPART, RUE_DEPART," +
                " VILLE_DESTINATION, QUARTIER_DESTINATION, RUE_DESTINATION FROM TRAJET";
        Statement stmt = null;
        ResultSet resultset;
        Connection connection = DAOFactory.getInstance().getConnection();
        stmt = connection.createStatement();
        resultset = stmt.executeQuery(sql);

        Long idTrajet;
        String villeDepart, quartierDepart, rueDepart, villeDestination, quartierDestination, rueDestination;
        Trajet TrajetToAdd;

        while( resultset.next() ) {
            idTrajet = resultset.getLong("ID_TRAJET");
            villeDepart = resultset.getString("VILLE_DEPART");
            quartierDepart = resultset.getString("QUARTIER_DEPART");
            rueDepart = resultset.getString("RUE_DEPART");
            villeDestination = resultset.getString("VILLE_DESTINATION");
            quartierDestination = resultset.getString("QUARTIER_DESTINATION");
            rueDestination = resultset.getString("RUE_DESTINATION");
            TrajetToAdd = new Trajet(idTrajet,villeDepart,quartierDepart,rueDepart,
                    villeDestination,quartierDestination,rueDestination);
            listOfTrajets.add(TrajetToAdd);
        }

        stmt.close();
        resultset.close();
        connection.close();

        return listOfTrajets;
    }
    public Long insertTrajet(Trajet trajet) throws SQLException {
        Long IdrowInserted;
        String sql = "INSERT INTO TRAJET(VILLE_DEPART, QUARTIER_DEPART, RUE_DEPART, " +
                "VILLE_DESTINATION, QUARTIER_DESTINATION, RUE_DESTINATION) " +
                "VALUES(?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStmt;
        ResultSet resultSet;
        Connection connection = DAOFactory.getInstance().getConnection();
        preparedStmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preparedStmt.setString(1, trajet.getVilleDepart());
        preparedStmt.setString(2, trajet.getQuartierDepart());
        preparedStmt.setString(3, trajet.getRueDepart());
        preparedStmt.setString(4, trajet.getVilleDestination());
        preparedStmt.setString(5, trajet.getQuartierDestination());
        preparedStmt.setString(6, trajet.getRueDestination());
        preparedStmt.execute();
        resultSet = preparedStmt.getGeneratedKeys();

        if(resultSet.next()) {
            IdrowInserted = resultSet.getLong(1);
            connection.commit();
        } else {
            IdrowInserted = -1L;
        }

        preparedStmt.close();
        connection.close();

        return  IdrowInserted;
    }
}
