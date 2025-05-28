package com.fpmislata.daw1.SoundE.persistance.dao.impl.jdbc;

import com.fpmislata.daw1.SoundE.domain.entity.User;
import com.fpmislata.daw1.SoundE.persistance.dao.AccountDao;
import com.fpmislata.daw1.SoundE.persistance.dao.impl.jdbc.database.DatabaseConnection;
import com.fpmislata.daw1.SoundE.persistance.dao.impl.jdbc.rowmapper.UserRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AccountDaoJdbc implements AccountDao {

    private final DatabaseConnection databaseConnection;
    private final UserRowMapper userRowMapper;

    public AccountDaoJdbc() {
        this.databaseConnection = DatabaseConnection.getInstance();
        this.userRowMapper = new UserRowMapper();
    }

    @Override
    public User create(User user) {
        String sql = "INSERT INTO tb_user (username, password, email, birthDate) VALUES (?, ?, ?, ?)";
        List<Object> parameters = List.of(user.getUsername(), user.getPassword(), user.getEmail(), user.getBirthdate());

        try {
            int rowsAffected = databaseConnection.executeUpdateSql(sql, parameters);
            return rowsAffected > 0 ? findByUsername(user.getUsername()) : null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User findById(Long id) {
        String sql = "SELECT * FROM tb_user WHERE id_usr = ?";
        try (ResultSet rs = databaseConnection.executeSql(sql, List.of(id))) {
            List<User> users = userRowMapper.map(rs);
            return users.isEmpty() ? null : users.get(0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> findAll() {
        String sql = "SELECT * FROM tb_user";
        try (ResultSet rs = databaseConnection.executeSql(sql, List.of())) {
            return userRowMapper.map(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean existsByUsername(String username) {
        String sql = "SELECT 1 FROM tb_user WHERE username = ?";
        try (ResultSet rs = databaseConnection.executeSql(sql, List.of(username))) {
            return rs.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean existsByEmail(String email) {
        String sql = "SELECT 1 FROM tb_user WHERE email = ?";
        try (ResultSet rs = databaseConnection.executeSql(sql, List.of(email))) {
            return rs.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User findByUsername(String username) {
        String sql = "SELECT * FROM tb_user WHERE username = ?";
        try (ResultSet rs = databaseConnection.executeSql(sql, List.of(username))) {
            List<User> users = userRowMapper.map(rs);
            return users.isEmpty() ? null : users.get(0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

