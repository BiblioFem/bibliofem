package org.bibliofem;


import org.bibliofem.controller.BookController;
import org.bibliofem.database.DatabaseConnection;
import java.sql.Connection;
import java.util.List;

import org.bibliofem.model.Book;
import org.bibliofem.model.Genre;
import org.bibliofem.model.Author;
import org.bibliofem.repository.BookRepository;
import org.bibliofem.repository.impl.BookRepositoryImpl;
import org.bibliofem.service.BookService;
import org.bibliofem.view.BookView;

public class Main {
    public static void main(String[] args) {
        BookRepository bookRepository = new BookRepositoryImpl();
        BookService bookService = new BookService(bookRepository);
        BookController bookController = new BookController(bookService);
        BookView bookView = new BookView(bookController);
        bookView.getAllBooks();
    }
}

