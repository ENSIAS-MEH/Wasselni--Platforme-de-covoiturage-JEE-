package com.covoiturage.servlets;

import com.covoiturage.beans.User;
import com.covoiturage.forms.UserForm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class InscriptionUser extends HttpServlet {
    private static final String VUE_INSCRIPTION = "/WEB-INF/inscription.jsp" ;
    private static final String VUE_APRES_INSCRITPION = "/after_inscription.jsp";

    private static final String ATT_FORM = "form";
    private static final String ATT_USER = "user";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher(VUE_INSCRIPTION).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserForm form = new UserForm();
        User user = form.inscrireUser(req);

        req.setAttribute(ATT_FORM,form);
        req.setAttribute(ATT_USER,user);

        HttpSession session = req.getSession();
        if(form.getErreurs().isEmpty()){
            session.setAttribute("user",user);
            /**
             * Création d'un user dans la bd
             */
            this.getServletContext().getRequestDispatcher(VUE_APRES_INSCRITPION).forward(req,resp);
        } else {
            this.getServletContext().getRequestDispatcher(VUE_INSCRIPTION).forward(req, resp);
        }
    }
}
