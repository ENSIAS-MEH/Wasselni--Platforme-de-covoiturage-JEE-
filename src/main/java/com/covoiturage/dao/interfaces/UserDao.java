package com.covoiturage.dao.interfaces;

import com.covoiturage.beans.User;
import com.covoiturage.dao.exceptions.DAOException;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {

    public User findSpecificUser(User user) throws SQLException;
    public List<User> findAllUsers() throws SQLException;
    public Long insertUser(User user) throws SQLException;
    public boolean updateUser(User user) throws SQLException;
    public boolean deleteUser(User user) throws SQLException;
    public String getImageProfile(User user) throws SQLException;
    public void setImageProfile(User user) throws  SQLException;
    public void setUserActivation(User user) throws SQLException;
    public int getUserActivation(User user) throws SQLException;
    public User findUserByIdDetailsTrajet(Long id) throws SQLException;

}
