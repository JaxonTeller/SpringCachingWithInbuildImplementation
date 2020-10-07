package com.springcaching.inbuildimplementation;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Component
public class BooksService implements BooksRepository{

    private static final List<Book> bookList;
    static
    {
        bookList=new ArrayList<>();
        bookList.add(new Book("Math","1234A"));
        bookList.add(new Book("Science","1234B"));
        bookList.add(new Book("Geo","1234H"));
        bookList.add(new Book("History","1234D"));
        bookList.add(new Book("English","1234E"));
    }

    @Override
    @Cacheable(cacheNames = "books")
    public Book findBookByIsbn(String isbn) {
        simulateSlowService();
        return bookList.stream().filter(book -> book.getIsbn().equals(isbn)).
                findFirst().get();

    }

    @Override
    @CachePut(cacheNames = "books")
    public Book updateBook(String isbn,String bookNameToUpdate) {
        Book book1 = bookList.stream().filter(book -> book.getIsbn().equals(isbn)).findFirst().get();
        book1.setBookName(bookNameToUpdate);
        return book1;
    }

    @Override
    @CacheEvict(cacheNames = "books",allEntries = true)
    public void addNewBooks(List<Book> newBooksToAdd) {
        bookList.addAll(newBooksToAdd);
    }

    private void simulateSlowService() {
        try {
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
