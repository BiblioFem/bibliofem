package org.bibliofem.repository.impl;

import org.bibliofem.database.DatabaseConnection;
import org.bibliofem.model.Book;
import org.bibliofem.repository.BookRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookRepositoryImpl implements BookRepository {
    Connection connection;
    PreparedStatement stmn;
    ResultSet result;

    @Override
    public List<Book> getAllBooks(){
        List<Book> books = new ArrayList<>();
        String sql = """
                SELECT
                    b.id,
                    b.isbn,
                    b.title,
                    b.description,
                    a.author,
                    g.genre
                FROM books b
                JOIN book_author ba ON b.id = ba.book_id
                JOIN authors a ON ba.author_id = a.id
                JOIN genres g ON b.genre_id = g.id
                """;
        try {
            connection = DatabaseConnection.getConnection();



        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            DatabaseConnection.closeConnection();
        }
    }
}
