package org.bibliofem.repository.impl;

import org.bibliofem.database.DatabaseConnection;
import org.bibliofem.model.Book;
import org.bibliofem.repository.BookRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookRepositoryImpl implements BookRepository {

    @Override
    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();

        // La consulta exacta que probamos en tu pgAdmin
        String sql = "SELECT b.id_book, b.title FROM public.books b ORDER BY b.id_book ASC";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("id_book"));
                book.setTitle(rs.getString("title"));

                // Aquí se irán asociando los autores y géneros más adelante

                books.add(book);
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al traer los libros de la base de datos: " + e.getMessage());
        }

        return books;
    }
}