package org.bibliofem;

import org.bibliofem.model.Book;
import org.bibliofem.repository.BookRepository;
import org.bibliofem.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceTest {

    private BookService bookService;

    @BeforeEach
    void setUp() {

        List<Book> listBooks = List.of(
                new Book(1, "978-1", "El cuento de la criada", "Desc1", "Feminismo", "Margaret Atwood"),
                new Book(2, "978-2", "Una habitación propia", "Desc2", "Ensayo", "Virginia Woolf"),
                new Book(3, "978-3", "La campana de cristal", "Desc3", "Novela", "Sylvia Plath")
        );

        BookRepository mockRepository = new BookRepository() {

            @Override
            public List<Book> getAllBooks() {
                return listBooks;
            }

            @Override
            public void deleteBook(int id) {
                // en este caso no probaremos este test pero debemos implementarlo
            }
        };

        bookService = new BookService(mockRepository);
    }

    @Test
    void testFilterByTitle_returnsMatchingBook() {
        List<Book> result = bookService.filterByTitle("criada");

        assertEquals(1, result.size());
        assertEquals("El cuento de la criada", result.getFirst().getTitle());
    }

    @Test
    void testFilterByTitle_noResults() {
        List<Book> result = bookService.filterByTitle("Harry Potter");

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilterByAuthor_returnsMatchingBook() {
        List<Book> result = bookService.filterByAuthor("Woolf");

        assertEquals(1, result.size());
        assertEquals("Virginia Woolf", result.getFirst().getAuthors());
    }

    @Test
    void testFilterByAuthor_noResults() {
        List<Book> result = bookService.filterByAuthor("Murakami");

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilterByGenre_returnsMatchingBook() {
        List<Book> result = bookService.filterByGenre("Novela");

        assertEquals(1, result.size());
        assertEquals("La campana de cristal", result.getFirst().getTitle());
    }

    @Test
    void testFilterByGenre_noResults() {
        List<Book> result = bookService.filterByGenre("Historia");

        assertTrue(result.isEmpty());
    }
}