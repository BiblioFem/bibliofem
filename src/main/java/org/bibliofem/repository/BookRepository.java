package org.bibliofem.repository;

import org.bibliofem.model.Book;
import java.util.List;

public interface BookRepository {

    // El contrato: quien implemente esta interfaz está obligado a devolver la lista de libros
    List<Book> findAll();

}
