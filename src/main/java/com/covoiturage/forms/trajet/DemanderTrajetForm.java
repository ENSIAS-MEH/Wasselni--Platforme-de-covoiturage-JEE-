package com.covoiturage.forms.trajet;

import com.covoiturage.beans.DetailsTrajet;
import com.covoiturage.beans.EstAssociea;
import com.covoiturage.beans.Trajet;
import com.covoiturage.dao.exceptions.DAOException;
import com.covoiturage.dao.interfaces.DetailsTrajetDao;
import com.covoiturage.dao.interfaces.EstAssocieADao;
import com.covoiturage.dao.interfaces.TrajetDao;
import com.covoiturage.dao.interfaces.UserDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class DemanderTrajetForm {
    private TrajetDao trajetDao;
    private DetailsTrajetDao detailsTrajetDao;
    private EstAssocieADao estAssocieADao;

    private static final String CHAMP_DEPART = "depart";
    private static final String CHAMP_DESTINATION = "destination";
    private static final String CHAMP_DATE_TRAJET = "datetrajet";
    private static final String CHAMP_EFFECTIF = "effectif";
    private static final String CHAMP_PRIX = "prix";
    private static final String CHAMP_BAGAGE_AUTORISE = "bagageautorise";

    private static final String ATT_TRAJET = "trajet";
    private static final String ATT_DETAILS = "details";
    private static final String ATT_ASSOC = "associe";

    public DemanderTrajetForm(TrajetDao trajetDao, DetailsTrajetDao detailsTrajetDao, EstAssocieADao estAssocieADao) {
        this.trajetDao = trajetDao;
        this.detailsTrajetDao = detailsTrajetDao;
        this.estAssocieADao = estAssocieADao;
    }

    private static final String ATT_SESSION_USERID = "userId";


    private String resultat;
    private Map<String, String> erreurs= new HashMap();

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public String getResultat() {
        return resultat;
    }

    public void demanderTrajet(HttpServletRequest req) {
        Trajet trajet = new Trajet();
        DetailsTrajet details = new DetailsTrajet();
        try {
            String depart = getValeurChamp(req, CHAMP_DEPART);
            String destination = getValeurChamp(req, CHAMP_DESTINATION);
            String dateTrajet = getValeurChamp(req, CHAMP_DATE_TRAJET);
            String effectif = getValeurChamp(req, CHAMP_EFFECTIF);
            String prix = getValeurChamp(req, CHAMP_PRIX);
            String bagageAutorisé = getValeurChamp(req, CHAMP_BAGAGE_AUTORISE);

            trajet.setVilleDepart(depart);
            trajet.setVilleDestination(destination);

            traiterDateTrajet(dateTrajet, details);
            traiterEffectif(effectif, details);
            traiterPrix(prix, details);
            traiterBagage(bagageAutorisé, details);
            traiterTrajet(details, trajet);
            /*HttpSession session = req.getSession();
            session.setAttribute("depart",depart);
            session.setAttribute( "destination",destination);
            session.setAttribute("dateTrajet",dateTrajet);
            session.setAttribute("effectif", effectif );
            session.setAttribute( "prix",prix);
            session.setAttribute( "bagageAutorisé",bagageAutorisé);*/

            if(erreurs.isEmpty()){
                EstAssociea associeA = new EstAssociea();
                associeA.setDateAssociation(LocalDateTime.now());
                associeA.setTypeAssociation("DEMANDER");
                HttpSession session = req.getSession();
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
                resultat = "Trajet demandé avec succès";
            } else {
                resultat = "Echec de la demande";
            }
        } catch (DAOException | SQLException e) {
            resultat = "Échec de la demande du trajet : une erreur imprévue est survenue, merci de réessayer dans quelques instants.";
            e.printStackTrace();
        }
    }

    /**
     * Méthodes de traitement
     */
    private void traiterTrajet(DetailsTrajet details,Trajet trajet) {
        try {
           // validationTrajet(trajet, details);
        } catch (Exception e) {
            setErreur(ATT_TRAJET, e.getMessage());
        }
    }

    private void traiterDateTrajet(String jour , DetailsTrajet details){
        LocalDateTime dateDepart = null;
        try{
            dateDepart = validationDateTrajet(jour);
        } catch (Exception e){
            setErreur(CHAMP_DATE_TRAJET , e.getMessage());
        }
        details.setDateDepart(dateDepart);
    }

    private void traiterPrix(String prix , DetailsTrajet details){
        details.setPrixPlace(Integer.parseInt(prix.split(" ")[0]));
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

    private LocalDateTime validationDateTrajet(String jour) throws Exception {
        if(jour != null){
            return convertStringToLocalDateTime(jour);
        } else {
            throw new Exception("Un champ de la date est vide. Veuillez le renseigner.");
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
    public LocalDateTime convertStringToLocalDateTime(String str){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
        return dateTime;
    }
}
