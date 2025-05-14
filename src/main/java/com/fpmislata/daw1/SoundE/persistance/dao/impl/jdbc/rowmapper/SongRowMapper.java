package com.fpmislata.daw1.SoundE.persistance.dao.impl.jdbc.rowmapper;

import com.fpmislata.daw1.SoundE.domain.entity.Song;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SongRowMapper extends RowMapper<Song> {
    @Override
    public Song mapItem(ResultSet rs) throws SQLException {
        Song song = new Song();
        song.setId(rs.getLong("id_song"));
        song.setName(rs.getString("name"));
        song.setImgPath(rs.getString("imgPath"));
        song.setArtist(rs.getString("artist"));
        song.setArtistImgPath(rs.getString("artistImgPath"));
        song.setDateCreate(rs.getDate("dateCreate").toLocalDate());
        song.setSeconds(rs.getLong("seconds"));
        song.setUrl(rs.getString("url"));

        return song;
    }
}
