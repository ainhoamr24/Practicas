package com.fpmislata.daw1.SoundE.persistance.dao.impl.jdbc.rowmapper;

import com.fpmislata.daw1.SoundE.domain.entity.Playlist;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlaylistRowMapper extends RowMapper<Playlist> {
    @Override
    public Playlist mapItem(ResultSet rs) throws SQLException {
        Playlist playlist = new Playlist();
        playlist.setId(rs.getLong("id_playlist"));
        playlist.setName(rs.getString("name"));
        playlist.setDateCreate(rs.getDate("dateCreate").toLocalDate());
        playlist.setArtist(rs.getString("artist"));
        playlist.setArtistImgPath(rs.getString("artistImgPath"));
        playlist.setImgPath(rs.getString("imgPath"));

        return playlist;
    }
}
