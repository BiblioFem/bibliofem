package org.bibliofem.view;

import org.bibliofem.controller.BookController;
import org.bibliofem.repository.BookRepository;
import org.bibliofem.repository.impl.BookRepositoryImpl;
import org.bibliofem.service.BookService;
import org.bibliofem.utils.ConsoleColors;

import java.util.Scanner;

public class MenuView {
    private Scanner scanner;
    private BookRepository bookRepository;
    private BookService bookService;
    private BookController bookController;
    private BookView bookView;

    public MenuView() {
        scanner = new Scanner(System.in);
        bookRepository = new BookRepositoryImpl();
        bookService = new BookService(bookRepository);
        bookController = new BookController(bookService);
        bookView = new BookView(bookController);
    }

    public void printWelcome() {
        System.out.println(
                ConsoleColors.PURPLE +
                        """
                                             /\\___/\\
                                            ( =^.^= )
                                             (")_(")
                                """
        );
        System.out.println(
                "╔══════════════════════════════╗");
        System.out.println(
                "║     BIBLIOTECA FEMINISTA     ║");
        System.out.println(
                "╚══════════════════════════════╝" +
                        ConsoleColors.RESET
        );
    }

    public void printMenu(){
        System.out.println(ConsoleColors.CYAN +
                "========== MENÚ ==========");

        System.out.println("1. Ver todos los libros");
        System.out.println("2. Buscar por título");
        System.out.println("3. Buscar por autora");
        System.out.println("4. Buscar por género");

        System.out.println(ConsoleColors.RED +
                "0. Salir" +
                ConsoleColors.RESET);
    }

    public void startMenu() {
        boolean running = true;
        while (running) {
            printWelcome();
            printMenu();
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option){
                case 1:
                    bookView.getAllBooks();
                    break;
                case 2:
                    bookView.filterByTitle();
                    break;
                case 3:
                    bookView.filterByAuthor();
                    break;
                case 4:
                    bookView.filterByGenre();
                    break;
                case 0:
                    running = false;
                    System.out.println("¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
