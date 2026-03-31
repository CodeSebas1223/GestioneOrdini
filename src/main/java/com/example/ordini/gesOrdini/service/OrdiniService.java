package com.example.ordini.gesOrdini.service;

import java.util.List;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ordini.gesOrdini.dto.OrdineForm;
import com.example.ordini.gesOrdini.model.Articoli;
import com.example.ordini.gesOrdini.model.Ordini;
import com.example.ordini.gesOrdini.model.RigheOrdine;
import com.example.ordini.gesOrdini.model.Utenti;
import com.example.ordini.gesOrdini.repository.ArticoloRepository;
import com.example.ordini.gesOrdini.repository.OrdiniRepository;
import com.example.ordini.gesOrdini.repository.RigheOrdineRepository;
import com.example.ordini.gesOrdini.repository.UtenteRepository;

@Service
public class OrdiniService {

    @Autowired
    private OrdiniRepository ordineRepository;

    @Autowired
    private ArticoloRepository articoloRepository;

    @Autowired
    private RigheOrdineRepository rigaRepository;
    
    @Autowired
    private UtenteRepository utenteRepository;


    public List<Ordini> listaOrdini(Utenti utente){
        return ordineRepository.findByUtente(utente);
    }

    public void creaOrdine(OrdineForm form, Utenti utente){

        if(form.getQuantita() <= 0){
            throw new RuntimeException("Quantità non valida");
        }

        Ordini ordine = new Ordini();
        ordine.setNomeCliente(form.getNomeCliente());
        ordine.setData(form.getData());
        ordine.setUtente(utente);

        ordineRepository.save(ordine);

        Articoli articolo = articoloRepository
                .findById(form.getArticoloId())
                .orElseThrow();

        RigheOrdine riga = new RigheOrdine();
        riga.setOrdine(ordine);
        riga.setArticolo(articolo);
        riga.setQuantita(form.getQuantita());
        riga.setPrezzo(articolo.getPrezzo());

        rigaRepository.save(riga);
    }
    
    
    public List<RigheOrdine> listaRigheOrdine(Ordini ordine){
    	  return rigaRepository.findByOrdine(ordine);
    }
    
    public Ordini trovaOrdinePerId(Long id) {
    	  return ordineRepository.findById(id).orElseThrow();
    }
    
    public double calcolaTotale(List<RigheOrdine> righe) {
    	
    	return righe.stream().mapToDouble(r -> r.getQuantita() * r.getPrezzo()).sum();
    	
    }
    
    }