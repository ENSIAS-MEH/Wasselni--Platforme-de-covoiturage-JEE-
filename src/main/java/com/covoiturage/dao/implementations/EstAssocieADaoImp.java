package com.covoiturage.dao.implementations;

import com.covoiturage.beans.EstAssociea;
import com.covoiturage.dao.DAOFactory;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EstAssocieADaoImp {

    public EstAssociea findSpecificEstAssocieA(EstAssociea estAssociea) throws SQLException {
        String sql = "SELECT ID_DETAILS_TRAJET_ASSOCIE, CIN_ASSOCIE, TYPE_ASSOCIATION, DATE_ASSOCIATION FROM ESTASSOCIE_A " +
                "WHERE ID_DETAILS_TRAJET_ASSOCIE = ? and CIN_ASSOCIE = ?";
        PreparedStatement preparedStmt;
        ResultSet resultset;
        Connection connection = DAOFactory.getInstance().getConnection();
        preparedStmt = connection.prepareStatement(sql);
        preparedStmt.setLong(1, estAssociea.getIdDetailsTrajet());
        preparedStmt.setString(2, estAssociea.getCinUser());

        resultset = preparedStmt.executeQuery();
        EstAssociea returnedEstAssociea;
        if( resultset.next() ) {
            Long idDetailsTrajet = resultset.getLong("ID_DETAILS_TRAJET_ASSOCIE");
            String cinUser = resultset.getString("CIN_USER");
            String typeAssociation = resultset.getString("TYPE_ASSOCIATION");
            LocalDateTime dateAssociation = resultset.getObject("DATE_ASSOCIATION", LocalDateTime.class);
            returnedEstAssociea = new EstAssociea(idDetailsTrajet, cinUser, typeAssociation, dateAssociation);
        } else {
            returnedEstAssociea = null;
        }

        preparedStmt.close();
        resultset.close();
        connection.close();

        return returnedEstAssociea;
    }

    public List<EstAssociea> findAllEstAssocieA() throws SQLException {
        List<EstAssociea> listofEstAssocieA = new ArrayList<EstAssociea>();
        String sql = "SELECT ID_DETAILS_TRAJET_ASSOCIE, CIN_ASSOCIE, TYPE_ASSOCIATION, DATE_ASSOCIATION FROM ESTASSOCIE_A ";
        Statement stmt;
        ResultSet resultset;
        Connection connection = DAOFactory.getInstance().getConnection();
        stmt = connection.createStatement();
        resultset = stmt.executeQuery(sql);
        Long idDetailsTrajet;
        String cinUser, typeAssociation;
        LocalDateTime dateAssociation;
        EstAssociea EstAssocieaToAdd;
        while (resultset.next()) {
            idDetailsTrajet = resultset.getLong("ID_DETAILS_TRAJET_ASSOCIE");
            cinUser = resultset.getString("CIN_USER");
            typeAssociation = resultset.getString("TYPE_ASSOCIATION");
            dateAssociation = resultset.getObject("DATE_ASSOCIATION", LocalDateTime.class);
            EstAssocieaToAdd = new EstAssociea(idDetailsTrajet, cinUser, typeAssociation, dateAssociation);
            listofEstAssocieA.add(EstAssocieaToAdd);
        }

        stmt.close();
        resultset.close();
        connection.close();

        return listofEstAssocieA;
    }

    public Long insertEstAssocieA(EstAssociea estAssociea) throws SQLException {
        Long idrowInserted;
        String sql = "INSERT INTO ESTASSOCIE_A(ID_DETAILS_TRAJET_ASSOCIE, CIN_ASSOCIE, TYPE_ASSOCIATION, DATE_ASSOCIATION) " +
                "VALUES (?,?,?,?)";
        PreparedStatement preparedStmt;
        ResultSet resultset;
        Connection connection = DAOFactory.getInstance().getConnection();
        preparedStmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preparedStmt.setLong(1, estAssociea.getIdDetailsTrajet());
        preparedStmt.setString(2, estAssociea.getCinUser());
        preparedStmt.setString(3, estAssociea.getTypeAssociation());
        preparedStmt.setObject(4, LocalDateTime.now());
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

    public boolean updateEstAssocieA(EstAssociea estAssociea) throws SQLException {
        boolean rowUpdated;
        String sql = "UPDATE ESTASSOCIE_A SET TYPE_ASSOCIATION = ? WHERE CIN_ASSOCIE = ? and ID_DETAILS_TRAJET_ASSOCIE = ?";
        PreparedStatement preparedStmt;
        Connection connection = DAOFactory.getInstance().getConnection();
        preparedStmt = connection.prepareStatement(sql);
        preparedStmt.setString(1, estAssociea.getTypeAssociation());
        preparedStmt.setString(2, estAssociea.getCinUser());
        preparedStmt.setLong(3, estAssociea.getIdDetailsTrajet());
        rowUpdated = preparedStmt.executeUpdate() > 0;
        if( rowUpdated ) {
            connection.commit();
        }

        preparedStmt.close();
        connection.close();

        return rowUpdated;
    }
}
