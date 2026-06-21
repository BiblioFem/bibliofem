package org.bibliofem.model;

public class Book {
    // 1. Atributos emparejados con tu base de datos
    private int id;
    private String title;
    private int idGenre; // Vinculado al id_genre directo de la tabla books

    // 2. Constructor vacío (esencial para que lo use el Repository)
    public Book() {
    }

    // 3. Constructor con parámetros
    public Book(int id, String title, int idGenre) {
        this.id = id;
        this.title = title;
        this.idGenre = idGenre;
    }

    // 4. Métodos Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIdGenre() {
        return idGenre;
    }

    public void setIdGenre(int idGenre) {
        this.idGenre = idGenre;
    }

    // 5. Método toString para poder ver los libros bonitos por consola más adelante
    @Override
    public String toString() {
        return "Libro [ID=" + id + ", Título=" + title + ", ID Género=" + idGenre + "]";
    }
}
