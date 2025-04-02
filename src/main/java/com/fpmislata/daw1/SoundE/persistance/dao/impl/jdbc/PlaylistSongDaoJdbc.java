package com.fpmislata.daw1.SoundE.persistance.dao.impl.jdbc;

import com.fpmislata.daw1.SoundE.domain.entity.Playlist;
import com.fpmislata.daw1.SoundE.persistance.dao.PlaylistSongDao;
import com.fpmislata.daw1.SoundE.persistance.dao.impl.jdbc.database.DatabaseConnection;
import com.fpmislata.daw1.SoundE.persistance.dao.impl.jdbc.rowmapper.PlaylistRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PlaylistSongDaoJdbc implements PlaylistSongDao {
    private final DatabaseConnection databaseConnection;
    private final PlaylistRowMapper playlistRowMapper;

    public PlaylistSongDaoJdbc() {
        this.databaseConnection = DatabaseConnection.getInstance();
        this.playlistRowMapper = new PlaylistRowMapper();
    }

    @Override
    public List<Playlist> findByGenre(String name) {
        String sql = "SELECT p.id_playlist, p.name, p.dateCreate, p.imgPath, p.artist, p.artistImgPath " +
                "FROM tb_playlist p " +
                "INNER JOIN tb_playlistsong ps ON p.id_playlist = ps.pls_id_playlist " +
                "INNER JOIN tb_song s ON ps.pls_id_song = s.id_song " +
                "INNER JOIN tb_songgenres sg ON s.id_song = sg.sgr_id_song " +
                "INNER JOIN tb_genre g ON g.id_genre = sg.sgr_id_genre " +
                "WHERE g.name = ?";

        List<Object> parameters = List.of(name);

        try(ResultSet rs = databaseConnection.executeSql(sql, parameters)) {
            return playlistRowMapper.map(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
