package com.example.ordini.gesOrdini.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class RigheOrdine {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private Ordini ordine;
	
	@ManyToOne
	private Articoli articolo;
	
	private int quantita;
	private double prezzo;
	
	public RigheOrdine() {}
		
	public RigheOrdine(Long id, Ordini ordine, Articoli articolo, int quantita, double prezzo) {
		this.id = id;
		this.ordine = ordine;
		this.articolo = articolo;
		this.quantita = quantita;
		this.prezzo = prezzo;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Ordini getOrdine() {
		return ordine;
	}

	public void setOrdine(Ordini ordine) {
		this.ordine = ordine;
	}

	public Articoli getArticolo() {
		return articolo;
	}

	public void setArticolo(Articoli articolo) {
		this.articolo = articolo;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
	
}
