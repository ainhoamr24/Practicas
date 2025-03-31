package com.fpmislata.daw1.SoundE.persistance.dao.impl.jdbc.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class RowMapper <E> {
    public abstract E mapItem(ResultSet rs) throws SQLException;

    public List<E> map(ResultSet rs) throws SQLException {
        if (rs == null)
            return null;

        List<E> resultList = new ArrayList<>();
        while (rs.next()) {
            resultList.add(mapItem(rs));
        }

        return resultList;
    }
}
