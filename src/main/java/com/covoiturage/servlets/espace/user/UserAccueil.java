package com.covoiturage.servlets.espace.user;

import com.covoiturage.beans.DetailsTrajet;
import com.covoiturage.beans.EstAssociea;
import com.covoiturage.beans.Trajet;
import com.covoiturage.beans.User;
import com.covoiturage.dao.DAOFactory;
import com.covoiturage.dao.interfaces.DetailsTrajetDao;
import com.covoiturage.dao.interfaces.EstAssocieADao;
import com.covoiturage.dao.interfaces.TrajetDao;
import com.covoiturage.dao.interfaces.UserDao;
import com.covoiturage.forms.UpdateUserForm;

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
    private UserDao userDao;

    private static final String ATT_FORM = "form";

    private static final String VUE_ACCUEIL = "/WEB-INF/espace/user/espace_user.jsp";

    private static final String ATT_TRAJETS = "trajets";
    private static final String ATT_DETAILS_TRAJETS = "detailsTrajets";
    private static final String ATT_SESSION_USERID = "userId";
    private static final String ATT_EST_ASSOCIE_A = "estAssocieas";

    @Override
    public void init() throws ServletException {
        this.trajetDao  = ((DAOFactory) this.getServletContext().getAttribute(DAO_FACTORY)).getTrajetDao();
        this.detailsTrajetDao  = ((DAOFactory) this.getServletContext().getAttribute(DAO_FACTORY)).getDetailsTrajetDao();
        this.estAssocieADao  = ((DAOFactory) this.getServletContext().getAttribute(DAO_FACTORY)).getEstAssocieADao();
        this.userDao = ((DAOFactory) this.getServletContext().getAttribute(DAO_FACTORY)).getUserDao();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ArrayList<Trajet> trajets = new ArrayList<>();
        ArrayList<DetailsTrajet> detailsTrajets = new ArrayList<>();
        ArrayList<EstAssociea> estAssocieas = new ArrayList<>();
        EstAssociea estAssociea = new EstAssociea();


        HttpSession session = req.getSession();
        try {
            detailsTrajets = (ArrayList<DetailsTrajet>) trajetDao.findDetailleTrajetById((Long) session.getAttribute(ATT_SESSION_USERID));
            for(DetailsTrajet detailsTrajet : detailsTrajets){
                trajets.add(trajetDao.findSpecifictrajetById(detailsTrajet.getIdTrajetChoisie()));
                estAssociea.setIdUser((Long) session.getAttribute(ATT_SESSION_USERID));
                estAssociea.setIdDetailsTrajet(detailsTrajet.getIdDetailsTrajet());
                estAssocieas.add(estAssocieADao.findSpecificEstAssocieA(estAssociea));

             }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute(ATT_TRAJETS,trajets);
        req.setAttribute(ATT_DETAILS_TRAJETS,detailsTrajets);
        req.setAttribute(ATT_EST_ASSOCIE_A,estAssocieas);
        this.getServletContext().getRequestDispatcher(VUE_ACCUEIL).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UpdateUserForm form = new UpdateUserForm(userDao);
        form.updateUser(req);

        req.setAttribute(ATT_FORM,form);

        doGet(req, resp);
    }
}
