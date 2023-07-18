package com.programacion.repository;

import java.util.List;

import com.programacion.repository.modelo.Horario;

public interface IHorarioRepository {

	public void insertar(Horario horario);

	public void actualizar(Horario horario);

	public void actualizarParcial(String cursoActual, String cursoNuevo);

	public Horario consultarPorId(Integer id);

	public Horario consultarPorNombre(String nombre);

	public List<Horario> consultarTodos();

	public void eliminar(Integer id);

}
