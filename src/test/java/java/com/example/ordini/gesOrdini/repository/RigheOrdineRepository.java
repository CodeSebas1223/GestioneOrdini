package java.com.example.ordini.gesOrdini.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ordini.gesOrdini.model.Ordini;
import com.example.ordini.gesOrdini.model.RigheOrdine;

public interface RigheOrdineRepository extends JpaRepository<RigheOrdine, Long>{

	List<RigheOrdine> findByOrdine(Ordini ordine);
}
