package com.covoiturage.servlets.inscription;

import com.covoiturage.beans.User;
import com.covoiturage.dao.interfaces.UserDao;
import com.covoiturage.forms.ValidationForm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Validation extends HttpServlet {
    static final String DAO_FACTORY  = "daofactory";
    private UserDao userDao;

    private static final String ATT_SESSION_USERID = "userId";

    private static final String VUE_USER_ACCUEIL = "/WEB-INF/espace/user/espace_user.html";
    private static final String VUE_APRES_INSCRIPTION = "/apres_inscription.jsp";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ValidationForm form = new ValidationForm(userDao);
        User userActivated = form.validate(req);

        if(form.getErreurs().isEmpty()){
            HttpSession session = req.getSession();
            session.setAttribute(ATT_SESSION_USERID,userActivated.getId());
            this.getServletContext().getRequestDispatcher(VUE_USER_ACCUEIL).forward(req,resp);
        } else {
            this.getServletContext().getRequestDispatcher(VUE_APRES_INSCRIPTION).forward(req, resp);
        }
    }
}
