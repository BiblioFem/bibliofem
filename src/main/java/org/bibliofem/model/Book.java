package org.bibliofem.model;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {
    private int idBook;
    private String isbn;
    private String title;
    private String description;
    private String genreId;

    private String authors;

    public Book() {

    }

    public Book(int id, String isbn, String title, String description, String genreId, String authors) {
        this.idBook = id;
        this.isbn = isbn;
        this.title = title;
        this.description = description;
        this.genreId = genreId;
        this.authors = authors;

    }
}
