package com.covoiturage.servlets;

import com.covoiturage.beans.DetailsTrajet;
import com.covoiturage.beans.Trajet;
import com.covoiturage.dao.DAOFactory;
import com.covoiturage.dao.interfaces.DetailsTrajetDao;
import com.covoiturage.dao.interfaces.TrajetDao;
import com.covoiturage.dao.interfaces.UserDao;
import com.covoiturage.forms.OffreForm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;

public class ConsulterOffres extends HttpServlet {
    static final String DAO_FACTORY  = "daofactory";
    private TrajetDao trajetDao;
    private DetailsTrajetDao detailsTrajetDao;

    private static final String ATT_FORM = "form";

    @Override
    public void init() throws ServletException {
        this.trajetDao = ((DAOFactory) this.getServletContext().getAttribute(DAO_FACTORY)).getTrajetDao();
        this.detailsTrajetDao = ((DAOFactory) this.getServletContext().getAttribute(DAO_FACTORY)).getDetailsTrajetDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OffreForm form = new OffreForm(trajetDao,detailsTrajetDao);
        form.consulterOffres(req);
        if(form.getErreurs().isEmpty()){
            this.getServletContext().getRequestDispatcher("/offres.jsp").forward(req,resp);
        }else {
            this.getServletContext().getRequestDispatcher("/accueil").forward(req,resp);

        }
    }
}

