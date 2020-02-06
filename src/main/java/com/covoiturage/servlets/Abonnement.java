package com.covoiturage.servlets;

import com.covoiturage.forms.AbonnementForm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Abonnement extends HttpServlet {
    private static final String VUE_APRE_ABONNEMENT = "";


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //AbonnementForm form = new AbonnementForm(new UserD);
       // form.inscrire(req);

        this.getServletContext().getRequestDispatcher(VUE_APRE_ABONNEMENT).forward(req,resp);
    }
}
