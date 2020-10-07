package com.springcaching.inbuildimplementation;

import org.springframework.cache.annotation.EnableCaching;

public interface BooksRepository {

    public Book findBookByIsbn(String isbn);
}
