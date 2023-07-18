package com.programacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.programacion.repository.modelo.Horario;
import com.programacion.service.IHorarioService;

@RestController
@RequestMapping("/horarios")
public class HorarioControllerRestful {

	@Autowired
	private IHorarioService horarioService;

	// POST
	@PostMapping
	public void guardar(@RequestBody Horario horario) {
		this.horarioService.guardar(horario);
	}

	// PUT
	@PutMapping(path = "/{id}")
	public void actualizar(@RequestBody Horario horario, @PathVariable Integer id) {
		horario.setId(id);
		this.horarioService.actualizar(horario);
	}

	// PATCH
	@PatchMapping(path = "{id}")
	public void actualizarParcial(@RequestBody Horario horario, @PathVariable Integer id) {
		this.horarioService.actualizarParcial(this.horarioService.buscarPorId(id), horario.getCurso());
	}

	// GET
	@GetMapping
	public List<Horario> buscarTodos() {
		return this.horarioService.buscarTodos();
	}

	@GetMapping(path = "/{id}")
	public Horario buscarPorId(@PathVariable Integer id) {
		return this.horarioService.buscarPorId(id);
	}

//	@GetMapping(path = "/{nombre}")
//	public Horario buscarPorNombre(@PathVariable String nombre) {
//		return this.horarioService.buscarPorNombre(nombre);
//	}

	// DELETE
	@DeleteMapping(path = "/{id}")
	public void borrar(@PathVariable Integer id) {
		this.horarioService.eliminar(id);
	}

}
