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

}

