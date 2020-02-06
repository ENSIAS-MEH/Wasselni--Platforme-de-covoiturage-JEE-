package com.covoiturage.forms;

import com.covoiturage.beans.User;
import com.covoiturage.dao.exceptions.DAOException;
import com.covoiturage.dao.interfaces.UserDao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class UserAuthForm {
    private UserDao userDao;

    public UserAuthForm(UserDao userDao) {
        this.userDao = userDao;
    }

    private static final String CHAMP_MOT_DE_PASSE = "motdepasse";
    private static final String CHAMP_EMAIL = "email";

    private String resultat;
    private Map<String, String> erreurs = new HashMap();

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public String getResultat() {
        return resultat;
    }

    public User authentification(HttpServletRequest req) {
        User userConnect = new User();
        User userConnected = new User();
        try{
            String emailOuLogin = getValeurChamp(req, CHAMP_EMAIL);
            String motDePasse = getValeurChamp(req, CHAMP_MOT_DE_PASSE);

            traiterEmail(emailOuLogin,userConnect);
            userConnected = traiterUser(emailOuLogin,motDePasse,userConnect);
            if (erreurs.isEmpty()) {
                resultat = "Succés de l'authentification";
            } else {
                resultat = "Echec de l'authentification. Veuillez réessayer.";
            }
        } catch (DAOException e){
            resultat = "Échec de l'authentification : une erreur imprévue est survenue, merci de réessayer dans quelques instants.";
            e.printStackTrace();
        }
        return userConnected;


    }
    /**
     * Méthodes de traitement
     */

    private void traiterEmail(String email,User user){
        try {
            validationEmail(email);
        } catch (Exception e) {
            setErreur(CHAMP_EMAIL, e.getMessage());
        }
        user.setEmail(email);

    }
    private User traiterUser(String emailOuLogin,String motDePasse , User user){
        User userConnected = new User();
        try {
            userConnected = validationUser(emailOuLogin, motDePasse);
        } catch (Exception e) {
            setErreur(CHAMP_MOT_DE_PASSE, e.getMessage());
        }
        return userConnected;
    }


    /**
     * Méthodes de validation
     */


    private void validationEmail(String email) throws Exception {
        User user = new User();
        user.setEmail(email);
        if (email != null) {
            if (!email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
                throw new Exception("Merci de saisir une adresse mail valide.");
            } }else if ( userDao.findSpecificUser( user ) == null ) {
            throw new Exception( "Cette adresse email n'existe pas . Veuillez entrez une adresse email existante" );
        } else {
            throw new Exception("Merci de saisir une adresse mail.");
        }
    }

    private User validationUser(String emailOuLogin, String motDePasse) throws Exception {
        User user = new User();
        if(emailOuLogin.contains("@")){
            user.setEmail(emailOuLogin);
        } else {
            user.setLogin(emailOuLogin);
        }
        if (motDePasse == null) {
            throw new Exception("Merci de saisir un mot de passe");
        } else {
            User usr = userDao.findSpecificUser(user);
            if(usr.getPassword().equals(motDePasse)){
                return usr;
            } else {
                throw new Exception("Mot de passe ou Email invalide. Merci de réessayer");
            }

        }
    }


    /**
     * Méthoes utiles
     */
    private static String getValeurChamp(HttpServletRequest request, String nomChamp) {
        String valeur = request.getParameter(nomChamp);
        if (valeur == null || valeur.trim().length() == 0) {
            return null;
        } else {
            return valeur;
        }
    }

    private void setErreur(String champ, String message) {
        erreurs.put(champ, message);
    }

}