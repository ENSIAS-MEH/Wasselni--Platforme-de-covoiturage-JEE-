package com.covoiturage.forms;

import com.covoiturage.beans.User;

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

    public User authentification(HttpServletRequest req){
        String email = getValeurChamp(req,CHAMP_EMAIL);
        String motDePasse = getValeurChamp(req,CHAMP_MOT_DE_PASSE);

        User user = new User();
        long userId = -1;
        user.setId(userId);
        try {
            validationEmail(email);
        } catch (Exception e) {
            setErreur(CHAMP_EMAIL,e.getMessage());
        }
        user.setEmail(email);
        try {
            userId = validationUser(email, motDePasse);
        } catch (Exception e) {
            setErreur(CHAMP_MOT_DE_PASSE,e.getMessage());
        }
        user.setId(userId);
        if(erreurs.isEmpty()){
            resultat = "Succés de l'authentification";
        } else {
            resultat = "Echec de l'authentification. Veuillez réessayer.";
        }
        return user;


    }
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