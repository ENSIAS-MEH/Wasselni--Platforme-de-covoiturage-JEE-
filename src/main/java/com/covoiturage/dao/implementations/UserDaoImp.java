package com.covoiturage.dao.implementations;

import com.covoiturage.beans.User;
import com.covoiturage.dao.DAOFactory;
import com.covoiturage.dao.exceptions.DAOException;
import com.covoiturage.dao.interfaces.UserDao;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImp implements UserDao {
    private DAOFactory daoFactory;

    public UserDaoImp(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public User findSpecificUser(User user) throws SQLException {
        String sql;
        PreparedStatement preparedStmt = null;
        ResultSet resultset;
        Connection connection = DAOFactory.getInstance().getConnection();

        if(user.getLogin() != null) {
            sql = "SELECT CIN, NOM, PRENOM, DATE_NAISSANCE, SEXE, LOGIN, EMAIL, PASSWORD, DATE_INSCRIPTION, RANK "+
                    "FROM USERS WHERE LOGIN = ? ";
            preparedStmt = connection.prepareStatement(sql);
            preparedStmt.setString(1,user.getLogin());
        }

        if(user.getEmail() != null) {
            sql = "SELECT CIN, NOM, PRENOM, DATE_NAISSANCE, SEXE, LOGIN, EMAIL, PASSWORD, DATE_INSCRIPTION, RANK "+
                    "FROM USERS WHERE EMAIL = ? ";
            preparedStmt = connection.prepareStatement(sql);
            preparedStmt.setString(1,user.getEmail());
        }

        resultset = preparedStmt.executeQuery();
        User returnedUser;
        if( resultset.next() ) {
            returnedUser = new User();
            returnedUser.setCin(resultset.getString("CIN"));
            returnedUser.setNom(resultset.getString("NOM"));
            returnedUser.setPrenom(resultset.getString("PRENOM"));
            returnedUser.setDateNaissance(resultset.getObject("DATE_NAISSANCE", LocalDate.class));
            returnedUser.setSexe(resultset.getString("SEXE"));
            returnedUser.setLogin(resultset.getString("LOGIN"));
            returnedUser.setEmail(resultset.getString("EMAIL"));
            returnedUser.setPassword(resultset.getString("PASSWORD"));
            returnedUser.setDateInscription(resultset.getObject("DATE_INSCRIPTION", LocalDateTime.class));
            returnedUser.setRank(resultset.getFloat("RANK"));
        } else {
            returnedUser = null;
        }

        resultset.close();
        preparedStmt.close();
        connection.close();

        return returnedUser;
    }

    @Override
    public List<User> findAllUsers() throws SQLException {
        String sql;
        Statement stmt= null;
        ResultSet resultset;
        Connection connection = DAOFactory.getInstance().getConnection();
        List<User> listofUsers = new ArrayList<User>();
        sql = "SELECT CIN, NOM, PRENOM, DATE_NAISSANCE, SEXE, LOGIN, EMAIL, PASSWORD, DATE_INSCRIPTION, RANK " +
                "FROM USERS";
        stmt = connection.createStatement();
        resultset = stmt.executeQuery(sql);

        String cin, nom, prenom, sexe, login, email, password;
        LocalDate dateNaissance;
        LocalDateTime dateInscription;
        float rank;
        User usertoAdd;

        while( resultset.next() ) {
            cin = resultset.getString("CIN");
            nom = resultset.getString("NOM");
            prenom = resultset.getString("PRENOM");;
            dateNaissance = resultset.getObject("DATE_NAISSANCE", LocalDate.class);
            sexe = resultset.getString("SEXE");
            login = resultset.getString("LOGIN");
            email = resultset.getString("EMAIL");
            password = resultset.getString("PASSWORD");
            dateInscription = resultset.getObject("DATE_INSCRIPTION",LocalDateTime.class);
            rank = resultset.getFloat("RANK");
            usertoAdd = new User(cin,nom,prenom,dateNaissance,sexe,login,email,password,dateInscription,rank);
            listofUsers.add(usertoAdd);
        }

        resultset.close();
        stmt.close();
        connection.close();

        return listofUsers;
    }

    @Override
    public boolean insertUser(User user) throws SQLException {
        boolean rowInserted;
        String sql;
        PreparedStatement preparedStmt = null;
        ResultSet resultset;
        Connection connection = DAOFactory.getInstance().getConnection();
        //Rank est par Defaut 5
        sql = "INSERT INTO users (CIN, NOM, PRENOM, DATE_NAISSANCE, SEXE, LOGIN, EMAIL, PASSWORD, DATE_INSCRIPTION) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        preparedStmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preparedStmt.setString(1, user.getCin());
        preparedStmt.setString(2, user.getNom());
        preparedStmt.setString(3, user.getPrenom());
        preparedStmt.setObject(4, user.getDateNaissance());
        preparedStmt.setString(5, user.getSexe());
        preparedStmt.setString(6, user.getLogin());
        preparedStmt.setString(7, user.getEmail());
        preparedStmt.setString(8, user.getPassword());
        preparedStmt.setObject(9, LocalDateTime.now());
        rowInserted = preparedStmt.execute();
        if(rowInserted) {
            connection.commit();
        }

        preparedStmt.close();
        connection.close();

        return  rowInserted;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated;
        String sql;
        PreparedStatement preparedStmt = null;
        Connection connection = DAOFactory.getInstance().getConnection();
        sql = "UPDATE users set NOM = ? , PRENOM = ? , DATE_NAISSANCE = ? , " +
                "SEXE = ? , LOGIN = ? , EMAIL = ?, PASSWORD = ? , RANK = ? where CIN = ?";
        preparedStmt = connection.prepareStatement(sql);
        preparedStmt.setString(1, user.getNom());
        preparedStmt.setString(2, user.getPrenom());
        preparedStmt.setObject(3, user.getDateNaissance());
        preparedStmt.setString(4, user.getSexe());
        preparedStmt.setString(5, user.getLogin());
        preparedStmt.setString(6, user.getEmail());
        preparedStmt.setString(7, user.getPassword());
        preparedStmt.setObject(8, user.getRank());
        preparedStmt.setString(9, user.getCin());
        rowUpdated = preparedStmt.executeUpdate() > 0;
        if(rowUpdated) {
            connection.commit();
        }

        preparedStmt.close();
        connection.close();

        return rowUpdated;
    }

    @Override
    public boolean deleteUser(User user) throws SQLException {
        boolean rowDeleted;
        String sql;
        PreparedStatement preparedStmt = null;
        Connection connection = DAOFactory.getInstance().getConnection();
        sql = "DELETE from users where CIN = ?";
        preparedStmt = connection.prepareStatement(sql);
        preparedStmt.setString(1, user.getCin());
        rowDeleted = preparedStmt.executeUpdate() > 0;
        if(rowDeleted) {
            connection.commit();
        }

        preparedStmt.close();
        connection.close();

        return rowDeleted;
    }
}