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
import org.bibliofem.utils.ConsoleColors;
import org.bibliofem.view.BookView;
import org.bibliofem.view.MenuView;

public class Main {
    public static void main(String[] args) {
        MenuView menuView = new MenuView();
        menuView.startMenu();

    }

}

