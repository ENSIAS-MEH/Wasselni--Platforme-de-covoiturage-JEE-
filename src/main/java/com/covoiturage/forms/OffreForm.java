package com.covoiturage.forms;

import com.covoiturage.beans.DetailsTrajet;
import com.covoiturage.beans.Trajet;
import com.covoiturage.dao.exceptions.DAOException;
import com.covoiturage.dao.interfaces.DetailsTrajetDao;
import com.covoiturage.dao.interfaces.TrajetDao;
import com.covoiturage.dao.interfaces.UserDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OffreForm {
    private TrajetDao trajetDao;
    private DetailsTrajetDao detailsTrajetDao;

    private static final String CHAMP_DEPART = "depart";
    private static final String CHAMP_DESTINATION = "destination";
    private static final String CHAMP_DATE_TRAJET = "datetrajet";
    private static final String CHAMP_EFFECTIF = "effectif";
    private static final String CHAMP_BAGAGE_AUTORISE = "bagageautorise";

    private static final String ATT_OFFRES = "offres";
    private static final String ATT_DETAILS_OFFRES  = "detailsOffres";

    private static final String NO_OFFRES = "nooffres";
    private String resultat;
    private Map<String, String> erreurs= new HashMap();

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public String getResultat() {
        return resultat;
    }

    public OffreForm(TrajetDao trajetDao, DetailsTrajetDao detailsTrajetDao) {
        this.trajetDao = trajetDao;
        this.detailsTrajetDao = detailsTrajetDao;
    }

    public ArrayList consulterOffres(HttpServletRequest req){
        Trajet trajet = new Trajet();
        DetailsTrajet details = new DetailsTrajet();
        ArrayList<Trajet> offres = null;
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
                ArrayList<DetailsTrajet> detailsOffres = new ArrayList<>();
                offres = (ArrayList<Trajet>) trajetDao.findAllTrajets(trajet,details);
                DetailsTrajet detailsOffre = new DetailsTrajet();
                for(Trajet offre : offres){
                    detailsOffre.setIdTrajetChoisie(offre.getIdTrajet());
                    detailsOffre = detailsTrajetDao.findSpecificDetailsTrajet(detailsOffre);
                    detailsOffres.add(detailsOffre);
                }
                req.setAttribute(ATT_OFFRES , offres);
                req.setAttribute(ATT_DETAILS_OFFRES , detailsOffres);
                if(offres.size() == 0 ){
                    req.setAttribute(NO_OFFRES,"il n'existe pas d'offres avec de tels paramètres.");
                }
                resultat = "Recherche des offres en succès";
            } else {
                resultat = "Echec de la recherche";
            }
        } catch (DAOException | SQLException e) {
            resultat = "Échec de la recherche du trajet : une erreur imprévue est survenue, merci de réessayer dans quelques instants.";
            e.printStackTrace();
        }
        return offres;
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
        LocalDate dateDepart = null;
        try{
            dateDepart = validationDateTrajet(jour);
        } catch (Exception e){
            setErreur(CHAMP_DATE_TRAJET , e.getMessage());
        }
        details.setDateDepart(dateDepart.atStartOfDay());
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

    private LocalDate validationDateTrajet(String jour) throws Exception {
        return convertStringToLocalDate(jour);

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

    public LocalDate convertStringToLocalDate(String str)  {
        if (str != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            LocalDate date = LocalDate.parse(str, formatter);
            return date;
        }
        return null;
    }
}
