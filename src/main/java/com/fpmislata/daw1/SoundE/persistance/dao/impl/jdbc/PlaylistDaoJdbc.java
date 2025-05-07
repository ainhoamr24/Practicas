package com.fpmislata.daw1.SoundE.persistance.dao.impl.jdbc;

import com.fpmislata.daw1.SoundE.domain.entity.Playlist;
import com.fpmislata.daw1.SoundE.persistance.dao.PlaylistDao;
import com.fpmislata.daw1.SoundE.persistance.dao.impl.jdbc.database.DatabaseConnection;
import com.fpmislata.daw1.SoundE.persistance.dao.impl.jdbc.rowmapper.PlaylistRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PlaylistDaoJdbc implements PlaylistDao {
    private final PlaylistRowMapper playlistRowMapper;
    private final DatabaseConnection databaseConnection;

    public PlaylistDaoJdbc() {
        this.playlistRowMapper = new PlaylistRowMapper();
        this.databaseConnection = DatabaseConnection.getInstance();
    }

    @Override
    public Playlist findById(Long id) {
        String sql =  "SELECT * " +
                "FROM tb_playlist p " +
                "WHERE p.id_playlist = ?";

        List<Object> parameters = List.of(id);

        try (ResultSet rs = databaseConnection.executeSql(sql, parameters)) {
            List<Playlist> playlistList = playlistRowMapper.map(rs);
            return playlistList.isEmpty() ? null : playlistList.get(0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Playlist> findAll() {
        String sql = "SELECT * " +
                "FROM tb_playlist p ";

        try (ResultSet rs = databaseConnection.executeSql(sql,List.of())) {
            return playlistRowMapper.map(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Playlist> findByName(String name) {
        String sql = "SELECT * " +
                "FROM tb_playlist p " +
                "WHERE p.name like ?";

        List<Object> parameters = List.of('%'+name+'%');

        try (ResultSet rs = databaseConnection.executeSql(sql, parameters)) {
            return playlistRowMapper.map(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
