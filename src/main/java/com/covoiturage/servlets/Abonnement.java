package com.covoiturage.servlets;

import com.covoiturage.dao.DAOFactory;
import com.covoiturage.dao.interfaces.UserDao;
import com.covoiturage.forms.AbonnementForm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Abonnement extends HttpServlet {
    private static final String VUE_APRE_ABONNEMENT = "/index.jsp";

    static final String DAO_FACTORY  = "daofactory";
    private UserDao userDao;

    private static final String ATT_FORM = "form";

    @Override
    public void init() throws ServletException {
        this.userDao = ((DAOFactory) this.getServletContext().getAttribute(DAO_FACTORY)).getUserDao();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
<<<<<<< HEAD
        //AbonnementForm form = new AbonnementForm(new UserD);
       // form.inscrire(req);

=======
        AbonnementForm form = new AbonnementForm(userDao);
        form.inscrire(req);
        req.setAttribute(ATT_FORM,form);
>>>>>>> 93545f1a6c5aee0188499c056b8b3b7ac7928d77
        this.getServletContext().getRequestDispatcher(VUE_APRE_ABONNEMENT).forward(req,resp);
    }
}
