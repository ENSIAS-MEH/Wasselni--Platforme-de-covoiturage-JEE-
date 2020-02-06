package com.covoiturage.servlets.espace.user;

import com.covoiturage.beans.DetailsTrajet;
import com.covoiturage.beans.Trajet;
import com.covoiturage.dao.DAOFactory;
import com.covoiturage.dao.interfaces.DetailsTrajetDao;
import com.covoiturage.dao.interfaces.EstAssocieADao;
import com.covoiturage.dao.interfaces.TrajetDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserAccueil extends HttpServlet {
    static final String DAO_FACTORY  = "daofactory";
    private TrajetDao trajetDao;
    private DetailsTrajetDao detailsTrajetDao;
    private EstAssocieADao estAssocieADao;

    private static final String VUE_ACCUEIL = "/WEB-INF/espace/user/espace_user.jsp";

    private static final String ATT_TRAJETS = "trajets";
    private static final String ATT_DETAILS_TRAJETS = "detailsTrajets";
    private static final String ATT_SESSION_USERID = "userId";

    @Override
    public void init() throws ServletException {
        this.trajetDao  = ((DAOFactory) this.getServletContext().getAttribute(DAO_FACTORY)).getTrajetDao();
        this.detailsTrajetDao  = ((DAOFactory) this.getServletContext().getAttribute(DAO_FACTORY)).getDetailsTrajetDao();
        this.estAssocieADao  = ((DAOFactory) this.getServletContext().getAttribute(DAO_FACTORY)).getEstAssocieADao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ArrayList<Trajet> trajets = new ArrayList<>();
        Trajet trajet = new Trajet();
        ArrayList<DetailsTrajet> detailsTrajets = new ArrayList<>();

        HttpSession session = req.getSession();
        try {
            detailsTrajets = (ArrayList<DetailsTrajet>) trajetDao.findDetailleTrajetById((Long) session.getAttribute(ATT_SESSION_USERID));
            for(DetailsTrajet detailsTrajet : detailsTrajets){
                trajet.setIdTrajet(detailsTrajet.getIdTrajetChoisie());
                trajets.add(trajetDao.findSpecificTrajet(trajet));

        }} catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute(ATT_TRAJETS,trajets);
        req.setAttribute(ATT_DETAILS_TRAJETS,detailsTrajets);
        this.getServletContext().getRequestDispatcher(VUE_ACCUEIL).forward(req,resp);



    }
}
