package com.fpmislata.daw1.SoundE.persistance.dao.impl.jdbc;

import com.fpmislata.daw1.SoundE.domain.entity.Genre;
import com.fpmislata.daw1.SoundE.domain.entity.Playlist;
import com.fpmislata.daw1.SoundE.domain.entity.Song;
import com.fpmislata.daw1.SoundE.persistance.dao.GenreDao;
import com.fpmislata.daw1.SoundE.persistance.dao.impl.jdbc.database.DatabaseConnection;
import com.fpmislata.daw1.SoundE.persistance.dao.impl.jdbc.rowmapper.GenreRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class GenreDaoJdbc implements GenreDao {
    private final GenreRowMapper genreRowMapper;
    private final DatabaseConnection databaseConnection;

    public GenreDaoJdbc() {
        this.genreRowMapper = new GenreRowMapper();
        this.databaseConnection = DatabaseConnection.getInstance();
    }

    @Override
    public Genre findById(Long id) {
        String sql = "SELECT * " +
                "FROM tb_genre g " +
                "WHERE g.id_genre = ?";
        List<Object> parameters = List.of(id);
        try (ResultSet rs = databaseConnection.executeSql(sql, parameters)) {
            List<Genre> genreList = genreRowMapper.map(rs);
            return genreList.isEmpty() ? null : genreList.get(0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Genre> findAll() {
        String sql = "SELECT * FROM tb_genre";
        try (ResultSet rs = databaseConnection.executeSql(sql, List.of())) {
            return genreRowMapper.map(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Genre> findByName(String name) {
        String sql = "SELECT * " +
                "FROM tb_genre g " +
                "WHERE g.name LIKE ?";

        List<Object> parameters = List.of("%" + name + "%");

        try (ResultSet rs = databaseConnection.executeSql(sql, parameters)) {
            return genreRowMapper.map(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Genre> getGenreBySong(Song song) {
        String sql = "SELECT g.* " +
                "FROM tb_genre g " +
                "INNER JOIN tb_songGenres sg ON g.id_genre = sg.sgr_id_genre " +
                "WHERE sg.sgr_id_song = ?";
        List<Object> parameters = List.of(song.getId());
        try (ResultSet rs = databaseConnection.executeSql(sql, parameters)) {
            return genreRowMapper.map(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Genre> getGenreByPlaylist(Playlist playlist) {
        String sql = "SELECT DISTINCT g.* FROM tb_genre g " +
                "INNER JOIN tb_songGenres sg ON g.id_genre = sg.sgr_id_genre " +
                "INNER JOIN tb_playlistSong ps ON sg.sgr_id_song = ps.pls_id_song " +
                "WHERE ps.pls_id_playlist = ?";
        List<Object> parameters = List.of(playlist.getId());
        try (ResultSet rs = databaseConnection.executeSql(sql, parameters)) {
            return genreRowMapper.map(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}