package com.covoiturage.forms;

import com.covoiturage.beans.User;
import com.covoiturage.dao.exceptions.DAOException;
import com.covoiturage.dao.interfaces.UserDao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class UserInscriptionForm {
    private UserDao userDao;

    public UserInscriptionForm(UserDao userDao) {
        this.userDao = userDao;
    }

    private static final String CHAMP_NOM       = "nom";
    private static final String CHAMP_PRENOM    = "prenom";
    private static final String CHAMP_SEXE   = "sexe";
    private static final String CHAMP_DATE_NAISSANCE = "datenaissance";
    private static final String CHAMP_REGION     = "region";
    private static final String CHAMP_PSEUDO = "pseudo";
    private static final String CHAMP_EMAIL = "email";
    private static final String CHAMP_MOT_DE_PASSE     = "motdepasse";
    private static final String CHAMP_CONFIRMATION_MOT_DE_PASSE = "confirmationmotdepasse";

    private String resultat;
    private Map<String, String> erreurs= new HashMap();

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public String getResultat() {
        return resultat;
    }

    public User inscrireUser(HttpServletRequest req){
        User user = new User();
        try{
            String nom = getValeurChamp(req,CHAMP_NOM);
            String prenom = getValeurChamp(req,CHAMP_PRENOM);
            String sexe = getValeurChamp(req,CHAMP_SEXE);
            String dateNaissance = getValeurChamp(req,CHAMP_DATE_NAISSANCE);
            String region = getValeurChamp(req,CHAMP_REGION);
            String pseudo = getValeurChamp(req,CHAMP_PSEUDO);
            String email = getValeurChamp(req,CHAMP_EMAIL);
            String motDePasse = getValeurChamp(req,CHAMP_MOT_DE_PASSE);
            String confirmation = getValeurChamp(req,CHAMP_CONFIRMATION_MOT_DE_PASSE);

            user.setSexe(sexe);
            user.setDateInscription(LocalDateTime.now());
            user.setRegion(region);
            traiterNom(nom,user);
            traiterPrenom(prenom,user);
            traiterDateNaissance(dateNaissance,user);
            traiterLogin(pseudo,user);
            traiterEmail(email,user);
            traiterMotDePasse(motDePasse,confirmation,user);

            if(erreurs.isEmpty()){
                userDao.insertUser(user) ;
                resultat = "Succés de l'inscription";
            } else {
                resultat = "Echec de l'inscription";
            }
        } catch (DAOException | SQLException e){
            resultat = "Échec de l'inscription : une erreur imprévue est survenue, merci de réessayer dans quelques instants.";
            e.printStackTrace();
        }
        return user;
    }

    /**
     * Méthodes de traitement
     */


    public void traiterNom(String nom,User user){
        try {
            validationNom( nom );
        } catch ( Exception e ) {
            setErreur( CHAMP_NOM, e.getMessage() );
        }
        user.setNom( nom );
    }
    public void traiterPrenom(String prenom,User user){
        try {
            validationPrenom( prenom );
        } catch ( Exception e ) {
            setErreur( CHAMP_PRENOM, e.getMessage() );
        }
        user.setPrenom( prenom );
    }
    public void traiterDateNaissance(String dateNaissance,User user){
        try {
            validationDateNaissance( dateNaissance );
        } catch ( Exception e ) {
            setErreur( CHAMP_DATE_NAISSANCE, e.getMessage() );
        }
        user.setDateNaissance(convertStringToLocalDate(dateNaissance));
    }
    public void traiterLogin(String pseudo,User user){
        try {
            validationPseudo( pseudo );
        } catch ( Exception e ) {
            setErreur( CHAMP_PSEUDO, e.getMessage() );
        }
        user.setLogin(pseudo);
    }
    public void traiterEmail(String email,User user){
        try {
            validationEmail( email );
        } catch ( Exception e ) {
            setErreur( CHAMP_EMAIL, e.getMessage() );
        }
        user.setEmail(email);
    }
    public void traiterMotDePasse(String motDePasse , String confirmation,User user){
        try {
            validationMotDePasse( motDePasse , confirmation );
        } catch ( Exception e ) {
            setErreur( CHAMP_MOT_DE_PASSE, e.getMessage() );
        }
        user.setPassword(motDePasse);
    }

    /**
     * Méthodes de validation
     */


    private void validationNom( String nom ) throws Exception {
        if ( nom != null ) {
            if ( nom.length() < 2 ) {
                throw new Exception( "Le nom d'utilisateur doit contenir au moins 2 caractères." );
            }
        } else {
            throw new Exception( "Merci d'entrer un nom d'utilisateur." );
        }
    }

    private void validationPrenom( String prenom ) throws Exception {
        if ( prenom != null && prenom.length() < 2 ) {
            throw new Exception( "Le prénom d'utilisateur doit contenir au moins 2 caractères." );
        }
        if (prenom == null) {
            throw new Exception( "Merci de saisir une prénom d'utilisateur valide." );
        }
    }
    private void validationPseudo( String pseudo ) throws Exception {
        if ( pseudo != null && pseudo.length() < 5 ) {
            throw new Exception( "Le pseudo d'utilisateur doit contenir au moins 5 caractères." );
        }
        if(pseudo == null) {
            throw new Exception( "Merci de saisir un pseudo d'utilisateur valide." );
        }
    }

    private void validationMotDePasse(String motDePasse,String confirmation) throws Exception{
        if (motDePasse != null && confirmation != null) {
            if (!motDePasse.equals(confirmation)) {
                throw new Exception("Les mots de passe entrés sont différents, merci de les saisir à nouveau.");
            } else if (motDePasse.trim().length() < 3) {
                throw new Exception("Les mots de passe doivent contenir au moins 3 caractères.");
            }
        } else {
            throw new Exception("Merci de saisir et confirmer votre mot de passe.");
        }
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
    private void validationDateNaissance(String date) throws Exception {
        if(date == null){
            throw new Exception("Merci de choisir une date de naissance ");
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
    private LocalDateTime convertStringToLocalDateTime(String str){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
        return dateTime;
    }
    private LocalDate convertStringToLocalDate(String str) throws DateTimeParseException{
        try {
            if (str != null) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
                LocalDate date = LocalDate.parse(str, formatter);
                return date;
            }
        } catch ( DateTimeParseException d) {
            setErreur(CHAMP_DATE_NAISSANCE,"Le format de la date n'est pas adéquat");
        }
        return null;
    }

}

