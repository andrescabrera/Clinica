package com.cabrera.clinica.infraestructure.data;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cabrera.clinica.domain.repositories.Repositorio;

@Repository
public abstract class BaseRepositoryJPA<E, K> implements Repositorio<E, K>{

	protected Class<E> entityClass;
	 
	@PersistenceContext
	protected EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public BaseRepositoryJPA () {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[0];
	}
	
	@Override
	@Transactional
	public void remove(E t) {
		entityManager.remove(t);
	}
		
	@Override
	@Transactional
	public E saveOrUpdate(E t) {
		return entityManager.merge(t);
	}
	
	@Override
	@Transactional
	public void persist(E t) {
		entityManager.persist(t);
	}

	@Override
	public E findById(K id) {
		return entityManager.find(entityClass, id);
	}
	
}
