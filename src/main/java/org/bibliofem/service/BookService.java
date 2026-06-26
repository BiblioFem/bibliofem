package org.bibliofem.service;

import org.bibliofem.model.Book;
import org.bibliofem.repository.BookRepository;

import java.util.List;

public class BookService {
  private BookRepository  repository;
  public BookService (BookRepository repository) {
      this.repository = repository;

  }

  public List<Book> getAllBooks(){
      return repository.getAllBooks();

  }

  public List<Book> filterByTitle(String title){
        return repository.getAllBooks()
                .stream()
                .filter(book -> book.getTitle().toLowerCase().contains(title.toLowerCase()))
                .toList();
  }


  public List<Book> filterByAuthor(String author){
        return repository.getAllBooks()
                .stream()
                .filter(book -> book.getAuthors().toLowerCase().contains(author.toLowerCase()))
                .toList();
  }


  public List<Book> filterByGenre(String genre){
        return repository.getAllBooks()
                .stream()
                .filter(book -> book.getGenre().toLowerCase().contains(genre.toLowerCase()))
                .toList();
  }

  public void deleteBook(int id){
      repository.deleteBook(id);
  }

}

