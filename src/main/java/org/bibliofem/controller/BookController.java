package org.bibliofem.controller;
import org.bibliofem.model.Book;
import org.bibliofem.service.BookService;
import java.util.List;

public class BookController {
    private BookService service;
    public BookController (BookService service) {
        this.service = service;

    }
    public List<Book> getAllBooks(){
        return service.getAllBooks();
    }

    public List<Book> filterByTitle(String title) {
        return service.filterByTitle(title);
    }

    public List<Book> filterByAuthor(String author) {
        return service.filterByAuthor(author);
    }

    public List<Book> filterByGenre(String genre) {
        return service.filterByGenre(genre);
    }
}

