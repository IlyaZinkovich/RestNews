package com.epam.newsmanagement.model;

import com.epam.newsmanagement.model.dao.NewsDAO;
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

import static org.junit.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-test.xml")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class })
@ActiveProfiles(profiles = "hibernate")
@Transactional
public class NewsDAOTest {

    private static Logger logger = Logger.getLogger(NewsDAOTest.class);

    @Autowired
    private NewsDAO newsDAO;

    @Test
    public void findByAuthorId() {
        assertEquals(newsDAO.findByAuthorId(1L).size(), 3);
    }

}
