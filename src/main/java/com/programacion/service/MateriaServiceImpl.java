package com.programacion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programacion.repository.IMateriaRepository;
import com.programacion.repository.modelo.Materia;

@Service
public class MateriaServiceImpl implements IMateriaService {

	@Autowired
	private IMateriaRepository materiaRepository;

	@Override
	public Materia buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.materiaRepository.consultarPorId(id);
	}

	@Override
	public Materia buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return this.materiaRepository.consultarPorNombre(nombre);
	}

	@Override
	public void registrarMateria(Materia materia) {
		// TODO Auto-generated method stub
		this.materiaRepository.insertar(materia);
	}

}
