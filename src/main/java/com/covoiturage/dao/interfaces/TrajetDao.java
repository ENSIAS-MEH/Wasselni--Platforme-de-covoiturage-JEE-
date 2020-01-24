package com.covoiturage.dao.interfaces;

import com.covoiturage.beans.Trajet;

import java.sql.SQLException;
import java.util.List;

public interface TrajetDao {
    public Trajet findSpecificTrajet(Trajet trajet) throws SQLException;
    public List<Trajet> findAllTrajets() throws SQLException;
    public Long insertTrajet(Trajet trajet) throws SQLException;
}
