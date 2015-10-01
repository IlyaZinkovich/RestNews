package com.epam.newsmanagement.model;

import com.epam.newsmanagement.model.domain.Author;
import com.epam.newsmanagement.model.domain.News;
import com.epam.newsmanagement.model.service.AuthorService;
import com.epam.newsmanagement.model.service.NewsService;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-test.xml")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class })
@ActiveProfiles(profiles = "hibernate")
@Transactional
public class ServiceTest {

    private static Logger logger = Logger.getLogger(AuthorDAOTest.class);

    @Autowired
    private AuthorService authorService;

    @Autowired
    private NewsService newsService;

    @Test
    public void findByNewsId() {
        Author author = authorService.findByNewsId(2L);
        logger.error("It's news author  " + author);
    }

    public void findById() {
    }

}
