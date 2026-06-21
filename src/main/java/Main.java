package org.bibliofem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        // Asegúrate de que tu usuario y contraseña sean los correctos
        String url = "jdbc:postgresql://localhost:5432/BiblioFem";
        String usuario = "postgres";
        String password = "fernandez";

        System.out.println("Intentando conectar a la base de datos...");

        try (Connection conexion = DriverManager.getConnection(url, usuario, password)) {
            if (conexion != null) {
                System.out.println("¡Conexión exitosa a BiblioFem!");
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
