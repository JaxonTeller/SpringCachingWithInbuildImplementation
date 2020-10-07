package com.springcaching.inbuildimplementation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Apprunner implements CommandLineRunner {

    private static final Logger LOGGER= LoggerFactory.getLogger(Apprunner.class);

    private BooksRepository booksRepository;

    public Apprunner(BooksRepository booksRepository)
    {
        this.booksRepository=booksRepository;
    }

    @Override
    public void run(String... args) throws Exception {
    LOGGER.info("Fetching books");
    LOGGER.info("Book "+this.booksRepository.findBookByIsbn("1234A"));
    LOGGER.info("Book "+this.booksRepository.findBookByIsbn("1234A"));
    LOGGER.info("Book "+this.booksRepository.findBookByIsbn("1234H"));
    LOGGER.info("Book "+this.booksRepository.findBookByIsbn("1234A"));
    LOGGER.info("Book "+this.booksRepository.findBookByIsbn("1234H"));
    }
}
