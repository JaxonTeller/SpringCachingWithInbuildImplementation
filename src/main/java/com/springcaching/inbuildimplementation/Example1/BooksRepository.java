package com.springcaching.inbuildimplementation;

import org.springframework.cache.annotation.EnableCaching;

import java.util.List;
import java.util.Optional;

public interface BooksRepository {

     Book findBookByIsbn(String isbn);

     Book updateBook(String isbn,String bookNameToUpdate);

     void addNewBooks(List<Book> newBooksToAdd);
}
