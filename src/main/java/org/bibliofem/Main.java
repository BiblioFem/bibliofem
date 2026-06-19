package org.bibliofem;

import org.bibliofem.database.DatabaseConnection;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        // Primera prueba de conexión
  DatabaseConnection databaseConnection = new DatabaseConnection();
  Connection connection = databaseConnection.getConnection();
    }
}
