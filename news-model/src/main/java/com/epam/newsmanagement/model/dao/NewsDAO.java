package com.epam.newsmanagement.model.dao;

import com.epam.newsmanagement.model.domain.News;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface NewsDAO extends JpaRepository<News, Long> {

    List<News> findByAuthorId(Long id, Pageable pageable);
    List<News> findByAuthorId(Long id);

}
