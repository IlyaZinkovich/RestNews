package com.epam.newsmanagement.model.service.impl;

import com.epam.newsmanagement.model.dao.NewsDAO;
import com.epam.newsmanagement.model.domain.News;
import com.epam.newsmanagement.model.domain.SearchCriteria;
import com.epam.newsmanagement.model.service.NewsService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    private static Logger logger = Logger.getLogger(NewsServiceImpl.class);

    @Autowired
    private NewsDAO newsDAO;


    @Override
    public Long save(News news) {
        newsDAO.save(news);
        return news.getId();
    }

    @Override
    public void update(News news) {
        newsDAO.save(news);
    }

    @Override
    public void delete(Long id) {
        newsDAO.delete(id);
    }

    @Override
    public void delete(List<News> newsList) {
        newsDAO.deleteInBatch(newsList);
    }

    @Override
    public News findById(Long id) {
        return newsDAO.findOne(id);
    }

    @Override
    public List<News> findByAuthorId(Long id) {
        return newsDAO.findByAuthorId(id);
    }

    @Override
    public List<News> findAll() {
        return newsDAO.findAll();
    }

    @Override
    public List<News> findAll(int page, int size) {
        return newsDAO.findAll(new PageRequest(page, size)).getContent();
    }

    @Override
    public List<News> findBySearchCriteria(SearchCriteria searchCriteria, int page, int pageSize) {

        return newsDAO.findByAuthorId(searchCriteria.getAuthorId(),
                new PageRequest(page, pageSize));
    }

    @Override
    public List<News> findBySearchCriteria(SearchCriteria searchCriteria) {
        return null;
    }
}
