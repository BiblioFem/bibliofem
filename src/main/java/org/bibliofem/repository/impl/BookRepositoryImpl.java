package org.bibliofem.repository.impl;

import org.bibliofem.database.DatabaseConnection;
import org.bibliofem.model.Book;
import org.bibliofem.repository.BookRepository;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookRepositoryImpl implements BookRepository {
    Connection connection;
    Statement stmn;

    @Override
    public List<Book> getAllBooks(){
        List<Book> books = new ArrayList<>();
        String sql = """
                SELECT
                    b.id,
                    b.isbn,
                    b.title,
                    b.description,
                    STRING_AGG(a.author, ',') AS authors,
                    g.genre
                FROM books b
                JOIN book_author ba ON b.id = ba.book_id
                JOIN authors a ON ba.author_id = a.id
                JOIN genres g ON b.genre_id = g.id
                GROUP BY b.id, b.isbn, b.title, b.description, g.genre
                """;
        try {
            connection = DatabaseConnection.getConnection();
            stmn = connection.createStatement();
            ResultSet result = stmn.executeQuery(sql);

            while (result.next()) {
                Book book = new Book(
                        result.getInt("id"),
                        result.getString("isbn"),
                        result.getString("title"),
                        result.getString("description"),
                        result.getString("genre"),
                        result.getString("authors")
                );
                books.add(book);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        finally {
            DatabaseConnection.closeConnection();
        } return books;
    }
}
