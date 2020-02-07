package com.covoiturage.forms;

import com.covoiturage.beans.User;
import com.covoiturage.dao.interfaces.UserDao;
import com.covoiturage.mailer.Mailer;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UpdateUserForm {
    private UserDao userDao;

    public UpdateUserForm(UserDao userDao) {
        this.userDao = userDao;
    }

    private static final String CHAMP_NOM       = "nom";
    private static final String CHAMP_PRENOM    = "prenom";
    private static final String CHAMP_REGION     = "adresse";
    private static final String CHAMP_NOUVEAU_MOT_DE_PASSE     = "nouveaumotdepasse";
    private static final String CHAMP_CONFIRMATION_MOT_DE_PASSE = "confirmation";

    private static final String ATT_SESSION_USER = "userSession";
    private String resultat;
    private Map<String, String> erreurs= new HashMap();

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public String getResultat() {
        return resultat;
    }

    public User updateUser(HttpServletRequest req){
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute(ATT_SESSION_USER);
        try {
            String nom = getValeurChamp(req, CHAMP_NOM);
            String prenom = getValeurChamp(req, CHAMP_PRENOM);
            String region = getValeurChamp(req, CHAMP_REGION);
            String nouveauMotDePasse = getValeurChamp(req,CHAMP_NOUVEAU_MOT_DE_PASSE);
            String confirmation = getValeurChamp(req, CHAMP_CONFIRMATION_MOT_DE_PASSE);

            user.setRegion(region);
            traiterNom(nom, user);
            traiterPrenom(prenom, user);
            if(nouveauMotDePasse == null){
            } else {
                traiterMotDePasse(nouveauMotDePasse, confirmation, user);
            }

            if (erreurs.isEmpty()) {
                userDao.updateUser(user);
                session.setAttribute(ATT_SESSION_USER,user);
                resultat = "Succés de la modification";
            } else {
                resultat = "Echec de la modification";
            }
        } catch (SQLException sql) {
            resultat = "Échec de la modification : une erreur imprévue est survenue, merci de réessayer dans quelques instants.";
            sql.printStackTrace();
        }
        return user;
    }
    /**
     * Méthodes de traitement
     */

    private void traiterNom(String nom,User user){
        try {
            validationNom( nom );
        } catch ( Exception e ) {
            setErreur( CHAMP_NOM, e.getMessage() );
        }
        user.setNom( nom );
    }
    private void traiterPrenom(String prenom,User user){
        try {
            validationPrenom( prenom );
        } catch ( Exception e ) {
            setErreur( CHAMP_PRENOM, e.getMessage() );
        }
        user.setPrenom( prenom );
    }


    private void traiterMotDePasse(String motDePasse , String confirmation,User user){
        try {
            validationMotDePasse( motDePasse , confirmation );
        } catch ( Exception e ) {
            setErreur( CHAMP_NOUVEAU_MOT_DE_PASSE, e.getMessage() );
        }
        user.setPassword(motDePasse);
    }


    /**
     * Méthodes de validation
     */

    private void validationNom( String nom ) throws Exception {
        if ( nom != null ) {
            if ( nom.length() < 2 ) {
                throw new Exception( "Le nom d'utilisateur doit contenir au moins 2 caractères." );
            }
        } else {
            throw new Exception( "Merci d'entrer un nom d'utilisateur." );
        }
    }

    private void validationPrenom( String prenom ) throws Exception {
        if ( prenom != null && prenom.length() < 2 ) {
            throw new Exception( "Le prénom d'utilisateur doit contenir au moins 2 caractères." );
        }
        if (prenom == null) {
            throw new Exception( "Merci de saisir une prénom d'utilisateur valide." );
        }
    }

    private void validationMotDePasse(String motDePasse,String confirmation) throws Exception{
        if (motDePasse != null && confirmation != null) {
            if (!motDePasse.equals(confirmation)) {
                throw new Exception("Les mots de passe entrés sont différents, merci de les saisir à nouveau.");
            } else if (motDePasse.trim().length() < 3) {
                throw new Exception("Les mots de passe doivent contenir au moins 3 caractères.");
            }
        } else {
            throw new Exception("Merci de saisir et confirmer votre mot de passe.");
        }
    }
    private void validationEmail(String email) throws Exception{
        User user = new User();
        user.setEmail(email);
        if ( email != null) {
            if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
                throw new Exception( "Merci de saisir une adresse mail valide." );
            }else if ( userDao.findSpecificUser( user ) != null ) {
                throw new Exception( "Cette adresse email est déjà utilisée, merci d'en choisir une autre." );
            }
        } else {
            throw new Exception( "Merci de saisir une adresse mail." );
        }
    }

    /**
     * Méthodes utiles
     */
    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }
    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }
}
