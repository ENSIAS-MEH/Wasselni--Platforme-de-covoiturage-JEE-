package com.covoiturage.forms;

import com.covoiturage.beans.DetailsTrajet;
import com.covoiturage.beans.Trajet;
import com.covoiturage.dao.exceptions.DAOException;
import com.covoiturage.dao.interfaces.UserDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class OffreForm {
    private UserDao userDao;

    private static final String CHAMP_DEPART = "depart";
    private static final String CHAMP_DESTINATION = "destination";
    private static final String CHAMP_DATE_TRAJET = "datetrajet";
    private static final String CHAMP_EFFECTIF = "effectif";
    private static final String CHAMP_BAGAGE_AUTORISE = "bagageautorise";

    private String resultat;
    private Map<String, String> erreurs= new HashMap();

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public String getResultat() {
        return resultat;
    }
    public OffreForm(UserDao userDao) {
        this.userDao = userDao;
    }

    public void consulterOffres(HttpServletRequest req){
        Trajet trajet = new Trajet();
        DetailsTrajet details = new DetailsTrajet();

        try{
            String depart = getValeurChamp(req,CHAMP_DEPART);
            String destination = getValeurChamp(req,CHAMP_DESTINATION);
            String dateTrajet = getValeurChamp(req,CHAMP_DATE_TRAJET);
            String effectif = getValeurChamp(req,CHAMP_EFFECTIF);
            String bagageAutorisé = getValeurChamp(req,CHAMP_BAGAGE_AUTORISE);

            trajet.setVilleDepart(depart);
            trajet.setVilleDestination(destination);
            traiterDateTrajet(dateTrajet, details);
            traiterEffectif(effectif, details);
            traiterBagage(bagageAutorisé, details);
            if(erreurs.isEmpty()){
                    /**
                     * rechercher les trajets
                     */
                resultat = "Recherche des offres en succès";
            } else {
                resultat = "Echec de la recherche";
            }
        } catch (DAOException | SQLException e) {
            resultat = "Échec de la recherche du trajet : une erreur imprévue est survenue, merci de réessayer dans quelques instants.";
            e.printStackTrace();
        }
        /*HttpSession session = req.getSession();
        session.setAttribute("depart",depart);
        session.setAttribute( "destination",destination);
        session.setAttribute("dateTrajet",dateTrajet);
        session.setAttribute("effectif", effectif );
        session.setAttribute( "retour",bagageAutorisé);*/
    }
    /**
     * Méthodes de traitement
     */


    private void traiterDateTrajet(String jour , DetailsTrajet details){
        LocalDateTime dateDepart = null;
        try{
            dateDepart = validationDateTrajet(jour);
        } catch (Exception e){
            setErreur(CHAMP_DATE_TRAJET , e.getMessage());
        }
        details.setDateDepart(dateDepart);
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
    public LocalDateTime convertStringToLocalDateTime(String str){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
        return dateTime;
    }
}
