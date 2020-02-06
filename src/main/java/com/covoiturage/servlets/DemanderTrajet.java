package com.covoiturage.servlets;

import com.covoiturage.dao.DAOFactory;
import com.covoiturage.dao.interfaces.UserDao;
import com.covoiturage.forms.trajet.DemanderTrajetForm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class DemanderTrajet extends HttpServlet {
    static final String DAO_FACTORY  = "daofactory";
    private UserDao userDao;

    private static final String VUE_USER_ACCUEIL = "/userAccueil";
    private static final String VUE_AUTHENTIFICATION = "/authentification" ;

    private static final String ATT_SESSION_USERID = "userId";

    private static final String VUE_CREATION = "/WEB-INF/trajet/demandertrajet.jsp";
    private static final String VUE_RESULTAT = "/test.jsp";


    @Override
    public void init() throws ServletException {
        this.userDao = ((DAOFactory) this.getServletContext().getAttribute(DAO_FACTORY)).getUserDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher(VUE_CREATION).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DemanderTrajetForm form = new DemanderTrajetForm(userDao) ;
        form.demanderTrajet(req);
        if(form.getErreurs().isEmpty()){
            HttpSession session = req.getSession();
            if(session.getAttribute(ATT_SESSION_USERID) == null){
                this.getServletContext().getRequestDispatcher(VUE_AUTHENTIFICATION).forward(req,resp);
            }  else {
                resp.sendRedirect(req.getContextPath()+VUE_USER_ACCUEIL);            }
        }else {
            req.getServletContext().getRequestDispatcher(VUE_CREATION).forward(req,resp);
        }

    }
}


