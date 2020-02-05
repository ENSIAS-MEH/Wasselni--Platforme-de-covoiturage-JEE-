package com.covoiturage.servlets;

import com.covoiturage.forms.OffreForm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Console;
import java.io.IOException;

public class ConsulterOffres extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OffreForm form = new OffreForm();
        form.consulterOffres(req);

        this.getServletContext().getRequestDispatcher("/test.jsp").forward(req,resp);

    }
}

