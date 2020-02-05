package com.covoiturage.servlets;

import com.covoiturage.beans.User;
import com.covoiturage.dao.DAOFactory;
import com.covoiturage.dao.interfaces.UserDao;
import com.covoiturage.forms.UserInscriptionForm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class InscriptionUser extends HttpServlet {
    static final String DAO_FACTORY  = "daofactory";
    private UserDao userDao;

    private static final String VUE_INSCRIPTION = "/WEB-INF/inscription.jsp" ;
    private static final String VUE_APRES_INSCRITPION = "/after_inscription.jsp";

    private static final String ATT_FORM = "form";
    private static final String ATT_USER = "user";

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

        HttpSession session = req.getSession();
        if(form.getErreurs().isEmpty()){
            session.setAttribute("user",user);
            this.getServletContext().getRequestDispatcher(VUE_APRES_INSCRITPION).forward(req,resp);
        } else {
            this.getServletContext().getRequestDispatcher(VUE_INSCRIPTION).forward(req, resp);
        }
    }
}
