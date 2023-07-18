package com.programacion.service;

import java.util.List;

import com.programacion.repository.modelo.Horario;

public interface IHorarioService {
	
	public void guardar(Horario horario);

	public void actualizar(Horario horario);

	public void actualizarParcial(Horario horario, String cursoNuevo);

	public Horario buscarPorId(Integer id);

	public Horario buscarPorNombre(String nombre);

	public List<Horario> buscarTodos();

	public void eliminar(Integer id);
	
}
