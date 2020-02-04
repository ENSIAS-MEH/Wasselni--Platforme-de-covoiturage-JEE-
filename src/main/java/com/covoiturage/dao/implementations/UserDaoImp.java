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
            sql = "SELECT ID, NOM, PRENOM, SEXE, DATE_NAISSANCE, REGION, LOGIN, EMAIL, PASSWORD, " +
                    "IMAGE_PATH, DATE_INSCRIPTION, RANK, ACTIVATION "+
                    "FROM USERS WHERE LOGIN = ? ";
            preparedStmt = connection.prepareStatement(sql);
            preparedStmt.setString(1,user.getLogin());
        }

        if(user.getEmail() != null) {
            sql = "SELECT ID, NOM, PRENOM, SEXE, DATE_NAISSANCE, REGION, LOGIN, EMAIL, PASSWORD, " +
                    "IMAGE_PATH, DATE_INSCRIPTION, RANK, ACTIVATION "+
                    "FROM USERS WHERE EMAIL = ? ";
            preparedStmt = connection.prepareStatement(sql);
            preparedStmt.setString(1,user.getEmail());
        }

        resultset = preparedStmt.executeQuery();
        User returnedUser;
        if( resultset.next() ) {
            returnedUser = new User();
            returnedUser.setId(resultset.getLong("ID"));
            returnedUser.setNom(resultset.getString("NOM"));
            returnedUser.setPrenom(resultset.getString("PRENOM"));
            returnedUser.setSexe(resultset.getString("SEXE"));
            returnedUser.setDateNaissance(resultset.getObject("DATE_NAISSANCE", LocalDate.class));
            returnedUser.setRegion(resultset.getString("REGION"));
            returnedUser.setLogin(resultset.getString("LOGIN"));
            returnedUser.setEmail(resultset.getString("EMAIL"));
            returnedUser.setPassword(resultset.getString("PASSWORD"));
            returnedUser.setImage(resultset.getString("IMAGE_PATH"));
            returnedUser.setDateInscription(resultset.getObject("DATE_INSCRIPTION", LocalDateTime.class));
            returnedUser.setRank(resultset.getFloat("RANK"));
            returnedUser.setActivation(resultset.getInt("ACTIVATION"));
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
        Statement stmt;
        ResultSet resultset;
        Connection connection = DAOFactory.getInstance().getConnection();
        List<User> listofUsers = new ArrayList<User>();
        sql = "SELECT ID, NOM, PRENOM, SEXE, DATE_NAISSANCE, REGION, LOGIN, EMAIL, PASSWORD, " +
                "IMAGE_PATH, DATE_INSCRIPTION, RANK, ACTIVATION " +
                "FROM USERS";
        stmt = connection.createStatement();
        resultset = stmt.executeQuery(sql);

        Long id;
        String nom, prenom, sexe, login, email, password, region, image;
        LocalDate dateNaissance;
        LocalDateTime dateInscription;
        float rank;
        int activation;
        User usertoAdd;

        while( resultset.next() ) {
            id = resultset.getLong("ID");
            nom = resultset.getString("NOM");
            prenom = resultset.getString("PRENOM");;
            sexe = resultset.getString("SEXE");
            dateNaissance = resultset.getObject("DATE_NAISSANCE", LocalDate.class);
            region = resultset.getString("REGION");
            login = resultset.getString("LOGIN");
            email = resultset.getString("EMAIL");
            password = resultset.getString("PASSWORD");
            image = resultset.getString("IMAGE_PATH");
            dateInscription = resultset.getObject("DATE_INSCRIPTION",LocalDateTime.class);
            rank = resultset.getFloat("RANK");
            activation = resultset.getInt("ACTIVATION");
            usertoAdd = new User(id,nom,prenom,sexe,dateNaissance,region,login,email,password,image,dateInscription,rank,activation);
            listofUsers.add(usertoAdd);
        }

        resultset.close();
        stmt.close();
        connection.close();

        return listofUsers;
    }

    @Override
    public Long insertUser(User user) throws SQLException {
        Long idrowInserted;
        String sql;
        PreparedStatement preparedStmt = null;
        ResultSet resultset;
        Connection connection = DAOFactory.getInstance().getConnection();
        //Rank est par Defaut 5
        sql = "INSERT INTO users (ID, NOM, PRENOM, SEXE, DATE_NAISSANCE, REGION, LOGIN, EMAIL, PASSWORD, " +
                "IMAGE_PATH, DATE_INSCRIPTION, RANK, ACTIVATION) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        preparedStmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preparedStmt.setLong(1, user.getId());
        preparedStmt.setString(2, user.getNom());
        preparedStmt.setString(3, user.getPrenom());
        preparedStmt.setString(4, user.getSexe());
        preparedStmt.setObject(5, user.getDateNaissance());
        preparedStmt.setString(6, user.getRegion());
        preparedStmt.setString(7, user.getLogin());
        preparedStmt.setString(8, user.getEmail());
        preparedStmt.setString(9, user.getPassword());
        preparedStmt.setString(10, user.getImage());
        preparedStmt.setObject(11, LocalDateTime.now());
        preparedStmt.setFloat(12, user.getRank());
        preparedStmt.setInt(13, user.getActivation());
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

    @Override
    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated;
        String sql;
        PreparedStatement preparedStmt = null;
        Connection connection = DAOFactory.getInstance().getConnection();
        sql = "UPDATE users set NOM = ? , PRENOM = ? , SEXE = ? , DATE_NAISSANCE = ? , " +
                "REGION = ? , LOGIN = ? , EMAIL = ? , PASSWORD = ? , " +
                "IMAGE_PATH = ? , RANK = ? , ACTIVATION = ? where ID = ?";
        preparedStmt = connection.prepareStatement(sql);
        preparedStmt.setString(1, user.getNom());
        preparedStmt.setString(2, user.getPrenom());
        preparedStmt.setString(3, user.getSexe());
        preparedStmt.setObject(4, user.getDateNaissance());
        preparedStmt.setString(5, user.getRegion());
        preparedStmt.setString(6, user.getLogin());
        preparedStmt.setString(7, user.getEmail());
        preparedStmt.setString(8, user.getPassword());
        preparedStmt.setString(9, user.getImage());
        preparedStmt.setFloat(10, user.getRank());
        preparedStmt.setInt(11, user.getActivation());
        preparedStmt.setLong(12, user.getId());
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
        PreparedStatement preparedStmt;
        Connection connection = DAOFactory.getInstance().getConnection();
        sql = "DELETE from users where ID = ?";
        preparedStmt = connection.prepareStatement(sql);
        preparedStmt.setLong(1, user.getId());
        rowDeleted = preparedStmt.executeUpdate() > 0;
        if(rowDeleted) {
            connection.commit();
        }

        preparedStmt.close();
        connection.close();

        return rowDeleted;
    }
}