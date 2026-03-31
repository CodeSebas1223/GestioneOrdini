package com.example.ordini.gesOrdini.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ordini.gesOrdini.model.Ordini;
import com.example.ordini.gesOrdini.model.Utenti;

public interface OrdiniRepository extends JpaRepository<Ordini, Long>{

    List<Ordini> findByUtente(Utenti utente);

}