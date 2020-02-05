package com.covoiturage.servlets.inscription;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Validation extends HttpServlet {
    private static final String VUE_USER_ACCUEIL = "/WEB-INF/espace/user/espace_user.html";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ValidationForm form = new ValidationForm(userDao);
        Long userId = form.validate(req);
        HttpSession session = req.getSession();
        session.setAttribute(ATT_SESSION_USERID,userId);
        this.getServletContext().getRequestDispatcher(VUE_USER_ACCUEIL).forward(req,resp);
    }
}
