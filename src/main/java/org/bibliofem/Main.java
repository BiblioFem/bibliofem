package org.bibliofem;


import org.bibliofem.database.DatabaseConnection;
import java.sql.Connection;
import org.bibliofem.model.Book;
import org.bibliofem.model.Genre;
import org.bibliofem.model.Author;

public class Main {
    public static void main(String[] args) {

        // Primera prueba de conexión
        //DatabaseConnection databaseConnection = new DatabaseConnection();
        //Connection connection = databaseConnection.getConnection();
        Book book = new Book("123", "abc", "beautiful book");
        System.out.println(book.getTitle());

        Genre genre = new Genre("fantasy");
        System.out.println(genre.getGenre());

        Author author = new Author("Virginia Woolf");
        System.out.println(author.getAuthor());
    }
}

