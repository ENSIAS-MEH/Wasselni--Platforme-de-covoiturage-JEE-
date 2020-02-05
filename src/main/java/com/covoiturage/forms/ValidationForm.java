package com.covoiturage.forms;

import com.covoiturage.beans.User;
import com.covoiturage.dao.interfaces.UserDao;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class ValidationForm {
    private UserDao userDao;
    public ValidationForm (UserDao userDao) {
        this.userDao = userDao;
    }

    private static String CHAMP_ACTIVATION = "activation";

    private String resultat;
    private Map<String, String> erreurs = new HashMap();

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public String getResultat() {
        return resultat;
    }

    public int validation(HttpServletRequest request){
        String validation = getValeurChamp(request,CHAMP_ACTIVATION);
        User user = new User();

    }
    /**
     * Méthoes utiles
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
