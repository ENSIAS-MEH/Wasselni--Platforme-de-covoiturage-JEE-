package com.covoiturage.servlets;

import com.covoiturage.forms.UserAuthForm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthUser extends HttpServlet {
    private static final String ATT_SESSION_USERID = "userId";

    private static final String VUE_AUTHENTIFICATION = "/WEB-INF/authentification.jsp";
    private static final String VUE_USER_ACCUEIL = "";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher(VUE_AUTHENTIFICATION).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserAuthForm form = new UserAuthForm();
        int userId = form.authentification(req);

        if(form.getErreurs().isEmpty()){
            HttpSession session = req.getSession();
            session.setAttribute(ATT_SESSION_USERID,userId);

            this.getServletContext().getRequestDispatcher(VUE_USER_ACCUEIL).forward(req,resp);
        } else {
            this.getServletContext().getRequestDispatcher(VUE_AUTHENTIFICATION).forward(req, resp);
        }
    }
}
