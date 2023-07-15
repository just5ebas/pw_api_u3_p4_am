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

import com.programacion.repository.modelo.Materia;
import com.programacion.service.IMateriaService;

@RestController
@RequestMapping("/materias")
public class MateriaControllerRestful {

	@Autowired
	private IMateriaService materiaService;

	// POST
	@PostMapping(path = "/generar")
	public void generarMateria(@RequestBody Materia materia) {
		this.materiaService.registrarMateria(materia);
	}

	// GET
	@GetMapping(path = "buscar/{id}")
	public Materia buscarPorId(@PathVariable Integer id) {
		return this.materiaService.buscarPorId(id);
	}

	@GetMapping(path = "buscarNombre/{nombre}")
	public Materia buscarPorNombre(@PathVariable String nombre) {
		return this.materiaService.buscarPorNombre(nombre);
	}

	@GetMapping(path = "/buscarTodos")
	public List<Materia> buscarTodos() {
		return this.materiaService.mostrarTodos();
	}

	// PUT
	@PutMapping(path = "/actualizar/{id}")
	public void actualizar(@RequestBody Materia materia, @PathVariable Integer id) {
		materia.setId(id);
		this.materiaService.actualizar(materia);
	}

	// PATCH
	@PatchMapping(path = "/actualizarParcial/{id}")
	public void actualizarParcial(@RequestBody Materia materia, @PathVariable Integer id) {
		Materia materia2 = this.materiaService.buscarPorId(id);
		materia2.setNombre(materia.getNombre());
		this.materiaService.actualizar(materia2);
	}

	// DELETE
	@DeleteMapping(path = "/borrar/{id}")
	public void borrar(@PathVariable Integer id) {
		this.materiaService.borrar(id);
	}

}
