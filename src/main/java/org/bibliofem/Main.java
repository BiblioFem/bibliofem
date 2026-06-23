package org.bibliofem;


import org.bibliofem.controller.BookController;
import org.bibliofem.database.DatabaseConnection;
import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import org.bibliofem.model.Book;
import org.bibliofem.model.Genre;
import org.bibliofem.model.Author;
import org.bibliofem.repository.BookRepository;
import org.bibliofem.repository.impl.BookRepositoryImpl;
import org.bibliofem.service.BookService;
import org.bibliofem.view.BookView;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserta el gènero del libro que estás buscando: ");
        String titleSearch = scanner.nextLine();



        BookRepository bookRepository = new BookRepositoryImpl();
        BookService bookService = new BookService(bookRepository);
        BookController bookController = new BookController(bookService);
        BookView bookView = new BookView(bookController);
        bookView.filterByGenre(titleSearch);

    }

}

