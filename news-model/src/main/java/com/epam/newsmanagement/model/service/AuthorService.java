package com.epam.newsmanagement.model.service;

import com.epam.newsmanagement.model.domain.Author;

import java.util.List;

public interface AuthorService {

    Long save(Author author);
    void update(Author author);
    void delete(Long id);
    Author findById(Long id);
    Author findByNewsId(Long id);
    List<Author> findAll();
    List<Author> findNotExpired();

}
