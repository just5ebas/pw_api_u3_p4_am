package com.programacion.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.programacion.repository.modelo.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MateriaRepositoryImpl implements IMateriaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Materia buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Materia.class, id);
	}

	@Override
	public Materia buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		TypedQuery<Materia> myQuery = this.entityManager.createQuery("SELECT m FROM Materia m WHERE m.nombre = :nombre",
				Materia.class);
		myQuery.setParameter("nombre", nombre);
		return myQuery.getSingleResult();
	}

	@Override
	public void insertar(Materia materia) {
		// TODO Auto-generated method stub
		this.entityManager.persist(materia);
	}

	@Override
	public void actualizar(Materia materia) {
		// TODO Auto-generated method stub
		this.entityManager.merge(materia);
	}

	@Override
	public void actualizadoParcial(String nombreActual, String nombreNuevo) {
		// TODO Auto-generated method stub
		Query query = this.entityManager
				.createQuery("UPDATE Materia m SET m.nombre = :datoNuevo WHERE m.nombre = :datoActual");
		query.setParameter("datoNuevo", nombreNuevo);
		query.setParameter("datoActual", nombreActual);
		query.executeUpdate();
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscarPorId(id));
	}

	@Override
	public List<Materia> mostrarTodos() {
		// TODO Auto-generated method stub
		TypedQuery<Materia> query = this.entityManager.createQuery("SELECT m FROM Materia m", Materia.class);
		return query.getResultList();
	}

	@Override
	public List<Materia> buscarPorCedulaEstudiante(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Materia> myQ = this.entityManager
				.createQuery("SELECT m FROM Materia m WHERE m.estudiante.cedula =: datoEstudiante", Materia.class);
		myQ.setParameter("datoEstudiante", cedula);
		return myQ.getResultList();
	}

}
