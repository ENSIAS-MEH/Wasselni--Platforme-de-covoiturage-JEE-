package com.covoiturage.dao.interfaces;

import com.covoiturage.beans.DetailsTrajet;

import java.sql.SQLException;
import java.util.List;

public interface DetailsTrajetDao {

    public DetailsTrajet findSpecificDetailsTrajet(DetailsTrajet detailsTrajet) throws SQLException;

    public List<DetailsTrajet> findAllDetailsTrajets() throws SQLException;
    public Long insertDetailsTrajet(DetailsTrajet detailsTrajet) throws SQLException;
    public boolean updateDetailsTrajet(DetailsTrajet detailsTrajet) throws SQLException;

}
