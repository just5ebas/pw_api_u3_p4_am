package com.programacion.service;

import java.util.List;

import com.programacion.repository.modelo.OrdenCobro;

public interface IOrdenCobroService {

	public void generar(OrdenCobro ordenCobro);

	public void actualizar(OrdenCobro ordenCobro);

	public void actualizarParcial(String numeroActual, String numeroNuevo);

	public OrdenCobro buscarPorId(Integer id);

	public OrdenCobro buscarPorNumero(String numero);

	public List<OrdenCobro> buscarTodos();

	public void eliminar(Integer id);

}
