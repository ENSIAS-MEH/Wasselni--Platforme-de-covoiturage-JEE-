package com.covoiturage.servlets.espace.user;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserAccueil extends HttpServlet {
    private static final String VUE_ACCUEIL = "/WEB-INF/espace/user/espace_user.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher(VUE_ACCUEIL).forward(req,resp);
    }
}
