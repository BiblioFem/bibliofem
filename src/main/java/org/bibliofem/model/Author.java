package org.bibliofem.model;

public class Author {
    private int idAuthor;
    private String author;

    public Author(){

    }

    public Author(String author) {
        this.author = author;
    }

    public int getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(int idAuthor) {
        this.idAuthor = idAuthor;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
