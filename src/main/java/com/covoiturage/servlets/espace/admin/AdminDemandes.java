package com.covoiturage.servlets.espace.admin;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminDemandes extends HttpServlet {
    private static final String VUE_DEMANDES = "/WEB-INF/espace/admin/demandes_admin.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher(VUE_DEMANDES).forward(req,resp);
    }
}
