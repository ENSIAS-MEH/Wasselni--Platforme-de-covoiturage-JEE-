package com.covoiturage.forms;

import com.covoiturage.beans.User;
import com.covoiturage.dao.exceptions.DAOException;
import com.covoiturage.dao.interfaces.UserDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class ValidationForm {

    private UserDao userDao;
    public ValidationForm (UserDao userDao) {
        this.userDao = userDao;
    }

    private static String CHAMP_ACTIVATION = "activation";

    private static final String ATT_SESSION_USER = "userSession";

    private String resultat;
    private Map<String, String> erreurs = new HashMap();

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public String getResultat() {
        return resultat;
    }

    public User validate(HttpServletRequest request){
        User user = new User();
        try{
            HttpSession session = request.getSession();
            String code = getValeurChamp(request,CHAMP_ACTIVATION);
            user = (User) session.getAttribute(ATT_SESSION_USER);
            traiterCode(code,user);

            if (erreurs.isEmpty()) {
                resultat = "Votre compte est activé";
            } else {
                resultat = "Echec de l'activation. Veuillez réessayer.";
            }
        } catch (DAOException e){
            resultat = "Échec de l'activation : une erreur imprévue est survenue, merci de réessayer dans quelques instants.";
            e.printStackTrace();
        }
        return user;




    }
    /**
     * Méthode de traitement
     */

    private void traiterCode(String code , User user){
        try {
            validationCode(code,user);
        } catch (Exception e) {
            setErreur(CHAMP_ACTIVATION, e.getMessage());
        }
    }
    /**
     * Méthodes de validation
     */
    private void validationCode(String code,User user) throws Exception {
        if(code == null){
            throw new Exception("Le code que vous avez entré est vide .Réessayez ");
        } else {
            if((Integer.toString(user.getActivation()).equals(code))){
                user.setActivation(1);
                System.out.println("ssssssssssssssssssssssss"+user.getId());
                userDao.setUserActivation(user);
            } else {
                throw new Exception("Le code que vous avez entré est incorrect.");
            }
        }
    }


    /**
     * Méthodes utiles
     */
    private static String getValeurChamp(HttpServletRequest request, String nomChamp) {
        String valeur = request.getParameter(nomChamp);
        if (valeur == null || valeur.trim().length() == 0) {
            return null;
        } else {
            return valeur;
        }
    }

    private void setErreur(String champ, String message) {
        erreurs.put(champ, message);
    }


}
