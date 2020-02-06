package com.covoiturage.servlets;

import com.covoiturage.beans.Trajet;
import com.covoiturage.forms.trajet.ProposerTrajetForm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ProposerTrajet extends HttpServlet {
    private static final String VUE_CREATION = "/WEB-INF/trajet/proposertrajet.jsp";
    private static final String VUE_USER_ACCUEIL = "/userAccueil";
    private static final String VUE_AUTHENTIFICATION = "/authentification" ;

    private static final String ATT_SESSION_USERID = "userId";
    /*
     * Page resultat apres avoir proposé un trajet à implémenter
     */
    private static final String VUE_RESULTAT = "/test.jsp";
    private static final String ATT_FORM = "form";
    private static final String ATT_TRAJET = "trajet";



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       this.getServletContext().getRequestDispatcher(VUE_CREATION).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProposerTrajetForm form = new ProposerTrajetForm();
        Trajet trajet = form.proposerTrajet(req);

        req.setAttribute(ATT_FORM,form);
        req.setAttribute(ATT_TRAJET,trajet);

        HttpSession session = req.getSession();
        session.getAttribute("details");
        this.getServletContext().getRequestDispatcher("/test.jsp").forward(req,resp);

       /* if(form.getErreurs().isEmpty()){
            if(session.getAttribute(ATT_SESSION_USERID) == null){
                resp.sendRedirect(req.getContextPath()+VUE_AUTHENTIFICATION);
            } else {
                resp.sendRedirect(req.getContextPath()+VUE_USER_ACCUEIL);            }
        }else {
            req.getServletContext().getRequestDispatcher(VUE_CREATION).forward(req,resp);
        }*/
    }
}
