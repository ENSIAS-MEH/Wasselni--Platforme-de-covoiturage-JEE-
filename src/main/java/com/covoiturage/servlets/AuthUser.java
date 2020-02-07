package com.covoiturage.servlets;

import com.covoiturage.beans.User;
import com.covoiturage.dao.DAOFactory;
import com.covoiturage.dao.interfaces.UserDao;
import com.covoiturage.forms.UserAuthForm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthUser extends HttpServlet {
    static final String DAO_FACTORY  = "daofactory";
    private UserDao userDao;

    private static final String ATT_SESSION_USER = "userSession";
    private static final String ATT_SESSION_USERID = "userId";

    private static final String ATT_FORM = "form";
    private static final String ATT_TRAJET = "trajet";
    private static final String ATT_DETAILS = "details";

    private static final String VUE_AUTHENTIFICATION = "/WEB-INF/authentification.jsp";
    private static final String VUE_USER_ACCUEIL = "/userAccueil";


    @Override
    public void init() throws ServletException {
        this.userDao = ((DAOFactory) this.getServletContext().getAttribute(DAO_FACTORY)).getUserDao();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher(VUE_AUTHENTIFICATION).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserAuthForm form = new UserAuthForm(userDao);
        User user = form.authentification(req);

        req.setAttribute(ATT_FORM,form);

        if(form.getErreurs().isEmpty()){
            HttpSession session = req.getSession();
            session.setAttribute(ATT_SESSION_USERID,user.getId());
            session.setAttribute(ATT_SESSION_USER,user);
            if(req.getAttribute(ATT_TRAJET) != null && req.getAttribute(ATT_DETAILS) != null){
                /**
                 * Ajout de la proposition / demande
                 */
            }
            resp.sendRedirect(VUE_USER_ACCUEIL);
        } else {
            this.getServletContext().getRequestDispatcher(VUE_AUTHENTIFICATION).forward(req, resp);
        }
    }
}

