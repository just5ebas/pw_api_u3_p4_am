package com.programacion.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "orden_cobro")
public class OrdenCobro {

	@Id
	@Column(name = "orco_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orco_id_seq")
	@SequenceGenerator(name = "orco_id_seq", sequenceName = "orco_id_seq", allocationSize = 1)
	private Integer id;

	@Column(name = "orco_numero")
	private String numero;

	@Column(name = "orco_costo_total")
	private BigDecimal costoTotal;

	@Column(name = "orco_fecha_emision")
	private LocalDateTime fechaEmision;

	// GET & SET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public BigDecimal getCostoTotal() {
		return costoTotal;
	}

	public void setCostoTotal(BigDecimal costoTotal) {
		this.costoTotal = costoTotal;
	}

	public LocalDateTime getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(LocalDateTime fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

}
