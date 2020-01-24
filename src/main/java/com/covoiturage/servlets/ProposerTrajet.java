package com.covoiturage.servlets;

import com.covoiturage.beans.Trajet;
import com.covoiturage.forms.ProposerTrajetForm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProposerTrajet extends HttpServlet {

    private static final String VUE_CREATION = "/WEB-INF/proposertrajet.jsp";
    /*
     * Page resultat apres avoir proposé un trajet à implémenter
     */
    private static final String VUE_RESULTAT = "";
    private static final String ATT_FORM = "form";
    private static final String ATT_TRAJET = "trajet";



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       this.getServletContext().getRequestDispatcher(VUE_CREATION).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProposerTrajetForm form = new ProposerTrajetForm();
        Trajet trajet = new Trajet();
        req.setAttribute(ATT_FORM,form);
        req.setAttribute(ATT_TRAJET,trajet);
        if(form.getErreurs().isEmpty()){
            req.getServletContext().getRequestDispatcher(VUE_RESULTAT).forward(req,resp);
        }else {
            req.getServletContext().getRequestDispatcher(VUE_CREATION).forward(req,resp);
        }
    }
}
