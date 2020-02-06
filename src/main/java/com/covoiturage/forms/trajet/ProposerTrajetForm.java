package com.covoiturage.forms.trajet;

import com.covoiturage.beans.DetailsTrajet;
import com.covoiturage.beans.EstAssociea;
import com.covoiturage.beans.Trajet;
import com.covoiturage.dao.exceptions.DAOException;
import com.covoiturage.dao.interfaces.DetailsTrajetDao;
import com.covoiturage.dao.interfaces.EstAssocieADao;
import com.covoiturage.dao.interfaces.TrajetDao;
import com.covoiturage.dao.interfaces.UserDao;
import org.apache.tomcat.jni.Local;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class ProposerTrajetForm {
    private TrajetDao trajetDao;
    private DetailsTrajetDao detailsTrajetDao;
    private EstAssocieADao estAssocieADao;

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

    private static final String ATT_TRAJET = "trajet";
    private static final String ATT_DETAILS = "details";
    private static final String ATT_ASSOC = "associe";

    private static final String ATT_SESSION_USERID = "userId";

    public ProposerTrajetForm(TrajetDao trajetDao, DetailsTrajetDao detailsTrajetDao, EstAssocieADao estAssocieADao) {
        this.trajetDao = trajetDao;
        this.detailsTrajetDao = detailsTrajetDao;
        this.estAssocieADao = estAssocieADao;
    }

    private String resultat;
    private Map<String, String> erreurs= new HashMap();

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public String getResultat() {
        return resultat;
    }

    public void proposerTrajet(HttpServletRequest req){
        Trajet trajet = new Trajet();
        DetailsTrajet details = new DetailsTrajet();
        try{

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


            trajet.setVilleDepart(depart);
            trajet.setVilleDestination(destination);
            details.setTypeVoiture(typeVehicule);
            details.setMarqueVoiture(marque);
            details.setModeleVoiture(model);

            traiterDateTrajet(dateTrajet,heureDepart,minutesDepart,details);
            traiterClimatisation(climatisation,details);
            traiterEffectif(effectif,details);
            traiterPrix(prix,details);
            traiterBagage(bagageAutorisé,details);
            traiterTrajet(details,trajet);

            //HttpSession session = req.getSession();
            //session.setAttribute("details",details);

            if(erreurs.isEmpty()){
                HttpSession session = req.getSession();
                EstAssociea associeA = new EstAssociea();
                associeA.setDateAssociation(LocalDateTime.now());
                associeA.setTypeAssociation("PROPOSER");
                if(session.getAttribute(ATT_SESSION_USERID) == null){
                    req.setAttribute(ATT_DETAILS,details);
                    req.setAttribute(ATT_TRAJET,trajet);
                    req.setAttribute(ATT_ASSOC,associeA);
                } else {
                    Long trajetId = trajetDao.insertTrajet(trajet);

                    details.setIdTrajetChoisie(trajetId);
                    Long detailsTrajetId = detailsTrajetDao.insertDetailsTrajet(details);

                    associeA.setIdUser(Long.parseLong(""+session.getAttribute(ATT_SESSION_USERID)));
                    associeA.setIdDetailsTrajet(detailsTrajetId);
                    estAssocieADao.insertEstAssocieA(associeA);
                }
                resultat = "Trajet proposé avec succès";
            } else {
                resultat = "Echec de la proposition";
            }

        } catch (DAOException | SQLException e){
            resultat = "Échec de la proposition du trajet : une erreur imprévue est survenue, merci de réessayer dans quelques instants.";
            e.printStackTrace();
        }

    }


    /**
     * Méthodes de traitement
     */
    private void traiterTrajet(DetailsTrajet details,Trajet trajet) {
        try {
            //validationTrajet(trajet, details);
        } catch (Exception e) {
            setErreur(ATT_TRAJET, e.getMessage());
        }
    }

    private void traiterDateTrajet(String jour, String heure, String minutes , DetailsTrajet details){
        LocalDateTime dateDepart = null;
        try{
            dateDepart = validationDateTrajet(jour,heure,minutes);
        } catch (Exception e){
            setErreur(CHAMP_DATE_TRAJET , e.getMessage());
        }
        details.setDateDepart(dateDepart);
    }

    private void traiterPrix(String prix , DetailsTrajet details){
        details.setPrixPlace(Integer.parseInt(prix.split(" ")[0]));
    }
    private void traiterClimatisation(String climatisation , DetailsTrajet details){
        if(climatisation != null){
            details.setClimatisationVoiture(1);
        } else {
            details.setClimatisationVoiture(0);
        }
    }
    private void traiterBagage(String bagage , DetailsTrajet details){
        if(bagage != null){
            details.setBagage(1);
        } else {
            details.setBagage(0);
        }
    }
    private void traiterEffectif(String effectif, DetailsTrajet details){
        details.setEffectif(Integer.parseInt(  effectif.split(" ")[0]));
    }

    /**
     * Méthodes de validation
     */

    private LocalDateTime validationDateTrajet(String jour, String heure, String minutes) throws Exception {
            String myDate = (((convertStringToLocalDate(jour).toString().concat(" ")).concat(heure)).concat(":")).concat(minutes);
            return convertStringToLocalDateTime(myDate);
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
    public LocalDateTime convertStringToLocalDateTime(String str){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
        return dateTime;
    }
    public LocalDate convertStringToLocalDate(String str)  {
            if (str != null) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                LocalDate date = LocalDate.parse(str, formatter);
                return date;
            }
        return null;
    }
}
