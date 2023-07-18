package com.programacion.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.programacion.repository.modelo.Horario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HorarioRepositoryImpl implements IHorarioRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Horario horario) {
		// TODO Auto-generated method stub
		this.entityManager.persist(horario);
	}

	@Override
	public void actualizar(Horario horario) {
		// TODO Auto-generated method stub
		this.entityManager.merge(horario);
	}

	@Override
	public void actualizarParcial(String cursoActual, String cursoNuevo) {
		// TODO Auto-generated method stub
		Query query = this.entityManager
				.createQuery("UPDATE Horario h SET h.curso = :datoNuevo WHERE h.curso = :datoActual");
		query.setParameter("datoNuevo", cursoNuevo);
		query.setParameter("datoActual", cursoActual);
		query.executeUpdate();
	}

	@Override
	public Horario consultarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Horario.class, id);
	}

	@Override
	public Horario consultarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		TypedQuery<Horario> query = this.entityManager.createQuery("SELECT h FROM Horario h WHERE h.nombre = :nombre",
				Horario.class);
		query.setParameter("nombre", nombre);
		return query.getSingleResult();
	}

	@Override
	public List<Horario> consultarTodos() {
		// TODO Auto-generated method stub
		TypedQuery<Horario> query = this.entityManager.createQuery("SELECT h FROM Horario h", Horario.class);
		return query.getResultList();
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.consultarPorId(id));
	}

}
