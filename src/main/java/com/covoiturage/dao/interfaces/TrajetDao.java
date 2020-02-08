package com.covoiturage.dao.interfaces;

import com.covoiturage.beans.DetailsTrajet;
import com.covoiturage.beans.Trajet;

import java.sql.SQLException;
import java.util.List;

public interface TrajetDao {
    public Trajet findSpecificTrajet(Trajet trajet) throws SQLException;
    public Trajet findSpecifictrajetById(Long id ) throws SQLException;
    public List<Trajet> findAllTrajets(Trajet trajet, DetailsTrajet detailsTrajet) throws SQLException;
    public Long insertTrajet(Trajet trajet) throws SQLException;
    public List<DetailsTrajet> findDetailleTrajetById(Long id) throws SQLException;
    public List<Trajet> findAllTrajets(Trajet trajet, DetailsTrajet detailsTrajet, int min, int max) throws SQLException;
}
