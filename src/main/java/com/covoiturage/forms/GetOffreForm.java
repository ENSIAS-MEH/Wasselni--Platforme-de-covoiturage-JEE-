package com.covoiturage.forms;

import com.covoiturage.beans.DetailsTrajet;
import com.covoiturage.beans.EstAssociea;
import com.covoiturage.beans.Trajet;
import com.covoiturage.dao.exceptions.DAOException;
import com.covoiturage.dao.interfaces.DetailsTrajetDao;
import com.covoiturage.dao.interfaces.EstAssocieADao;
import com.covoiturage.dao.interfaces.TrajetDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GetOffreForm {
    private TrajetDao trajetDao;
    private DetailsTrajetDao detailsTrajetDao;

    private static final String CHAMP_DEPART = "depart";
    private static final String CHAMP_DESTINATION = "destination";
    private static final String CHAMP_DATE_TRAJET = "datetrajet";
    private static final String CHAMP_PRIX = "prix";


    private static final String ATT_OFFRES = "offres";
    private static final String ATT_DETAILS_OFFRES  = "detailsOffres";

    private static final String NO_OFFRES = "nooffres";

    public GetOffreForm(TrajetDao trajetDao, DetailsTrajetDao detailsTrajetDao) {
        this.trajetDao = trajetDao;
        this.detailsTrajetDao = detailsTrajetDao;
    }

    private String resultat;
    private Map<String, String> erreurs= new HashMap();

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public String getResultat() {
        return resultat;
    }

    public void getOffre(HttpServletRequest req){
        Trajet trajet = new Trajet();
        DetailsTrajet details = new DetailsTrajet();
        ArrayList<Trajet> offres = null;
        try{

            String depart = getValeurChamp(req,CHAMP_DEPART);
            String destination = getValeurChamp(req,CHAMP_DESTINATION);
            String dateTrajet = getValeurChamp(req,CHAMP_DATE_TRAJET);
            String prix = getValeurChamp(req,CHAMP_PRIX);
            int prixMin = Integer.parseInt(prix.split(",")[0]);
            int prixMax = Integer.parseInt(prix.split(",")[1]);

            traiterVilleDepart(depart,trajet);
            traiterVilleDestination(destination,trajet);
            traiterDateTrajet(dateTrajet,details);
            //HttpSession session = req.getSession();
            //session.setAttribute("details",details);

            if(erreurs.isEmpty()){
                ArrayList<DetailsTrajet> detailsOffres = new ArrayList<>();
                offres = (ArrayList<Trajet>) trajetDao.findAllTrajets(trajet,details,prixMin,prixMax);
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
                resultat = "Filtrage avec succès";
            } else {
                resultat = "Echec du filtrage";
            }

        } catch (DAOException | SQLException e){
            resultat = "Échec du filtrage: une erreur imprévue est survenue, merci de réessayer dans quelques instants.";
            e.printStackTrace();
        }

    }


    /**
     * Méthodes de traitement
     */

    private void traiterVilleDepart(String depart,Trajet trajet){
    try{
        if(depart == null){
            throw new Exception("Le champ du ville de départ est vide.");
        } else {
            trajet.setVilleDepart(depart);
        }
    } catch (Exception e){
        setErreur(CHAMP_DEPART,e.getMessage());
    }
    }

    private void traiterVilleDestination(String dest,Trajet trajet){
        try{
            if(dest == null){
                throw new Exception("Le champ du ville de départ est vide.");
            } else {
                trajet.setVilleDestination(dest);
            }
        } catch (Exception e){
            setErreur(CHAMP_DESTINATION,e.getMessage());
        }
    }


    private void traiterDateTrajet(String jour, DetailsTrajet details)  {
        try{
            if(jour == null ){
            throw new Exception("Veuillez renseigner le champ de la date");
        } else{
            details.setDateDepart(convertStringToLocalDateTime((((convertStringToLocalDate(jour).toString().concat(" ")).concat("00")).concat(":")).concat("00")));
        }
        } catch(Exception e){
            setErreur(CHAMP_DATE_TRAJET,e.getMessage());
    }

    }


    /**
     * Méthodes de validation
     */


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

