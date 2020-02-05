package com.covoiturage.servlets.espace.admin;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminUsers extends HttpServlet {
    private static final String VUE_USERS = "/WEB-INF/espace/admin/utilisateurs.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher(VUE_USERS).forward(req,resp);
    }
}
