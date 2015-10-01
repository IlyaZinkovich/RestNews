package com.epam.newsmanagement.model.dao;

import com.epam.newsmanagement.model.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface AuthorDAO extends JpaRepository<Author, Long> {

    Author findByNewsId(Long id);
    List<Author> findByExpiredIsNull();

}
