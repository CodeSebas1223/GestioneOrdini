package java.com.example.ordini.gesOrdini.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ordini.gesOrdini.model.Utenti;
import com.example.ordini.gesOrdini.repository.UtenteRepository;

@Service
public class LoginService {
	
	@Autowired
	private UtenteRepository repository;
	
	public Utenti login(String username, String password) {

	    System.out.println("INPUT username: [" + username + "]");
	    System.out.println("INPUT password: [" + password + "]");

	    return repository.findByUsernameAndPassword(username, password);
	}
   

}
