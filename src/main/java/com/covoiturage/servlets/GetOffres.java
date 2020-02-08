package com.covoiturage.servlets;

import com.covoiturage.dao.DAOFactory;
import com.covoiturage.dao.interfaces.DetailsTrajetDao;
import com.covoiturage.dao.interfaces.TrajetDao;
import com.covoiturage.forms.GetOffreForm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetOffres extends HttpServlet {
    static final String DAO_FACTORY  = "daofactory";
    private TrajetDao trajetDao;
    private DetailsTrajetDao detailsTrajetDao;

    private static final String ATT_FORM = "form";
    private static final String VUE_OFFRES = "/offres.jsp";

    @Override
    public void init() throws ServletException {
        this.trajetDao = ((DAOFactory) this.getServletContext().getAttribute(DAO_FACTORY)).getTrajetDao();
        this.detailsTrajetDao = ((DAOFactory) this.getServletContext().getAttribute(DAO_FACTORY)).getDetailsTrajetDao();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/offres.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GetOffreForm form = new GetOffreForm(trajetDao,detailsTrajetDao);
        form.getOffre(req);
        req.setAttribute(ATT_FORM,"form");
        this.getServletContext().getRequestDispatcher("/offres.jsp").forward(req,resp);

    }
}
