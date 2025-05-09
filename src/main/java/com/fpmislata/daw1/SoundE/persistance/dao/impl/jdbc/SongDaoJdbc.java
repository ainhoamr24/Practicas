package com.fpmislata.daw1.SoundE.persistance.dao.impl.jdbc;

import com.fpmislata.daw1.SoundE.domain.entity.Playlist;
import com.fpmislata.daw1.SoundE.domain.entity.Song;
import com.fpmislata.daw1.SoundE.persistance.dao.SongDao;
import com.fpmislata.daw1.SoundE.persistance.dao.impl.jdbc.database.DatabaseConnection;
import com.fpmislata.daw1.SoundE.persistance.dao.impl.jdbc.rowmapper.SongRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SongDaoJdbc implements SongDao {
    private final SongRowMapper songRowMapper;
    private final DatabaseConnection databaseConnection;

    public SongDaoJdbc() {
        this.songRowMapper = new SongRowMapper();
        this.databaseConnection = DatabaseConnection.getInstance();
    }

    @Override
    public Song findById(Long id) {
        String sql = "SELECT * FROM tb_song WHERE id_song = ?";
        List<Object> parameters = List.of(id);
        try (ResultSet rs = databaseConnection.executeSql(sql, parameters)) {
            if (!rs.next())
                return null;
            return songRowMapper.mapItem(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Song> findAll() {
        String sql = "SELECT * " +
                "FROM tb_song s ";

        try (ResultSet rs = databaseConnection.executeSql(sql,List.of())) {
            return songRowMapper.map(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Song> findByName(String name) {
        String sql = "SELECT * FROM tb_song WHERE name like ?";
        List<Object> parameters = List.of(name);
        try (ResultSet rs = databaseConnection.executeSql(sql, parameters)) {
            return songRowMapper.map(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Song> findByGenre(Long id) {
        String sql = "SELECT * " +
                "FROM tb_song s " +
                "INNER JOIN tb_songGenres sg ON s.id_song = sg.sgr_id_song " +
                "WHERE sg.sgr_id_genre = ?";
        List<Object> parameters = List.of(id);
        try (ResultSet rs = databaseConnection.executeSql(sql, parameters)) {
            return songRowMapper.map(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Song> getSongsByPlaylist(Long id) {
        String sql = "SELECT * " +
                "FROM tb_song s " +
                "INNER JOIN tb_playlistSong ps ON s.id_song = ps.pls_id_song " +
                "WHERE ps.pls_id_playlist = ?";
        List<Object> parameters = List.of(id);
        try (ResultSet rs = databaseConnection.executeSql(sql, parameters)) {
            return songRowMapper.map(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
