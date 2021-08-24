package org.mzuri.scratchpad.integrator;

import org.hibernate.boot.Metadata;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.service.spi.SessionFactoryServiceRegistry;
import org.mzuri.scratchpad.hibernate.listener.ScratchpadLoadEventListener;

public class ScratchpadIntegrator implements org.hibernate.integrator.spi.Integrator {

	    @Override
	    public void integrate(
	            Metadata metadata,
	            SessionFactoryImplementor sessionFactory,
	            SessionFactoryServiceRegistry serviceRegistry) {

	        // As you might expect, an EventListenerRegistry is the thing with which event
	        // listeners are registered
	        // It is a service so we look it up using the service registry
	        final EventListenerRegistry eventListenerRegistry = serviceRegistry.getService( EventListenerRegistry.class );


	        // EventListenerRegistry defines 3 ways to register listeners:

	        // 1) This form overrides any existing registrations with
//	        eventListenerRegistry.setListeners( EventType.AUTO_FLUSH,
//	                                            DefaultAutoFlushEventListener.class );

	        // 2) This form adds the specified listener(s) to the beginning of the listener chain
	        eventListenerRegistry.prependListeners( EventType.LOAD, ScratchpadLoadEventListener.class );

	        // 3) This form adds the specified listener(s) to the end of the listener chain
//	        eventListenerRegistry.appendListeners( EventType.MERGE, DefaultMergeEventListener.class );
	    }

	    @Override
	    public void disintegrate(
	            SessionFactoryImplementor sessionFactory,
	            SessionFactoryServiceRegistry serviceRegistry) {

	    }
	}
