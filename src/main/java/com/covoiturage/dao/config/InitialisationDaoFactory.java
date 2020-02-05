package com.covoiturage.dao.config;

import com.covoiturage.dao.DAOFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.SQLException;

public class InitialisationDaoFactory implements ServletContextListener {
    private static final String ATT_FACT = "daofactory";
    private DAOFactory daoFactory;
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        try {
            daoFactory = DAOFactory.getInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        servletContext.setAttribute(ATT_FACT,this.daoFactory);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
