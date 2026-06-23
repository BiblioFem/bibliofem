package org.bibliofem.view;
import org.bibliofem.controller.BookController;
import org.bibliofem.model.Book;
import java.util.List;

public class BookView {
    private BookController  controller;
    public BookView (BookController controller) {
        this.controller = controller;

    }

    public void printListOfBooks(List<Book> listOfBooks){
        for (Book book : listOfBooks){
            System.out.println("ID: " + book.getIdBook());
            System.out.println("ISBN: " + book.getIsbn());
            System.out.println("TÍTULO: " + book.getTitle());
            System.out.println("AUTOR: " + book.getAuthors());
            System.out.println("GÉNERO: " + book.getGenre());
            System.out.println("--------------------------------");
        }
    }

    public void getAllBooks(){
        List<Book> books = controller.getAllBooks();
        printListOfBooks(books);
    }

    public void filterByTitle(String title){

            List<Book> books = controller.filterByTitle(title);
            if (books.isEmpty()) {
                System.out.println("No se encontraron libros con ese título.");
                return;
            }
            printListOfBooks(books);

    }

    public void filterByAuthor(String author){

        List<Book> books = controller.filterByAuthor(author);
        if (books.isEmpty()) {
            System.out.println("No se encontraron libros de este autor.");
            return;
        }
        printListOfBooks(books);

    }

    public void filterByGenre(String genre){

        List<Book> books = controller.filterByGenre(genre);
        if (books.isEmpty()) {
            System.out.println("No se encontraron libros de este autor.");
            return;
        }
        printListOfBooks(books);

    }

}


