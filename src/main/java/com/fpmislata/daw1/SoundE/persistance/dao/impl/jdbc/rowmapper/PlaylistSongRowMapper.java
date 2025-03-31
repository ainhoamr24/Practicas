package com.fpmislata.daw1.SoundE.persistance.dao.impl.jdbc.rowmapper;

import com.fpmislata.daw1.SoundE.domain.entity.Playlist;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PlaylistSongRowMapper extends RowMapper<Playlist> {
    private final PlaylistRowMapper playlistRowMapper;
    private final SongRowMapper songRowMapper;

    public PlaylistSongRowMapper() {
        this.playlistRowMapper = new PlaylistRowMapper();
        this.songRowMapper = new SongRowMapper();
    }

    @Override
    public Playlist mapItem(ResultSet rs) throws SQLException {
        Playlist playlist = playlistRowMapper.mapItem(rs);
        playlist.setSongs(new ArrayList<>());

        long songId = rs.getLong("pls_id_song");
        if(songId != 0) {
            do {
                playlist.getSongs().add(songRowMapper.mapItem(rs));
            } while (rs.next());
        }

        return playlist;
    }
}
