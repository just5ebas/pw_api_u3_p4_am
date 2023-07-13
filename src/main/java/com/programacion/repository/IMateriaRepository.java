package com.programacion.repository;

import com.programacion.repository.modelo.Materia;

public interface IMateriaRepository {

	public Materia consultarPorId(Integer id);

	public Materia consultarPorNombre(String nombre);

	public void insertar(Materia materia);

}
