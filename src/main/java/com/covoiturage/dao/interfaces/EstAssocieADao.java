package com.covoiturage.dao.interfaces;

import com.covoiturage.beans.EstAssociea;

import java.sql.SQLException;
import java.util.List;

public interface EstAssocieADao {

    public EstAssociea findSpecificEstAssocieA(EstAssociea estAssociea) throws SQLException;
    public List<EstAssociea> findAllEstAssocieA() throws SQLException;
    public Long insertEstAssocieA(EstAssociea estAssociea) throws SQLException;
    public boolean updateEstAssocieA(EstAssociea estAssociea) throws SQLException;

}
