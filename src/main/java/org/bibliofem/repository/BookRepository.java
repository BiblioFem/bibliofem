package org.bibliofem.repository;

import org.bibliofem.model.Book;
import java.util.List;

public interface BookRepository {
     List<Book> getAllBooks();
}
