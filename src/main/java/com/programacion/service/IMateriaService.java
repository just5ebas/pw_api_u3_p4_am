package com.programacion.service;

import com.programacion.repository.modelo.Materia;

public interface IMateriaService {

	public Materia buscarPorId(Integer id);

	public Materia buscarPorNombre(String nombre);

	public void registrarMateria(Materia materia);

}
