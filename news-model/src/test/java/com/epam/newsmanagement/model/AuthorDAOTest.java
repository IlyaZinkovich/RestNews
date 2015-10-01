package com.epam.newsmanagement.model;

import com.epam.newsmanagement.model.dao.AuthorDAO;
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
public class AuthorDAOTest {

	private static Logger logger = Logger.getLogger(AuthorDAOTest.class);

	@Autowired
	private AuthorDAO authorDAO;

	@Test
	public void findByNewsId() {
		assertEquals(Long.valueOf(1L), authorDAO.findByNewsId(2L).getId());
	}

	public void findById() {
		assertEquals(Long.valueOf(1L), authorDAO.findOne(1L).getId());
	}

}
