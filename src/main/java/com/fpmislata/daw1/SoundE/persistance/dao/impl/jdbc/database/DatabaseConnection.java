package com.fpmislata.daw1.SoundE.persistance.dao.impl.jdbc.database;

import com.fpmislata.daw1.SoundE.common.AppPropertiesReader;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.List;

@Log4j2
public class DatabaseConnection {
    private static DatabaseConnection instance = null;
    public static DatabaseConnection getInstance() {
        if(instance == null)
            instance = new DatabaseConnection();

        return instance;
    }

    private final String URL;
    private final String USER;
    private final String PASSWORD;
    private final Connection connection;

    public Connection getConnection() {
        return connection;
    }

    private DatabaseConnection() {
        URL = AppPropertiesReader.getProperty("app.datasource.url");
        USER = AppPropertiesReader.getProperty("app.datasource.username");
        PASSWORD = AppPropertiesReader.getProperty("app.datasource.password");

        log.info("Estableciendo conexión con la base de datos...");
        try {
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
            log.info("Conexión establecida");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet executeSql(String sql, List<Object> parameters) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        for (int i = 0; i < parameters.size(); i++) {
            preparedStatement.setObject(i + 1, parameters.get(i));
        }

        return preparedStatement.executeQuery();
    }

    @SuppressWarnings("SqlSourceToSinkFlow")
    public PreparedStatement prepareStatement(String sql) throws SQLException {
        return connection.prepareStatement(sql);
    }

    public void setAutoCommit(boolean autoCommit) throws SQLException {
        connection.setAutoCommit(autoCommit);
    }

    public void rollback() throws SQLException {
        connection.rollback();
    }

    public void executeScript(String scriptPath) {
        try {
            ScriptRunner scriptRunner = new ScriptRunner(connection, false, false);

            InputStream scriptStream = getClass().getClassLoader().getResourceAsStream(scriptPath);
            if (scriptStream == null)
                throw new RuntimeException("Script not found: " + scriptPath);

            scriptRunner.runScript(new InputStreamReader(scriptStream));
        } catch (IOException | SQLException e) {
            throw new RuntimeException(String.format("Error executing script %s:\n    %s\n", scriptPath, e.getMessage()));
        }
    }

    public int executeUpdateSql(String sql, List<Object> parameters) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i < parameters.size(); i++) {
            preparedStatement.setObject(i + 1, parameters.get(i));
        }
        return preparedStatement.executeUpdate();
    }
}
