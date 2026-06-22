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
    private int genreId;

    private List<String> authors;

    public Book() {

    }

    public Book(String isbn, String title, String description) {
        this.isbn = isbn;
        this.title = title;
        this.description = description;

    }
}
