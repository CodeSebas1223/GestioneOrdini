package com.example.ordini.gesOrdini.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class OrdineForm {
	
	@NotBlank
	private String nomeCliente;
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate data;

	private Long articoloId;
	private Integer quantita;
	
	public OrdineForm() {}

	public OrdineForm(String nomeCliente, LocalDate data, Long articoloId, Integer quantita) {
	
	this.nomeCliente = nomeCliente;
	this.data = data;
	this.articoloId = articoloId;
	this.quantita = quantita;
	
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Long getArticoloId() {
		return articoloId;
	}

	public void setArticoloId(Long articoloId) {
		this.articoloId = articoloId;
	}

	public Integer getQuantita() {
		return quantita;
	}

	public void setQuantita(Integer quantita) {
		this.quantita = quantita;
	}

    
}
