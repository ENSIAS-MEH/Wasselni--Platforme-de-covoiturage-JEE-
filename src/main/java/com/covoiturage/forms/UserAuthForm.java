package com.covoiturage.forms;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class UserAuthForm {
    private static final String CHAMP_MOT_DE_PASSE = "motdepasse";
    private static final String CHAMP_EMAIL = "email";

    private String resultat;
    private Map<String, String> erreurs= new HashMap();

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public String getResultat() {
        return resultat;
    }

    public int authentification(HttpServletRequest req){
        String email = getValeurChamp(req,CHAMP_MOT_DE_PASSE);
        String motDePasse = getValeurChamp(req,CHAMP_EMAIL);

        int userId = -1;
        try {
            validationEmail(email);
        } catch (Exception e) {
            setErreur(CHAMP_EMAIL,e.getMessage());
        }
        try {
            userId = validationUser(email, motDePasse);
        } catch (Exception e) {
            setErreur(CHAMP_MOT_DE_PASSE,e.getMessage());
        }
        if(erreurs.isEmpty()){
            resultat = "Succés de l'authentification";
        } else {
            resultat = "Echec de l'authentification. Veuillez réessayer.";
        }
        return userId;


    }
    private void validationEmail(String email) throws Exception{
        if ( email != null) {
            if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
                throw new Exception( "Merci de saisir une adresse mail valide." );
            } else {
                /**
                 * Recherche de l'email dans la bd
                 */
            }
        } else {
            throw new Exception( "Merci de saisir une adresse mail." );
        }
    }
    private int validationUser(String email,String motDePasse) throws Exception {
        /**
         * Recherche de l'user dans la bd
         */
        return 0;
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
