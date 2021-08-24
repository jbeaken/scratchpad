package org.mzuri.scratchpad;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.hibernate.testing.transaction.TransactionUtil.*;
import static org.junit.Assert.assertTrue;

import org.mzuri.scratchpad.domain.Book;
import org.junit.jupiter.api.Test;

public class JPATest {

	@Test
	public void getData() {

		Book book = new Book();
		book.setTitle("A Farewell to Arms");
		book.setIsbn("97845646474");

		doInJPA(this::entityManagerFactoryUsingPersistenceXML, entityManager -> {
			entityManager.persist(book);
			assertTrue(entityManager.contains(book));
		});

	}

	private EntityManagerFactory entityManagerFactoryUsingPersistenceXML() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory( "org.scratchpad" );
		return emf;
	}

}