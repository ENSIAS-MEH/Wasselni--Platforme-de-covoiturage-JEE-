package com.covoiturage.forms;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class AbonnementForm {
    private static final String CHAMP_NOM = "nom";
    private static final String CHAMP_EMAIL = "email";

    private String resultat;
    public String getResultat() {
        return resultat;
    }

    public void inscrire(HttpServletRequest req){
        String nom = getValeurChamp(req,CHAMP_NOM);
        String email = getValeurChamp(req,CHAMP_EMAIL);

        /**
         * Ajout dans les abonnés
         */
        resultat = "Vous êtes maintenant abonnés ! Merci pour votre confiance.";
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
