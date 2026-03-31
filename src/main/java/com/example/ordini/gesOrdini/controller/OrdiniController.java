package com.example.ordini.gesOrdini.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.ordini.gesOrdini.dto.OrdineForm;
import com.example.ordini.gesOrdini.model.Ordini;
import com.example.ordini.gesOrdini.model.RigheOrdine;
import com.example.ordini.gesOrdini.model.Utenti;
import com.example.ordini.gesOrdini.repository.ArticoloRepository;
import com.example.ordini.gesOrdini.service.OrdiniService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class OrdiniController {

    @Autowired
    private OrdiniService service;
    
    @GetMapping("/ordini")
    public String listaOrdini(Model model, HttpSession session){

        Utenti utente = (Utenti) session.getAttribute("utente");
        
        if(utente == null) {
        	 return "redirect:/login";
        }
                
        List<Ordini> ordini = service.listaOrdini(utente);

        model.addAttribute("ordini", ordini);

        return "lista-ordini";
    }
    
    @Autowired
    private ArticoloRepository articoloRepository;
    
    @GetMapping("/ordini/nuovo")
    public String formNuovoOrdine(Model model) {
    	
    	  model.addAttribute("articoli", articoloRepository.findAll());
    	
    	  return "nuovo-ordine";
    }

    @PostMapping("/ordini/nuovo")
    public String nuovoOrdine(@Valid OrdineForm form, BindingResult result, HttpSession session){
 
    	 if(result.hasErrors()) {
    		 return "nuovo-ordine";
    	 }
    	
        Utenti utente = (Utenti) session.getAttribute("utente");

        System.out.println("utente in sessione: " + utente);
        
        service.creaOrdine(form, utente);

        return "redirect:/ordini";
    }
    
    @GetMapping("/ordini/{id}")
    public String dettaglioOrdine(@PathVariable Long id, Model model) {
    	
    	Ordini ordine = 	service.trovaOrdinePerId(id);
    	
    	List<RigheOrdine> righe = service.listaRigheOrdine(ordine);
    	
    	double totale = service.calcolaTotale(righe);
    	
    	model.addAttribute("ordine", ordine);
    	model.addAttribute("righe", righe);
    	model.addAttribute("totale", totale);
    	
    	return "dettaglio-ordine";
    	}
    
    
}
