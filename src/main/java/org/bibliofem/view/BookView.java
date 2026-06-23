package org.bibliofem.view;
import org.bibliofem.controller.BookController;
import org.bibliofem.model.Book;
import java.util.List;

public class BookView {
    private BookController  controller;
    public BookView (BookController controller) {
        this.controller = controller;

    }

    public void getAllBooks(){
        List<Book> books = controller.getAllBooks();
        for (Book book : books){
            System.out.println("ID: " + book.getIdBook());
            System.out.println("ISBN: " + book.getIsbn());
            System.out.println("TITLE: " + book.getTitle());
            System.out.println("AUTHOR: " + book.getAuthors());
            System.out.println("GENRE: " + book.getGenre());
            System.out.println("--------------------------------");
        }
    }

}


