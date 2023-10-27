package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String jdbcURL = "jdbc:postgresql://localhost:5432/Escola";
    private static final String username = "postgres";
    private static final String password = "postgres";

    public static Connection conectar() {
        try {
            return DriverManager.getConnection(jdbcURL, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}