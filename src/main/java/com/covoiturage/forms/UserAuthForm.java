package com.covoiturage.forms;

import com.covoiturage.beans.User;
<<<<<<< HEAD
import com.covoiturage.dao.interfaces.UserDao;
=======
>>>>>>> 59229b35a36fa11913f41cb5463ad6328b1a8e77

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class UserAuthForm {
<<<<<<< HEAD
    private UserDao userDao;

    public UserAuthForm(UserDao userDao) {
        this.userDao = userDao;
    }

=======
>>>>>>> 59229b35a36fa11913f41cb5463ad6328b1a8e77
    private static final String CHAMP_MOT_DE_PASSE = "motdepasse";
    private static final String CHAMP_EMAIL = "email";

    private String resultat;
<<<<<<< HEAD
    private Map<String, String> erreurs = new HashMap();
=======
    private Map<String, String> erreurs= new HashMap();
>>>>>>> 59229b35a36fa11913f41cb5463ad6328b1a8e77

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public String getResultat() {
        return resultat;
    }

<<<<<<< HEAD
    public User authentification(HttpServletRequest req) {
        String email = getValeurChamp(req, CHAMP_EMAIL);
        String motDePasse = getValeurChamp(req, CHAMP_MOT_DE_PASSE);
=======
    public User authentification(HttpServletRequest req){
        String email = getValeurChamp(req,CHAMP_EMAIL);
        String motDePasse = getValeurChamp(req,CHAMP_MOT_DE_PASSE);
>>>>>>> 59229b35a36fa11913f41cb5463ad6328b1a8e77

        User user = new User();
        long userId = -1;
        user.setId(userId);
        try {
            validationEmail(email);
        } catch (Exception e) {
<<<<<<< HEAD
            setErreur(CHAMP_EMAIL, e.getMessage());
=======
            setErreur(CHAMP_EMAIL,e.getMessage());
>>>>>>> 59229b35a36fa11913f41cb5463ad6328b1a8e77
        }
        user.setEmail(email);
        try {
            userId = validationUser(email, motDePasse);
        } catch (Exception e) {
<<<<<<< HEAD
            setErreur(CHAMP_MOT_DE_PASSE, e.getMessage());
        }
        user.setId(userId);
        if (erreurs.isEmpty()) {
=======
            setErreur(CHAMP_MOT_DE_PASSE,e.getMessage());
        }
        user.setId(userId);
        if(erreurs.isEmpty()){
>>>>>>> 59229b35a36fa11913f41cb5463ad6328b1a8e77
            resultat = "Succés de l'authentification";
        } else {
            resultat = "Echec de l'authentification. Veuillez réessayer.";
        }
        return user;


    }
<<<<<<< HEAD
    /**
     *
     */


    /**
     * Méthodes de validation
     */


    private void validationEmail(String email) throws Exception {
        if (email != null) {
            if (!email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
                throw new Exception("Merci de saisir une adresse mail valide.");
            }
        } else {
            throw new Exception("Merci de saisir une adresse mail.");
        }
    }

    private int validationUser(String email, String motDePasse) throws Exception {
        if (motDePasse == null) {
            throw new Exception("Merci de saisir un mot de passe");
        }

        return 10;
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
=======
    private void validationEmail(String email) throws Exception{
        if ( email != null) {
            if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
                throw new Exception( "Merci de saisir une adresse mail valide." );
            }
        } else {
            throw new Exception( "Merci de saisir une adresse mail." );
        }
    }
    private int validationUser(String email,String motDePasse) throws Exception {
        if(motDePasse == null ){
            throw new Exception("Merci de saisir un mot de passe");
        }


         return 10;
         }


         private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
         String valeur = request.getParameter( nomChamp );
         if ( valeur == null || valeur.trim().length() == 0 ) {
         return null;
         } else {
         return valeur;
         }
         }
         private void setErreur( String champ, String message ) {
         erreurs.put( champ, message );
         }


         }
>>>>>>> 59229b35a36fa11913f41cb5463ad6328b1a8e77
