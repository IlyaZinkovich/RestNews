package com.epam.newsmanagement.service.impl;

import com.epam.newsmanagement.model.domain.News;
import com.epam.newsmanagement.model.domain.SearchCriteria;
import com.epam.newsmanagement.service.NewsWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("newsWebService")
public class NewsWebServiceImpl implements NewsWebService {

    @Autowired
    private com.epam.newsmanagement.model.service.NewsService newsService;

    public NewsWebServiceImpl() {
    }

    @Override
    public List<News> getNewsList(Integer page, Integer size, Long authorId, List<Long> tagsId) {
        return newsService.findAll(page, size);
//        return newsService.findBySearchCriteria(new SearchCriteria(authorId, tagsId));
//        return newsService.findAll();
    }

    @Override
    public News getSingleNews(Long id) {
        return newsService.findById(id);
    }

    @Override
    public void addNews(News news) {
        newsService.save(news);
    }

    @Override
    public void updateNews(Long id, News news) {
        news.setId(id);
        newsService.update(news);
    }

    @Override
    public void deleteNews(Long id) {
        newsService.delete(id);
    }

    public void setNewsService(com.epam.newsmanagement.model.service.NewsService newsService) {
        this.newsService = newsService;
    }

}
