package com.covoiturage.servlets.espace.admin;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminOffres extends HttpServlet {
    private static final String VUE_OFFRES = "/WEB-INF/espace/admin/offres_admin.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher(VUE_OFFRES).forward(req,resp);
    }
}
