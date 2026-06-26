package org.bibliofem.view;
import org.bibliofem.controller.BookController;
import org.bibliofem.model.Book;
import org.bibliofem.utils.ConsoleColors;

import java.util.List;
import java.util.Scanner;

public class BookView {
    private BookController  controller;
    public BookView (BookController controller) {
        this.controller = controller;

    }

    public void printListOfBooks(List<Book> listOfBooks, boolean showDescription){
        for (Book book : listOfBooks){
            System.out.println("ID: " + book.getIdBook());
            System.out.println("ISBN: " + book.getIsbn());
            System.out.println("TÍTULO: " + book.getTitle());
            if (showDescription) {
                System.out.println("DESCRIPCIÓN: " + book.getDescription());
            }
            System.out.println("AUTOR: " + book.getAuthors());
            System.out.println("GÉNERO: " + book.getGenre());
            System.out.println("--------------------------------");
        }
    }

    public void getAllBooks(){
        List<Book> books = controller.getAllBooks();
        printListOfBooks(books, false);
    }

    public void filterByTitle(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserta el título del libro que estás buscando: ");
        String titleSearch = scanner.nextLine();
        List<Book> books = controller.filterByTitle(titleSearch);
        if (books.isEmpty()) {
            System.out.println("No se encontraron libros con ese título.");
            return;
        }
        printListOfBooks(books, true);

    }

    public void filterByAuthor(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserta el autor del libro que estás buscando: ");
        String author = scanner.nextLine();
        List<Book> books = controller.filterByAuthor(author);
        if (books.isEmpty()) {
            System.out.println("No se encontraron libros de este autor.");
            return;
        }
        printListOfBooks(books, true);

    }

    public void filterByGenre(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserta el género del libro que estás buscando: ");
        String genre = scanner.nextLine();
        List<Book> books = controller.filterByGenre(genre);
        if (books.isEmpty()) {
            System.out.println("No se encontraron libros de este género.");
            return;
        }
        printListOfBooks(books, false);

    }

    public void deleteBook(){
        Scanner scanner = new Scanner(System.in);
        getAllBooks();
        System.out.print("Introduce el id del libro que quieras eliminar: ");
        if(scanner.hasNextInt()){
            int idSearch = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Deseas borrar definitivamente el libro seleccionado? Este cambio será irreversible...\n SI / NO");

            String response = scanner.nextLine();
            if(response.equalsIgnoreCase("SI")){
                controller.deleteBook(idSearch);
                System.out.println(ConsoleColors.PURPLE + "Libro eliminado con éxito" + ConsoleColors.RESET);
            }

        } else {
            System.out.println("Debes introducir un número");
        }
    }
}


