package com.covoiturage.servlets;

import com.covoiturage.dao.DAOFactory;
import com.covoiturage.dao.interfaces.UserDao;
import com.covoiturage.forms.OffreForm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Console;
import java.io.IOException;

public class ConsulterOffres extends HttpServlet {
    static final String DAO_FACTORY  = "daofactory";
    private UserDao userDao;

    private static final String ATT_FORM = "form";

    @Override
    public void init() throws ServletException {
        this.userDao = ((DAOFactory) this.getServletContext().getAttribute(DAO_FACTORY)).getUserDao();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OffreForm form = new OffreForm(userDao);
        form.consulterOffres(req);

        req.setAttribute(ATT_FORM,form);
        this.getServletContext().getRequestDispatcher("/offres.jsp").forward(req,resp);

    }
}

