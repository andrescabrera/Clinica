package com.cabrera.clinica.infraestructure.data;

import java.util.Collection;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cabrera.clinica.domain.Area;
import com.cabrera.clinica.domain.repositories.RepositorioDeAreas;

@Repository
public class RepositorioDeAreasJPA extends BaseRepositoryJPA<Area, Long> implements RepositorioDeAreas {

	private static final String sqlDeleteAreas = "DELETE FROM area";
	private static final String sqlSelectAreas = "SELECT a FROM area a";
		
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Collection<Area> findAll() {
		Query q = entityManager.createQuery(sqlSelectAreas);
		return q.getResultList();
	}

	public void removeAll() {
		Query q = entityManager.createQuery(sqlDeleteAreas);
		q.executeUpdate();
	}
}
