package com.epam.newsmanagement.model.service.impl;

import com.epam.newsmanagement.model.dao.AuthorDAO;
import com.epam.newsmanagement.model.domain.Author;
import com.epam.newsmanagement.model.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorDAO authorDAO;

    @Override
    public Long save(Author author) {
        authorDAO.save(author);
        return author.getId();
    }

    @Override
    public void update(Author author) {
        authorDAO.save(author);
    }

    @Override
    public void delete(Long id) {
        authorDAO.delete(id);
    }

    @Override
    public Author findById(Long id) {
        return authorDAO.findOne(id);
    }

    @Override
    public Author findByNewsId(Long id) {
        return authorDAO.findByNewsId(id);
    }

    @Override
    public List<Author> findAll() {
        return authorDAO.findAll();
    }

    @Override
    public List<Author> findNotExpired() {
        return null;
    }

}
