package com.cabrera.clinica.domain.repositories;

import java.util.Collection;

public interface Repositorio<E, K> {
	E saveOrUpdate(E entity);
	E findById(K id);
	void remove(E e);
	Collection<E> findAll();
}
