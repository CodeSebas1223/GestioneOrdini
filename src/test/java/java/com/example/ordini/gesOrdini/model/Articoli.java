package java.com.example.ordini.gesOrdini.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Articoli {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 
	 private Long id;
	 private String nome;
	 private double prezzo;
	 
	 public Articoli() {}
	 
	 public Articoli (Long id, String nome, double prezzo) {
		 this.id = id;
		 this.nome = nome;
		 this.prezzo = prezzo;
	 }

	 public Long getId() {
		 return id;
	 }

	 public void setId(Long id) {
		 this.id = id;
	 }

	 public String getNome() {
		 return nome;
	 }

	 public void setNome(String nome) {
		 this.nome = nome;
	 }

	 public double getPrezzo() {
		 return prezzo;
	 }

	 public void setPrezzo(double prezzo) {
		 this.prezzo = prezzo;
	 }
	 
	 
}
