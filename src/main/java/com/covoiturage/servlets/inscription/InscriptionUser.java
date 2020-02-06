package com.covoiturage.servlets.inscription;

import com.covoiturage.beans.User;
import com.covoiturage.dao.DAOFactory;
import com.covoiturage.dao.interfaces.UserDao;
import com.covoiturage.forms.UserInscriptionForm;
import com.covoiturage.mailer.Mailer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InscriptionUser extends HttpServlet {
    static final String DAO_FACTORY  = "daofactory";
    private UserDao userDao;

    private static final String VUE_INSCRIPTION = "/WEB-INF/inscription.jsp" ;
    private static final String VUE_APRES_INSCRITPION = "/apres_inscription.jsp";

    private static final String ATT_FORM = "form";
    private static final String ATT_USER = "user";
    private static final String ATT_SESSION_USER = "userSession";

    @Override
    public void init() throws ServletException {
        this.userDao = ((DAOFactory) this.getServletContext().getAttribute(DAO_FACTORY)).getUserDao();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher(VUE_INSCRIPTION).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserInscriptionForm form = new UserInscriptionForm(userDao);
        User user = form.inscrireUser(req);

        req.setAttribute(ATT_FORM,form);
        req.setAttribute(ATT_USER,user);


        if(form.getErreurs().isEmpty()){
            HttpSession session = req.getSession();
            session.setAttribute(ATT_SESSION_USER,user);
            resp.sendRedirect(VUE_APRES_INSCRITPION);
        } else {
            this.getServletContext().getRequestDispatcher(VUE_INSCRIPTION).forward(req, resp);
        }
    }


}
