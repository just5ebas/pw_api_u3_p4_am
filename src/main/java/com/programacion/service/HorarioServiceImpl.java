package com.programacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programacion.repository.IHorarioRepository;
import com.programacion.repository.modelo.Horario;

@Service
public class HorarioServiceImpl implements IHorarioService {

	@Autowired
	private IHorarioRepository horarioRepository;

	@Override
	public void guardar(Horario horario) {
		// TODO Auto-generated method stub
		this.horarioRepository.insertar(horario);
	}

	@Override
	public void actualizar(Horario horario) {
		// TODO Auto-generated method stub
		this.horarioRepository.actualizar(horario);
	}

	@Override
	public void actualizarParcial(Horario horario, String cursoNuevo) {
		// TODO Auto-generated method stub
		this.horarioRepository.actualizarParcial(horario.getCurso(), cursoNuevo);
	}

	@Override
	public Horario buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.horarioRepository.consultarPorId(id);
	}

	@Override
	public Horario buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return this.horarioRepository.consultarPorNombre(nombre);
	}

	@Override
	public List<Horario> buscarTodos() {
		// TODO Auto-generated method stub
		return this.horarioRepository.consultarTodos();
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.horarioRepository.eliminar(id);
	}

}
