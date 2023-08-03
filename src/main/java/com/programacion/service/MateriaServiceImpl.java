package com.programacion.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programacion.repository.IMateriaRepository;
import com.programacion.repository.modelo.Materia;
import com.programacion.service.to.MateriaTO;

@Service
public class MateriaServiceImpl implements IMateriaService {

	@Autowired
	private IMateriaRepository materiaRepository;

	@Override
	public Materia buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.materiaRepository.buscarPorId(id);
	}

	@Override
	public Materia buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return this.materiaRepository.buscarPorNombre(nombre);
	}

	@Override
	public void registrarMateria(Materia materia) {
		// TODO Auto-generated method stub
		this.materiaRepository.insertar(materia);
	}

	@Override
	public void actualizar(Materia materia) {
		// TODO Auto-generated method stub
		this.materiaRepository.actualizar(materia);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.materiaRepository.borrar(id);
	}

	@Override
	public List<MateriaTO> buscarPorCedulaEstudiante(String cedula) {
		// TODO Auto-generated method stub
		return this.materiaRepository.buscarPorCedulaEstudiante(cedula).stream().map(mat -> this.convertir(mat))
				.collect(Collectors.toList());
	}

	@Override
	public List<MateriaTO> mostrarTodos() {
		// TODO Auto-generated method stub
//		return this.materiaRepository.buscarTodos().stream;
		return this.materiaRepository.mostrarTodos().stream().map(mat -> this.convertir(mat))
				.collect(Collectors.toList());
	}

	private MateriaTO convertir(Materia materia) {
		MateriaTO matTO = new MateriaTO();

		matTO.setId(materia.getId());
		matTO.setCreditos(materia.getCreditos());
		matTO.setNombre(materia.getNombre());

		return matTO;
	}

}
