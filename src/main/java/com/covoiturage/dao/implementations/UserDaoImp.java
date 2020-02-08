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
                    "IMAGE_PATH, DATE_INSCRIPTION, RANK, ACTIVATION, ID_QUESTION_USER, reponse "+
                    "FROM USERS WHERE LOGIN = ? ";
            preparedStmt = connection.prepareStatement(sql);
            preparedStmt.setString(1,user.getLogin());
        }

        if(user.getEmail() != null) {
            sql = "SELECT ID, NOM, PRENOM, SEXE, DATE_NAISSANCE, REGION, LOGIN, EMAIL, PASSWORD, " +
                    "IMAGE_PATH, DATE_INSCRIPTION, RANK, ACTIVATION ,ID_QUESTION_USER, reponse "+
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
            returnedUser.setId_question(resultset.getInt("ID_question_user"));
            returnedUser.setReponse(resultset.getString("reponse"));
        } else {
            returnedUser = null;
        }

        resultset.close();
        preparedStmt.close();

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
                "IMAGE_PATH, DATE_INSCRIPTION, RANK, ACTIVATION, ID_QUESTION_USER, reponse " +
                "FROM USERS";
        stmt = connection.createStatement();
        resultset = stmt.executeQuery(sql);

        Long id;
        int id_question_user;
        String nom, prenom, sexe, login, email, password, region, image,reponse;
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
            id_question_user = resultset.getInt("Id_question_user");
            reponse = resultset.getString("reponse");

            usertoAdd = new User(id,nom,prenom,sexe,dateNaissance,region,login,email,password,image,dateInscription,rank,activation,id_question_user,reponse);
            listofUsers.add(usertoAdd);
        }

        resultset.close();
        stmt.close();

        return listofUsers;
    }

    @Override
    public Long insertUser(User user) throws SQLException {
        Long idrowInserted;
        String sql;
        PreparedStatement preparedStmt = null;
        ResultSet resultset;
        Connection connection = daoFactory.getConnection();
        //Rank est par Defaut 5
        sql = "INSERT INTO users (NOM, PRENOM, SEXE, DATE_NAISSANCE, IMAGE_PATH , REGION, LOGIN, EMAIL, PASSWORD, " +
                " DATE_INSCRIPTION,ACTIVATION,ID_QUESTION_USER,reponse) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        preparedStmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preparedStmt.setString(1, user.getNom());
        preparedStmt.setString(2, user.getPrenom());
        preparedStmt.setString(3, user.getSexe());
        preparedStmt.setObject(4, user.getDateNaissance());
        preparedStmt.setString(5, user.getImage());
        preparedStmt.setString(6, user.getRegion());
        preparedStmt.setString(7, user.getLogin());
        preparedStmt.setString(8, user.getEmail());
        preparedStmt.setString(9, user.getPassword());
        preparedStmt.setObject(10, LocalDateTime.now());
        preparedStmt.setInt(11, user.getActivation());
        preparedStmt.setInt(12, user.getId_question());
        preparedStmt.setString(13, user.getReponse());
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

        preparedStmt.close();


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


        preparedStmt.close();

        return rowDeleted;
    }

    @Override
    public String getImageProfile(User user) throws SQLException {
        String image_path = "0_image";
        Connection connection = DAOFactory.getInstance().getConnection();
        PreparedStatement ps = connection.prepareStatement("select IMAGE_PATH from users where id = ?");

        ps.setLong(1,user.getId());

        ResultSet rs = ps.executeQuery();

        if(rs.next()){
            image_path = rs.getString(1);
        }

        return image_path;

    }

    @Override
    public void setImageProfile(User user) throws SQLException {

        Connection connection = DAOFactory.getInstance().getConnection();

        PreparedStatement ps = connection.prepareStatement("insert into users  (IMAGE_PATH) values (?)");
        ps.setString(1,user.getImage());
        ps.execute();

    }
    public void setUserActivation(User user) throws SQLException{
        String sql;
        PreparedStatement preparedStmt;
        Connection connection = DAOFactory.getInstance().getConnection();
        sql = "UPDATE users set ACTIVATION = ? where ID = ?";
        preparedStmt = connection.prepareStatement(sql);
        preparedStmt.setInt(1,user.getActivation());
        preparedStmt.setLong(2, user.getId());
        preparedStmt.executeUpdate();
        connection.commit();
        return;
    };
    public int getUserActivation(User user) throws SQLException{
        String sql;
        PreparedStatement preparedStmt;
        ResultSet resultset;
        Connection connection = DAOFactory.getInstance().getConnection();
        sql = "select ACTIVATION from users where ID = ?";
        preparedStmt = connection.prepareStatement(sql);
        preparedStmt.setLong(1, user.getId());
        resultset = preparedStmt.executeQuery();
        return resultset.getInt("ACTIVATION");
    }

    @Override
    public User findUserByIdDetailsTrajet(Long id) throws SQLException {
        String sql;
        PreparedStatement preparedStmt = null;
        ResultSet resultset;
        Connection connection = DAOFactory.getInstance().getConnection();


            sql = "SELECT ID, NOM, PRENOM, SEXE, DATE_NAISSANCE, REGION, LOGIN, EMAIL, PASSWORD, " +
                    "IMAGE_PATH, DATE_INSCRIPTION, RANK, ACTIVATION ,ID_QUESTION_USER, reponse "+
                    "FROM USERS WHERE id in  (select  ID_USER_ASSOCIE from estassocie_a where ID_DETAILS_TRAJET_ASSOCIE = ?) ";
            preparedStmt = connection.prepareStatement(sql);
            preparedStmt.setLong(1,id);


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
            returnedUser.setId_question(resultset.getInt("ID_question_user"));
            returnedUser.setReponse(resultset.getString("reponse"));
        } else {
            returnedUser = null;
        }

        resultset.close();
        preparedStmt.close();

        return returnedUser;
    }






}