package org.bibliofem.database;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    static Dotenv dotenv = Dotenv.load();

    private static final String URL = "jdbc:postgresql://localhost:5432/BiblioFem";
    private static final String USER = dotenv.get("DB_USER");
    private static final String PASS = dotenv.get("DB_PASS");
    private static Connection connection;

    public static Connection getConnection() {
        try {
            System.out.println("Conexión a la base de datos.");
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            System.out.println("Error en la conexión: " + e.getMessage());
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            System.out.println("Conexión cerrada");
            connection.close();
        } catch (Exception e) {
            System.out.println("Error al cerrar: " + e.getMessage());
        }
    }

}
