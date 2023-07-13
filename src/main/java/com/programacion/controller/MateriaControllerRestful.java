package com.programacion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

	@PostMapping(path = "/generar")
	public void generarMateria(@RequestBody Materia materia) {
		this.materiaService.registrarMateria(materia);
	}

	@GetMapping(path = "buscar")
	public Materia buscarPorId() {
		Integer id = 1;
		return this.materiaService.buscarPorId(id);
	}

	@GetMapping(path = "buscarNombre")
	public Materia buscarPorNombre() {
		String nombre = "Programacion Web";
		return this.materiaService.buscarPorNombre(nombre);
	}

}
