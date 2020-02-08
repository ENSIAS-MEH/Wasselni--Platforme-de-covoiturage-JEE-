package com.covoiturage.dao.implementations;

import com.covoiturage.beans.DetailsTrajet;
import com.covoiturage.beans.Trajet;
import com.covoiturage.dao.DAOFactory;
import com.covoiturage.dao.interfaces.TrajetDao;

import java.sql.*;
import java.text.SimpleDateFormat;
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

    @Override
    public Trajet findSpecifictrajetById(Long id) throws SQLException {

        String sql = "SELECT ID_TRAJET, VILLE_DEPART, " +
                " VILLE_DESTINATION FROM TRAJET " +
                "WHERE ID_TRAJET= ? ";
        PreparedStatement preparedStmt = null;
        ResultSet resultset;
        Connection connection = daoFactory.getConnection();
        preparedStmt = connection.prepareStatement(sql);
        preparedStmt.setLong(1, id);

        resultset = preparedStmt.executeQuery();
        Trajet returnedTrajet;
        if( resultset.next() ) {
            Long idTrajet = resultset.getLong("ID_TRAJET");
            String villeDepart = resultset.getString("VILLE_DEPART");
            String villeDestination = resultset.getString("VILLE_DESTINATION");
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
                " VILLE_DESTINATION FROM TRAJET where VILLE_DEPART like ? and VILLE_DESTINATION like  ? and ID_TRAJET in " +
                "(select ID_TRAJET_CHOISIE from details_trajet where EFFECTIF = ? and bagage = ?  and DATETIME_DEPART like ?)";
        PreparedStatement preparedStmt = null;
        ResultSet resultset;
        Connection connection = daoFactory.getConnection();
        preparedStmt = connection.prepareStatement(sql);
        preparedStmt.setString(1, "%"+trajet.getVilleDepart()+"%");
        preparedStmt.setString(2,"%"+trajet.getVilleDestination()+"%");
        preparedStmt.setInt(3, detailsTrajet.getEffectif());
        preparedStmt.setInt(4, detailsTrajet.getBagage());
        String date = ""+detailsTrajet.getDateDepart();
        date = date.split("T")[0];
        preparedStmt.setString(5, "%"+date+"%");

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

    @Override
    public List<DetailsTrajet> findDetailleTrajetById(Long id) throws SQLException {
        List<DetailsTrajet> listDetails = new ArrayList<DetailsTrajet>();

        String sql = "SELECT ID_DETAILS_TRAJET, DATETIME_DEPART, PRIX_PLACE, TYPE_VOITURE, MODELE_VOITURE, MARQUE_VOITURE, "+
                "CLIMATISATION_VOITURE, EFFECTIF, ID_TRAJET_CHOISIE, bagage from details_trajet where ID_DETAILS_TRAJET in"+
                " (select ID_DETAILS_TRAJET_ASSOCIE from estassocie_a where ID_USER_ASSOCIE = ?) ORDER BY DATETIME_DEPART";
        PreparedStatement preparedStmt = null;
        ResultSet resultset;
        Connection connection = daoFactory.getConnection();
        preparedStmt = connection.prepareStatement(sql);
        preparedStmt.setLong(1, id);

        resultset = preparedStmt.executeQuery();
        Long idTrajet, idDetaille;
        LocalDateTime date_depart;
        String type_voiture, modele_voiture,  marque_voiture;
        int climatisation,effectif,prix_place, bagage;

        DetailsTrajet TrajetToAdd;

        while( resultset.next() ) {
            idDetaille = resultset.getLong("ID_DETAILS_TRAJET");
            date_depart = resultset.getObject("DATETIME_DEPART",LocalDateTime.class);
             prix_place = resultset.getInt("PRIX_PLACE");
            type_voiture = resultset.getString("TYPE_VOITURE");
            modele_voiture = resultset.getString("MODELE_VOITURE");
            marque_voiture = resultset.getString("MARQUE_VOITURE");
            climatisation = resultset.getInt("CLIMATISATION_VOITURE");
            effectif = resultset.getInt("EFFECTIF");
            idTrajet = resultset.getLong("ID_TRAJET_CHOISIE");
            bagage = resultset.getInt("BAGAGE");





            TrajetToAdd = new DetailsTrajet(idDetaille,date_depart,prix_place,type_voiture,modele_voiture,marque_voiture
            ,climatisation,effectif,idTrajet,bagage);
            listDetails.add(TrajetToAdd);
        }

        preparedStmt.close();
        resultset.close();

        return listDetails;
    }

    @Override
    public List<Trajet> findAllTrajets(Trajet trajet, DetailsTrajet detailsTrajet, int min, int max) throws SQLException {
        List<Trajet> listOfTrajets = new ArrayList<Trajet>();

        String sql = "SELECT ID_TRAJET, VILLE_DEPART," +
                " VILLE_DESTINATION FROM TRAJET where VILLE_DEPART like ? and VILLE_DESTINATION like  ? and ID_TRAJET in " +
                "(select ID_TRAJET_CHOISIE from details_trajet where DATETIME_DEPART like ? " +
                "and prix_place between ? and ?)";
        PreparedStatement preparedStmt = null;
        ResultSet resultset;
        Connection connection = daoFactory.getConnection();
        preparedStmt = connection.prepareStatement(sql);
        preparedStmt.setString(1, "%"+trajet.getVilleDepart()+"%");
        preparedStmt.setString(2,"%"+trajet.getVilleDestination()+"%");
        String date = ""+detailsTrajet.getDateDepart();
        date = date.split("T")[0];
        preparedStmt.setString(3, "%"+date+"%");
        preparedStmt.setInt(4, min);
        preparedStmt.setInt(5, max);


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


}
