package com.fpmislata.daw1.SoundE.persistance.dao.impl.jdbc;

import com.fpmislata.daw1.SoundE.domain.entity.User;
import com.fpmislata.daw1.SoundE.persistance.dao.LoginDao;
import com.fpmislata.daw1.SoundE.persistance.dao.impl.jdbc.database.DatabaseConnection;
import com.fpmislata.daw1.SoundE.persistance.dao.impl.jdbc.rowmapper.UserRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class LoginDaoJdbc implements LoginDao {

    private final DatabaseConnection databaseConnection;
    private final UserRowMapper userRowMapper;

    public LoginDaoJdbc() {
        this.databaseConnection = DatabaseConnection.getInstance();
        this.userRowMapper = new UserRowMapper();
    }

    @Override
    public User authenticate(String username, String password) {
        String sql = "SELECT * FROM tb_user WHERE username = ? AND password = ?";
        List<Object> parameters = List.of(username, password);

        try (ResultSet rs = databaseConnection.executeSql(sql, parameters)) {
            List<User> userList = userRowMapper.map(rs);
            return userList.isEmpty() ? null : userList.get(0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User findByUsername(String username) {
        String sql = "SELECT * FROM tb_user WHERE username = ?";
        List<Object> parameters = List.of(username);

        try (ResultSet rs = databaseConnection.executeSql(sql, parameters)) {
            List<User> userList = userRowMapper.map(rs);
            return userList.isEmpty() ? null : userList.get(0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updatePassword(String username, String newPassword) {
        String sql = "UPDATE tb_user SET password = ? WHERE username = ?";
        List<Object> parameters = List.of(newPassword, username);

        try {
            int rowsAffected = databaseConnection.executeUpdateSql(sql, parameters);
            return rowsAffected > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean exists(String username) {
        String sql = "SELECT COUNT(*) AS total FROM tb_user WHERE username = ?";
        List<Object> parameters = List.of(username);

        try (ResultSet rs = databaseConnection.executeSql(sql, parameters)) {
            if (rs.next()) {
                return rs.getInt("total") > 0;
            }
            return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
