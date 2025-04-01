package com.fpmislata.daw1.SoundE.persistance.dao.impl.jdbc;

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
            return songRowMapper.map(rs).get(0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Song> findByName(String name) {
        String sql = "SELECT * FROM tb_song WHERE name = ?";
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
                "WHERE sg.sgr_id_genre = LIKE ?";
        List<Object> parameters = List.of(id);
        try (ResultSet rs = databaseConnection.executeSql(sql, parameters)) {
            return songRowMapper.map(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
