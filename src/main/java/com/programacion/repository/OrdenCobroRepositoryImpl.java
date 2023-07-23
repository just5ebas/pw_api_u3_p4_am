package com.programacion.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.programacion.repository.modelo.OrdenCobro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class OrdenCobroRepositoryImpl implements IOrdenCobroRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(OrdenCobro ordenCobro) {
		// TODO Auto-generated method stub
		this.entityManager.persist(ordenCobro);
	}

	@Override
	public void actualizar(OrdenCobro ordenCobro) {
		// TODO Auto-generated method stub
		this.entityManager.merge(ordenCobro);
	}

	@Override
	public void actualizarParcial(String numeroActual, String numeroNuevo) {
		// TODO Auto-generated method stub
		Query query = this.entityManager
				.createQuery("UPDATE OrdenCobro oc SET oc.numero = :numeroNuevo WHERE oc.numero = :numeroActual");
		query.setParameter("numeroNuevo", numeroNuevo);
		query.setParameter("numeroActual", numeroActual);
		query.executeUpdate();
	}

	@Override
	public OrdenCobro consultarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(OrdenCobro.class, id);
	}

	@Override
	public OrdenCobro consultarPorNumero(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<OrdenCobro> query = this.entityManager
				.createQuery("SELECT oc FROM OrdenCobro oc WHERE oc.numero = :numero", OrdenCobro.class);
		query.setParameter("numero", numero);
		return query.getSingleResult();
	}

	@Override
	public List<OrdenCobro> consultarTodos() {
		// TODO Auto-generated method stub
		TypedQuery<OrdenCobro> query = this.entityManager.createQuery("SELECT oc FROM OrdenCobro oc", OrdenCobro.class);
		return query.getResultList();
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.consultarPorId(id));
	}

}
