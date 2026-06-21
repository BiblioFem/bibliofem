package org.bibliofem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        // Datos de conexión
        // Asegúrate de que estos valores coincidan con tu configuración de PostgreSQL
        String url = "jdbc:postgresql://localhost:5432/BiblioFem";
        String usuario = "postgres";
        String password = "fernandez";

        System.out.println("--- Iniciando prueba de conexión ---");
        System.out.println("Intentando conectar a la base de datos...");

        // Intentamos establecer la conexión
        try (Connection conexion = DriverManager.getConnection(url, usuario, password)) {

            if (conexion != null) {
                System.out.println("¡Conexión exitosa a la base de datos BiblioFem!");
            }

        } catch (SQLException e) {
            // Si hay un error, se imprime aquí
            System.err.println("Error al conectar a la base de datos:");
            System.err.println("Mensaje: " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("--- Proceso finalizado ---");
    }
}

