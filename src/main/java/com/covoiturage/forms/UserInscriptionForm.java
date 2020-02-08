package com.covoiturage.forms;

import com.covoiturage.beans.User;
import com.covoiturage.dao.exceptions.DAOException;
import com.covoiturage.dao.interfaces.UserDao;
import com.covoiturage.mailer.Mailer;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

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
    private static final String CHAMP_QUESTION = "question";
    private static final String CHAMP_REPONSE = "reponse";
    private static final String CHAMP_ACCEPTE_TERMES = "accepte";

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
        try {
            String nom = getValeurChamp(req, CHAMP_NOM);
            String prenom = getValeurChamp(req, CHAMP_PRENOM);
            String sexe = getValeurChamp(req, CHAMP_SEXE);
            String dateNaissance = getValeurChamp(req, CHAMP_DATE_NAISSANCE);
            String region = getValeurChamp(req, CHAMP_REGION);
            String pseudo = getValeurChamp(req, CHAMP_PSEUDO);
            String email = getValeurChamp(req, CHAMP_EMAIL);
            String motDePasse = getValeurChamp(req, CHAMP_MOT_DE_PASSE);
            String confirmation = getValeurChamp(req, CHAMP_CONFIRMATION_MOT_DE_PASSE);
            String question = getValeurChamp(req, CHAMP_QUESTION);
            String reponse = getValeurChamp(req, CHAMP_REPONSE);
            String accepteTermes = getValeurChamp(req, CHAMP_ACCEPTE_TERMES);

            user.setSexe(sexe);
            user.setDateInscription(LocalDateTime.now());
            user.setRegion(region);
            user.setImage("0_image.jpg");
            traiterNom(nom, user);
            traiterPrenom(prenom, user);
            traiterDateNaissance(dateNaissance, user);
            traiterLogin(pseudo, user);
            traiterEmail(email, user);
            traiterMotDePasse(motDePasse, confirmation, user);
            traiterReponse(question, reponse, user);
            traiterAccepter(accepteTermes);

            if (erreurs.isEmpty()) {
                traiterActivation(user);
                user.setId(userDao.insertUser(user));
                resultat = "Succés de l'inscription";
            } else {
                resultat = "Echec de l'inscription";
            }
        } catch (SQLException sql) {
            resultat = "Échec de l'inscription : une erreur imprévue est survenue, merci de réessayer dans quelques instants.";
            sql.printStackTrace();
        }
        return user;
    }

    /**
     * Méthodes de traitement
     */

    private void traiterAccepter(String accepteTermes){
        try {
            if (accepteTermes == null) {
                throw new Exception("Vous devez obligatoirement accepter les termes et les conditions pour continuer.");
            }
        } catch (Exception e) {
            setErreur(CHAMP_ACCEPTE_TERMES, e.getMessage());
        }
    }
    private void traiterReponse(String question,String reponse,User user){
        try {
            validationReponse(reponse);
        } catch (Exception e) {
            setErreur( CHAMP_REPONSE, e.getMessage() );
        }
        user.setId_question(Integer.parseInt(question));
        user.setReponse(reponse);
    }

    private void traiterNom(String nom,User user){
        try {
            validationNom( nom );
        } catch ( Exception e ) {
            setErreur( CHAMP_NOM, e.getMessage() );
        }
        user.setNom( nom );
    }
    private void traiterPrenom(String prenom,User user){
        try {
            validationPrenom( prenom );
        } catch ( Exception e ) {
            setErreur( CHAMP_PRENOM, e.getMessage() );
        }
        user.setPrenom( prenom );
    }
    private void traiterDateNaissance(String dateNaissance,User user){
        try {
            validationDateNaissance( dateNaissance );
        } catch ( Exception e ) {
            setErreur( CHAMP_DATE_NAISSANCE, e.getMessage() );
        }
        user.setDateNaissance(convertStringToLocalDate(dateNaissance));
    }
    private void traiterLogin(String pseudo,User user){
        try {
            validationPseudo( pseudo );
        } catch ( Exception e ) {
            setErreur( CHAMP_PSEUDO, e.getMessage() );
        }
        user.setLogin(pseudo);
    }
    private void traiterEmail(String email,User user){
        try {
            validationEmail( email );
        } catch ( Exception e ) {
            setErreur( CHAMP_EMAIL, e.getMessage() );
        }
        user.setEmail(email);
    }
    private void traiterMotDePasse(String motDePasse , String confirmation,User user){
        try {
            validationMotDePasse( motDePasse , confirmation );
        } catch ( Exception e ) {
            setErreur( CHAMP_MOT_DE_PASSE, e.getMessage() );
        }
        user.setPassword(motDePasse);
    }

    private void traiterActivation(User user)  {
        ArrayList list = new ArrayList<String>();
        list.add(user.getEmail());
        int codeValidation =((int) ((Math.random()+1)*10000));
        String body = "Bonjour "+user.getNom()+", Bienvenue à notre application de covoiturage et merci pour votre confiance ! <br> Veuillez entrez le code suivant dans la page Après Inscription pour valider votre compte : "+ codeValidation;
        try {
            Mailer.sendEmail(list,"Activation",body);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        user.setActivation(codeValidation);
    }

    /**
     * Méthodes de validation
     */

    private void validationReponse( String reponse ) throws Exception {
        if( reponse == null) {
            throw new Exception("La réponse ne doit pas être vide. Choisissez une question et la reponse correspondante");
        }
    }

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
        User user = new User();
        user.setLogin(pseudo);
        if ( pseudo != null && pseudo.length() < 5 ) {
            throw new Exception( "Le pseudo d'utilisateur doit contenir au moins 5 caractères." );
        } else if ( userDao.findSpecificUser( user ) != null ) {
            throw new Exception( "Ce login est déjà utilisée, merci d'en choisir un autre." );
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
        User user = new User();
        user.setEmail(email);
        if ( email != null) {
            if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
                throw new Exception( "Merci de saisir une adresse mail valide." );
            }else if ( userDao.findSpecificUser( user ) != null ) {
                throw new Exception( "Cette adresse email est déjà utilisée, merci d'en choisir une autre." );
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
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                LocalDate date = LocalDate.parse(str, formatter);
                return date;
            }
        } catch ( DateTimeParseException d) {
            setErreur(CHAMP_DATE_NAISSANCE,"Le format de la date n'est pas adéquat");
        }
        return null;
    }
    public static String leftPad(int n, int padding) {
        return String.format("%0" + padding + "d", n);
    }

}

