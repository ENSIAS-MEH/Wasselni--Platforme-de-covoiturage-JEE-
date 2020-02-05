package com.covoiturage.servlets;

import com.covoiturage.forms.trajet.DemanderTrajetForm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DemanderTrajet extends HttpServlet {
    private static final String VUE_CREATION = "/WEB-INF/trajet/demandertrajet.jsp";
    private static final String VUE_RESULTAT = "/test.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher(VUE_CREATION).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DemanderTrajetForm form = new DemanderTrajetForm() ;
        form.demanderTrajet(req);
        this.getServletContext().getRequestDispatcher(VUE_RESULTAT).forward(req,resp);

    }
}


