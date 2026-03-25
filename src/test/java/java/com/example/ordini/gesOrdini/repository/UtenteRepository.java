package java.com.example.ordini.gesOrdini.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ordini.gesOrdini.model.Utenti;

public interface UtenteRepository extends JpaRepository<Utenti, Long>{

	Utenti findByUsernameAndPassword(String username, String password);

}
