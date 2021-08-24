package org.mzuri.scratchpad;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.BootstrapServiceRegistry;
import org.hibernate.boot.registry.BootstrapServiceRegistryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.mzuri.scratchpad.integrator.ScratchpadIntegrator;
import org.mzuri.scratchpad.domain.Author;
import org.mzuri.scratchpad.domain.Book;
import org.mzuri.scratchpad.domain.Category;
import org.junit.jupiter.api.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HibernateTest {
	
	private Logger logger = LoggerFactory.getLogger(HibernateTest.class);

	@Test
	public void useHibernate() {
		
		SessionFactory sessionFactory = getSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		
		Book bookFromLoad = session.get(Book.class, 1l);
		
		List<Author> authors = bookFromLoad.getAuthors();
		
		logger.info("Book {}", bookFromLoad);
		
		session.close();
		
		sessionFactory.close();
	}
	
	private SessionFactory getSessionFactory() {
		
		//Bootstrap services
		BootstrapServiceRegistryBuilder builder = new BootstrapServiceRegistryBuilder();
		
		builder.applyIntegrator( new ScratchpadIntegrator() );
		
		BootstrapServiceRegistry bootstrapServiceRegistry = builder.build();
		
		//Standard services
		StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder(bootstrapServiceRegistry);
		
		ServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
				 .configure( "hibernate.cfg.xml" )
				 .build();

		//Metadata
		MetadataSources sources = new MetadataSources( standardRegistry );
		
//		sources.addPackage( "org.jack.scratchpad.domain" );
		sources.addAnnotatedClass( Author.class );
		sources.addAnnotatedClass( Book.class );
		sources.addAnnotatedClass( Category.class );
		
		Metadata metadata = sources.buildMetadata();
		
		//SessionFactory
		SessionFactory sessionFactory = metadata.buildSessionFactory();
		
		return sessionFactory;
	}
}

