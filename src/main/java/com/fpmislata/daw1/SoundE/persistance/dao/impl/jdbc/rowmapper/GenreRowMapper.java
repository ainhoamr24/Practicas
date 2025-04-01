package com.fpmislata.daw1.SoundE.persistance.dao.impl.jdbc.rowmapper;

import com.fpmislata.daw1.SoundE.domain.entity.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GenreRowMapper extends RowMapper<Genre> {
    @Override
    public Genre mapItem(ResultSet rs) throws SQLException {
        Genre genre = new Genre();
        genre.setId(rs.getLong("id_genre"));
        genre.setName(rs.getString("name"));
        genre.setImgPath(rs.getString("imgPath"));
        return genre;
    }
}
