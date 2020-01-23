package com.covoiturage.dao.interfaces;

import com.covoiturage.beans.User;
import com.covoiturage.dao.exceptions.DAOException;

public interface UserDao {

    void creer( User user ) throws DAOException;
    User trouver( String login ) throws DAOException;
    /*
     * Méthodes à ajouter
     */
}
