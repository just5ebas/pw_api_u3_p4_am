package com.programacion.service;

import java.util.List;

import com.programacion.repository.modelo.Materia;

public interface IMateriaService {

	public Materia buscarPorId(Integer id);

	public Materia buscarPorNombre(String nombre);

	public void registrarMateria(Materia materia);

	public void actualizar(Materia materia);

	public void borrar(Integer id);

	public List<Materia> mostrarTodos();

}
