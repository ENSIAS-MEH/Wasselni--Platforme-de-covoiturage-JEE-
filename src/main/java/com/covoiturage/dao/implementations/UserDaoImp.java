package com.covoiturage.dao.implementations;

import com.covoiturage.beans.User;
import com.covoiturage.dao.DAOFactory;
import com.covoiturage.dao.exceptions.DAOException;
import com.covoiturage.dao.interfaces.UserDao;

public class UserDaoImp implements UserDao {
    private DAOFactory daoFactory;

    public UserDaoImp(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void creer(User user) throws DAOException {

    }

    @Override
    public User trouver(String login) throws DAOException {
        return null;
    }
}