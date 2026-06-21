package org.bibliofem.controller;

import org.bibliofem.model.Book;
import org.bibliofem.repository.BookRepository;
import org.bibliofem.repository.impl.BookRepositoryImpl;

import java.util.List;

public class BookController {

    // Conectamos el controlador con el repositorio que busca en la base de datos
    private final BookRepository bookRepository = new BookRepositoryImpl();

    // Este método se encargará de pedir los libros y pintarlos ordenados
    public void listAllBooks() {
        System.out.println("\n📚 === LISTA DE LIBROS EN BIBLIOFEM ===");

        List<Book> books = bookRepository.findAll();

        if (books.isEmpty()) {
            System.out.println("⚠️ No se encontraron libros en la base de datos.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
        System.out.println("=======================================\n");
    }
}
