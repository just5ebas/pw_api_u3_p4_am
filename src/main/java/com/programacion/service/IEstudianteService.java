package com.programacion.service;

import java.util.List;

import com.programacion.repository.modelo.Estudiante;
import com.programacion.service.to.EstudianteTO;

public interface IEstudianteService {

	public Estudiante consultarPorCedula(String cedula);

	public void guardar(Estudiante estudiante);

	public void actualizar(Estudiante estudiante);

	public void actualizarParcial(String cedulaActual, String cedulaNueva);

	public void borrar(Integer id);

	public Estudiante buscarPorId(Integer id);

	public List<Estudiante> mostrarTodos(String provincia);
	
	public List<EstudianteTO> buscarTodos();
	
	public Integer guardarConRetorno(Estudiante estudiante);

}
