package com.covoiturage.dao;
import com.covoiturage.beans.EstAssociea;
import com.covoiturage.beans.User;
import com.covoiturage.dao.exceptions.DAOConfigurationException;
import com.covoiturage.dao.implementations.DetailsTrajetDaoImp;
import com.covoiturage.dao.implementations.EstAssocieADaoImp;
import com.covoiturage.dao.implementations.TrajetDaoImp;
import com.covoiturage.dao.implementations.UserDaoImp;
import com.covoiturage.dao.interfaces.DetailsTrajetDao;
import com.covoiturage.dao.interfaces.EstAssocieADao;
import com.covoiturage.dao.interfaces.TrajetDao;
import com.covoiturage.dao.interfaces.UserDao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DAOFactory {

    private static final String FICHIER_PROPERTIES       = "dao.properties";
    private static final String PROPERTY_URL             = "url";
    private static final String PROPERTY_DRIVER          = "driver";
    private static final String PROPERTY_NOM_UTILISATEUR = "nomutilisateur";
    private static final String PROPERTY_MOT_DE_PASSE    = "motdepasse";

    private static DAOFactory instance;
    private Connection connection;

    // Pas besoin de ces objets ?
    private String url;
    private String username;
    private String password;

    /*
     * Constructeur privé chargé de récupérer les informations de connexion à la base de
     * données, charger le driver JDBC afin d'établir une connection avec la base de Données
     * */
    DAOFactory( String url, String username, String password ) throws SQLException {
        this.url = url;
        this.username = username;
        this.password = password;
        this.connection = DriverManager.getConnection(url,username,password);
    }
    public static DAOFactory getInstance() throws DAOConfigurationException, SQLException {
        Properties properties = new Properties();
        String url;
        String driver;
        String nomUtilisateur;
        String motDePasse;

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream fichierProperties = classLoader.getResourceAsStream( FICHIER_PROPERTIES );

        if ( fichierProperties == null ) {
            throw new DAOConfigurationException( "Le fichier properties " + FICHIER_PROPERTIES + " est introuvable." );
        }

        try {
            properties.load( fichierProperties );
            url = properties.getProperty( PROPERTY_URL );
            driver = properties.getProperty( PROPERTY_DRIVER );
            nomUtilisateur = properties.getProperty( PROPERTY_NOM_UTILISATEUR );
            motDePasse = properties.getProperty( PROPERTY_MOT_DE_PASSE );
        } catch ( IOException e ) {
            throw new DAOConfigurationException( "Impossible de charger le fichier properties " + FICHIER_PROPERTIES, e );
        }

        try {
            Class.forName( driver );

        } catch (ClassNotFoundException e ) {
            throw new DAOConfigurationException( "Le driver est introuvable dans le classpath.", e );
        }

        DAOFactory instance = new DAOFactory( url, nomUtilisateur, motDePasse );
        return instance;
    }

    /*
     * Méthode chargée de fournir une connexion à la base de données
     */
    public Connection getConnection() {
        return connection;
    }

    /*
     * Méthodes de récupération de l'implémentation des différents DAO
     */
    public UserDao getUserDao() {
        return new UserDaoImp( this );
    }
    public TrajetDao getTrajetDao()  { return new TrajetDaoImp(this);}
    public EstAssocieADao getEstAssocieADao() { return new EstAssocieADaoImp(this);}
    public DetailsTrajetDao getDetailsTrajetDao() { return new DetailsTrajetDaoImp(this);}


}