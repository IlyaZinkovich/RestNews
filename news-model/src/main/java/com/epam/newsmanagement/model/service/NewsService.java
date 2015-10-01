package com.epam.newsmanagement.model.service;

import com.epam.newsmanagement.model.domain.News;
import com.epam.newsmanagement.model.domain.SearchCriteria;

import java.util.List;

public interface NewsService {

    Long save(News news);
    void update(News news);
    void delete(Long id);
    void delete(List<News> newsList);
    News findById(Long id);
    List<News> findByAuthorId(Long id);
    List<News> findAll();
    List<News> findAll(int page, int size);
    List<News> findBySearchCriteria(SearchCriteria searchCriteria, int page, int size);
    List<News> findBySearchCriteria(SearchCriteria searchCriteria);

}
