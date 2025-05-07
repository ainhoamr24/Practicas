package com.fpmislata.daw1.SoundE.utils;

import com.fpmislata.daw1.SoundE.persistance.dao.impl.jdbc.database.DatabaseConnection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import java.sql.SQLException;

public class JdbcTest {

    private static final DatabaseConnection connection = DatabaseConnection.getInstance();
    private static boolean initialized = false;

    @BeforeAll
    public static void setup() throws SQLException {
        if(!initialized) {
            connection.executeScript("schema.sql");
            connection.executeScript("data.sql");
            connection.setAutoCommit(false);
            initialized = true;
        }
    }

    @AfterEach
    void tearDown() throws SQLException {
        connection.rollback();
    }
}
