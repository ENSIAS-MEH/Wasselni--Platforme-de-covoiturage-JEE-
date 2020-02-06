package com.covoiturage.forms;

import com.covoiturage.beans.User;
import com.covoiturage.dao.exceptions.DAOException;
import com.covoiturage.dao.interfaces.UserDao;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class AbonnementForm {
    private UserDao userDao;
    private static final String CHAMP_NOM = "nom";
    private static final String CHAMP_EMAIL = "email";

    private Map<String, String> erreurs= new HashMap();
    public Map<String, String> getErreurs() {
        return erreurs;
    }
    private String resultat;
    public String getResultat() {
        return resultat;
    }

    public AbonnementForm(UserDao userDao){ this.userDao = userDao;}

    public void inscrire(HttpServletRequest req){
        /**
         * New abonné
         */
        try{
            String nom = getValeurChamp(req,CHAMP_NOM);
            String email = getValeurChamp(req,CHAMP_EMAIL);

            traiterNom(nom,);
            traiterEmail(email,);
            if(erreurs.isEmpty()){
                /**
                 * Ajout abonné
                 */
                resultat = "Vous êtes bien notre abonné. Merci pour votre confiance!";
            } else {
                resultat = "Echec de l'abonnement";
            }
        } catch (DAOException | SQLException e){
            resultat = "Échec de l'abonnement : une erreur imprévue est survenue, merci de réessayer dans quelques instants.";
            e.printStackTrace();
        }

    }
    /**
     * Méthodes de traitement
     */
    private void traiterNom(String nom, User user){
        try {
            validationNom( nom );
        } catch ( Exception e ) {
            setErreur( CHAMP_NOM, e.getMessage() );
        }
        user.setNom( nom );
    }
    private void traiterEmail(String email,User user){
        try {
            validationEmail( email );
        } catch ( Exception e ) {
            setErreur( CHAMP_EMAIL, e.getMessage() );
        }
        user.setEmail(email);
    }

    /**
     * Méthodes de validation
     */

    private void validationNom( String nom ) throws Exception {
        if ( nom == null ) {
            throw new Exception( "Merci d'entrer un nom." );
        }
    }
    private void validationEmail(String email) throws Exception{
        /**
         *
         * Abonné instead of user , find in abonné and user
         */
        User user = new User();
        user.setEmail(email);
        if ( email != null) {
            if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
                throw new Exception( "Merci de saisir une adresse mail valide." );
            }else if ( userDao.findSpecificAbonné( user ) != null ) {
                throw new Exception( "Cette adresse email est déjà abonné." );
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
