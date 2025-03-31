package com.fpmislata.daw1.SoundE.persistance.dao.impl.jdbc;

import com.fpmislata.daw1.SoundE.domain.entity.Playlist;
import com.fpmislata.daw1.SoundE.persistance.dao.PlaylistSongDao;
import com.fpmislata.daw1.SoundE.persistance.dao.impl.jdbc.database.DatabaseConnection;
import com.fpmislata.daw1.SoundE.persistance.dao.impl.jdbc.rowmapper.PlaylistSongRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PlaylistSongDaoJdbc implements PlaylistSongDao {
    private final DatabaseConnection databaseConnection;
    private final PlaylistSongRowMapper playlistSongRowMapper;

    public PlaylistSongDaoJdbc() {
        this.databaseConnection = DatabaseConnection.getInstance();
        this.playlistSongRowMapper = new PlaylistSongRowMapper();
    }

    @Override
    public List<Playlist> findByGenre(String name) {
        String sql = "SELECT p.id_playlist, p.name, p.dateCreate, p.imagePath, p.artist, p.artistImgPath " +
                "FROM tb_playlist p " +
                "INNER JOIN tb_playlistsong ps ON p.playlist_id = ps.pls_id_playlist " +
                "INNER JOIN tb_song s ON ps.pls_id_song = s.id_song " +
                "INNER JOIN tb_songgenres sg ON s.id_song = sg.sgr_id_song" +
                "INNER JOIN tb_genre g ON g.id_genre = sg.sgr_id_genre " +
                "WHERE g.name = ?";

        List<Object> parameters = List.of(name);

        try(ResultSet rs = databaseConnection.executeSql(sql, parameters)) {
            return playlistSongRowMapper.map(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Playlist getPlaylistWithSongs(Long id) {
        String sql = "SELECT * " +
                "FROM tb_song s " +
                "INNER JOIN tb_playlistsong ps ON s.id_song = ps.pls_id_song " +
                "INNER JOIN tb_playlist p ON ps.pls_id_playlist = p.id_playlist " +
                "WHERE p.id_playlist = ?";

        List<Object> parameters = List.of(id);

        try (ResultSet rs = databaseConnection.executeSql(sql,parameters)) {
            return playlistSongRowMapper.map(rs).get(0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
