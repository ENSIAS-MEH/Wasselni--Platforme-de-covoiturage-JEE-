package com.covoiturage.forms;

import com.covoiturage.dao.interfaces.UserDao;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
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

        String nom = getValeurChamp(req,CHAMP_NOM);
        String email = getValeurChamp(req,CHAMP_EMAIL);

        /**
         * Ajout dans les abonnés
         */
        resultat = "Vous êtes maintenant abonnés ! Merci pour votre confiance.";
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
