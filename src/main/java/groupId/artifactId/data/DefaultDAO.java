/**
 * This software is licensed under the terms of the MIT license.
 * Copyright (C) 2016 Dmytro Romenskyi
 */
package groupId.artifactId.data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Value;
import groupId.artifactId.domain.IdentifiedEntityInterface;

import java.util.Collections;
import java.util.List;

/**
 * Generic class for accessing application datastorage
 */
@Repository
public class DefaultDAO {
	
	private @Value("${app.softDeleteEnabled}") boolean softDelete;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * Checks whether the entity with provided key exists
	 *
	 * @param clazz entity class
	 * @param id key to check
     * @return true is entity of the provided class with provided key exists; false otherwise
     */
	private <ENTITY extends IdentifiedEntityInterface> boolean exists(Class<ENTITY> clazz, Long id) {
		
		if(id == null) {
			return false;
		}
		
		Session session = getSession();
		
		return session.get(clazz, id) != null;
	}

	/**
	 * Gets all entities of the provided class
	 * @param clazz entity class
	 *
     * @return a list of all entities of provided class or empty list if there no such entities
     */
	public <ENTITY extends IdentifiedEntityInterface> List<ENTITY> getAll(Class<ENTITY> clazz) {
		Session session = getSession();
		
		@SuppressWarnings("unchecked")
		List<ENTITY> entities = session.createCriteria(clazz).list();
		
		if(entities == null) {
			entities = Collections.emptyList();
		}
		
		return entities;
	}

	/**
	 * Creates a new entry in the datastorage with data from provided entity
	 *
	 * @param entity entity information to save
	 *
     * @return ID of the newly created entity
     */
	public <ENTITY extends IdentifiedEntityInterface> Long create(ENTITY entity) {
		if(entity == null) {
			throw new IllegalArgumentException("Invalid entity provided:[NULL]");
		}
		
		if(entity.getId() != null) {
			entity.setId(null);
		}
		
		Session session = getSession();
		
		return (Long) session.save(entity);
	}

	public <ENTITY extends IdentifiedEntityInterface> boolean delete(Class<ENTITY> clazz, Long id) {
		if(softDelete) {
			throw new UnsupportedOperationException("Physical delete operation forbidden");
		}
		
		if (id == null) {
			throw new IllegalArgumentException("Invalid value for entity ID provided:[NULL]");
		}
		
		if(!exists(clazz, id)) {
			// TODO add logging
			return false;
		}
		
		Session session = getSession();
		session.delete(session.load(clazz, id));
		return true;
	}
}
