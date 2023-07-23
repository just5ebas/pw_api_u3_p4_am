package com.programacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.programacion.repository.modelo.OrdenCobro;
import com.programacion.service.IOrdenCobroService;

@RestController
@RequestMapping(path = "/ordenes")
public class OrdenCobroControllerRestful {

	@Autowired
	private IOrdenCobroService cobroService;

	// GET
//	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<OrdenCobro> consultarPorId(@PathVariable Integer id) {
//		return ResponseEntity.status(HttpStatus.OK).body(this.cobroService.buscarPorId(id));
//	}

	@GetMapping(path = "/{numero}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OrdenCobro> consultarPorNumero(@PathVariable String numero) {
		return ResponseEntity.status(HttpStatus.OK).body(this.cobroService.buscarPorNumero(numero));
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<OrdenCobro>> consultarPorId() {
		return ResponseEntity.status(HttpStatus.OK).body(this.cobroService.buscarTodos());
	}

	// POST
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public void generar(@RequestBody OrdenCobro ordenCobro) {
		this.cobroService.generar(ordenCobro);
	}

	// PUT
	@PutMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void actualizar(@RequestBody OrdenCobro ordenCobro, @PathVariable Integer id) {
		ordenCobro.setId(id);
		this.cobroService.actualizar(ordenCobro);
	}

	// PATCH
	@PatchMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void actualizarParcial(@RequestBody OrdenCobro ordenCobro, @PathVariable Integer id) {
		OrdenCobro oc = this.cobroService.buscarPorId(id);
		this.cobroService.actualizarParcial(oc.getNumero(), ordenCobro.getNumero());
	}

	// DELETE
	@DeleteMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void eliminar(@PathVariable Integer id) {
		this.cobroService.eliminar(id);
	}

}
