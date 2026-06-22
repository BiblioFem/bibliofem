package org.bibliofem.model;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Author {
    private int idAuthor;
    private String author;

    public Author(){

    }

    public Author(String author) {
        this.author = author;
    }

}
