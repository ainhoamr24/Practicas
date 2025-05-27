package com.fpmislata.daw1.SoundE.persistance.dao.impl.jdbc.rowmapper;

import com.fpmislata.daw1.SoundE.domain.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper extends RowMapper<User> {
    @Override
    public User mapItem(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getLong("id_user"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setEmail(rs.getString("email"));
        user.setBirthDate(rs.getDate("birthDate").toLocalDate());

        return user;
    }
}
