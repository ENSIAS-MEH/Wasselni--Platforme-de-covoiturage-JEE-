package com.covoiturage.servlets;

import com.covoiturage.beans.User;
import com.covoiturage.dao.DAOFactory;
import com.covoiturage.dao.interfaces.UserDao;
import com.covoiturage.forms.PreInscriptionForm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PreInscription extends HttpServlet {
    private static final String VUE_INSCRIPTION = "/index.jsp";

    static final String DAO_FACTORY  = "daofactory";
    private UserDao userDao;

    private static final String ATT_USER = "user";

    @Override
    public void init() throws ServletException {
        this.userDao = ((DAOFactory) this.getServletContext().getAttribute(DAO_FACTORY)).getUserDao();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PreInscriptionForm form = new PreInscriptionForm(userDao);
        User user = form.inscrire(req);
        req.setAttribute(ATT_USER,user);
        this.getServletContext().getRequestDispatcher(VUE_INSCRIPTION).forward(req,resp);
    }
}
