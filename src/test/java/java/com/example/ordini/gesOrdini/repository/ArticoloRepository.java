package java.com.example.ordini.gesOrdini.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ordini.gesOrdini.model.Articoli;

public interface ArticoloRepository extends JpaRepository<Articoli, Long>{

}
