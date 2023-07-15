package com.programacion.repository;

import java.util.List;

import com.programacion.repository.modelo.Materia;

public interface IMateriaRepository {

	public Materia buscarPorId(Integer id);

	public Materia buscarPorNombre(String nombre);

	public void insertar(Materia materia);
	
	public void actualizar(Materia materia);
	
	public void actualizadoParcial(String nombreActual, String nombreNuevo);
	
	public void borrar(Integer id);
	
	public List<Materia> buscarTodos();

}
