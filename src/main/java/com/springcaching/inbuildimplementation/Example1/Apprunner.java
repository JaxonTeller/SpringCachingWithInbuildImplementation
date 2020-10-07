package com.springcaching.inbuildimplementation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Apprunner implements CommandLineRunner {

    private static final Logger LOGGER= LoggerFactory.getLogger(Apprunner.class);
    private BooksRepository booksRepository;
    private CacheManager cacheManager;
    private static final List<Book> newBooksToBeAdded;
    static
    {
        newBooksToBeAdded=new ArrayList<>();
        newBooksToBeAdded.add(new Book("Mathh","11234A"));
        newBooksToBeAdded.add(new Book("Scienceh","11234B"));
        newBooksToBeAdded.add(new Book("Geoh","11234H"));
        newBooksToBeAdded.add(new Book("Historyh","11234D"));
        newBooksToBeAdded.add(new Book("Englishh","11234E"));
    }

    public Apprunner(BooksRepository booksRepository,CacheManager cacheManager)
    {
        this.booksRepository=booksRepository;
        this.cacheManager=cacheManager;
    }

    @Override
    public void run(String... args) throws Exception {
    LOGGER.info("Fetching books");

    LOGGER.info("Book "+this.booksRepository.findBookByIsbn("1234A"));
    LOGGER.info("Book "+this.booksRepository.findBookByIsbn("1234A"));
    LOGGER.info("Book "+this.booksRepository.findBookByIsbn("1234H"));
    LOGGER.info("Book "+this.booksRepository.findBookByIsbn("1234A"));
    LOGGER.info("Book "+this.booksRepository.findBookByIsbn("1234H"));

    LOGGER.info("updating cache "+this.booksRepository.updateBook("1234A","NEWBOOKNAME"));


    LOGGER.info("Book "+this.booksRepository.findBookByIsbn("1234A"));
    LOGGER.info("Book "+this.booksRepository.findBookByIsbn("1234A"));

    System.out.println(this.cacheManager.getCacheNames());

    LOGGER.info("Loading new books");
    this.booksRepository.addNewBooks(newBooksToBeAdded);

    LOGGER.info("Book "+this.booksRepository.findBookByIsbn("11234A"));
    LOGGER.info("Book "+this.booksRepository.findBookByIsbn("11234A"));
    LOGGER.info("Book "+this.booksRepository.findBookByIsbn("11234H"));




    }
}
