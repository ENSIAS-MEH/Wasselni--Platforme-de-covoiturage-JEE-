package com.covoiturage.forms.trajet;

import com.covoiturage.beans.DetailsTrajet;
import com.covoiturage.beans.Trajet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class ProposerTrajetForm {
    private static final String CHAMP_DEPART = "depart";
    private static final String CHAMP_DESTINATION = "destination";
    private static final String CHAMP_DATE_TRAJET = "datetrajet";
    private static final String CHAMP_HEURE_DEPART = "heureDepart";
    private static final String CHAMP_MINUTES_DEPART = "minutesDepart";
    private static final String CHAMP_EFFECTIF = "effectif";
    private static final String CHAMP_PRIX = "prix";
    private static final String CHAMP_BAGAGE_AUTORISE = "bagageautorise";
    private static final String CHAMP_TYPE_VEHICULE = "typevehicule";
    private static final String CHAMP_MARQUE = "marque";
    private static final String CHAMP_MODEL = "model";
    private static final String CHAMP_CLIMATISATION = "climatisation";

    private String resultat;
    private Map<String, String> erreurs= new HashMap();

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public String getResultat() {
        return resultat;
    }

    public Trajet proposerTrajet(HttpServletRequest req){


        String depart = getValeurChamp(req,CHAMP_DEPART);
        String destination = getValeurChamp(req,CHAMP_DESTINATION);
        String dateTrajet = getValeurChamp(req,CHAMP_DATE_TRAJET);
        String heureDepart = getValeurChamp(req,CHAMP_HEURE_DEPART);
        String minutesDepart = getValeurChamp(req,CHAMP_MINUTES_DEPART);
        String effectif = getValeurChamp(req,CHAMP_EFFECTIF);
        String prix = getValeurChamp(req,CHAMP_PRIX);
        String bagageAutorisé = getValeurChamp(req,CHAMP_BAGAGE_AUTORISE);
        String typeVehicule = getValeurChamp(req,CHAMP_TYPE_VEHICULE);
        String marque = getValeurChamp(req,CHAMP_MARQUE);
        String model = getValeurChamp(req,CHAMP_MODEL);
        String climatisation = getValeurChamp(req,CHAMP_CLIMATISATION);

        Trajet trajet = new Trajet();
        DetailsTrajet details = new DetailsTrajet();

        trajet.setQuartierDepart(depart);
        trajet.setQuartierDestination(destination);
        details.setDateDepart(traiterDateTrajet(dateTrajet,heureDepart,minutesDepart));
        details.setEffectif(Integer.parseInt(  effectif.split(" ")[0]));
        details.setPrixPlace(Integer.parseInt(prix.split(" ")[0]));
        details.setTypeVoiture(typeVehicule);
        details.setMarqueVoiture(marque);
        details.setModeleVoiture(model);
        details.setClimatisationVoiture(Integer.parseInt(climatisation));


        HttpSession session = req.getSession();
        session.setAttribute("details",details);

        try{
            validationTrajet(trajet);
        } catch ( Exception e) {
            setErreur(CHAMP_DATE_TRAJET,e.getMessage());
        }
        return trajet;
    }

    private LocalDateTime traiterDateTrajet(String jour, String heure, String minutes){
        String myDate = (((convertStringToLocalDate(jour).toString().concat(" ")).concat(heure)).concat(":")).concat(minutes);
        return convertStringToLocalDateTime(myDate);

    }


    public boolean validationTrajet(Trajet trajet){
        /**
         * retourne si l'user a 2 trajets diff en même temps
         *  ayant idUser et date depart
         */
        return true;
    }

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
    private LocalDateTime convertStringToLocalDateTime(String str){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
        return dateTime;
    }
    private LocalDate convertStringToLocalDate(String str)  {
            if (str != null) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate date = LocalDate.parse(str, formatter);
                return date;
            }
        return null;
    }
}
