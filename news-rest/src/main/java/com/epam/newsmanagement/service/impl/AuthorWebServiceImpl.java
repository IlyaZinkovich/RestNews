package com.epam.newsmanagement.service.impl;

import com.epam.newsmanagement.model.domain.Author;
import com.epam.newsmanagement.model.service.AuthorService;
import com.epam.newsmanagement.service.AuthorWebService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.QueryParam;
import java.util.List;

@Service("authorWebService")
public class AuthorWebServiceImpl implements AuthorWebService {

    private static Logger logger = Logger.getLogger(AuthorWebServiceImpl.class);

    @Autowired
    private AuthorService authorService;

    @Override
    public List<Author> getAllAuthors() {
        return authorService.findAll();
    }

    @Override
    public List<Author> getAuthorsIfExpired(@QueryParam("expired") Boolean expired) {
        if (!expired) {
            return authorService.findNotExpired();
        }
        return null;
    }

    @Override
    public Author getAuthor(Long id) {
        return authorService.findById(id);
    }

    @Override
    public Author getAuthorByNewsId(Long id) {
        return authorService.findByNewsId(id);
    }

    @Override
    public void addAuthor(Author author) {
        authorService.save(author);
    }

    @Override
    public void updateAuthor(Long id, Author author) {
        author.setId(id);
        authorService.update(author);
    }

    @Override
    public void deleteAuthor(Long id) {
        authorService.delete(id);
    }

}
