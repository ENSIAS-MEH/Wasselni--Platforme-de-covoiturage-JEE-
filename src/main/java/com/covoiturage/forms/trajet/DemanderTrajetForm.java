package com.covoiturage.forms.trajet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class DemanderTrajetForm {
    private static final String CHAMP_DEPART = "depart";
    private static final String CHAMP_DESTINATION = "destination";
    private static final String CHAMP_DATE_TRAJET = "datetrajet";
    private static final String CHAMP_EFFECTIF = "effectif";
    private static final String CHAMP_PRIX = "prix";
    private static final String CHAMP_BAGAGE_AUTORISE = "bagageautorise";

    private String resultat;
    private Map<String, String> erreurs= new HashMap();

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public String getResultat() {
        return resultat;
    }

    public void demanderTrajet(HttpServletRequest req){
        String depart = getValeurChamp(req,CHAMP_DEPART);
        String destination = getValeurChamp(req,CHAMP_DESTINATION);
        String dateTrajet = getValeurChamp(req,CHAMP_DATE_TRAJET);
        String effectif = getValeurChamp(req,CHAMP_EFFECTIF);
        String prix = getValeurChamp(req,CHAMP_PRIX);
        String bagageAutorisé = getValeurChamp(req,CHAMP_BAGAGE_AUTORISE);

        /*HttpSession session = req.getSession();
        session.setAttribute("depart",depart);
        session.setAttribute( "destination",destination);
        session.setAttribute("dateTrajet",dateTrajet);
        session.setAttribute("effectif", effectif );
        session.setAttribute( "prix",prix);
        session.setAttribute( "bagageAutorisé",bagageAutorisé);*/
    }



    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }

    private static String getValeurChamp(HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }
}
