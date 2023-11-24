package com.digitalwave.recrutatech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalwave.recrutatech.entity.Conhecimento;
import com.digitalwave.recrutatech.interfaces.IConhecimentoService;

@RestController
@RequestMapping(value="/con")
@CrossOrigin

public class ConhecimentoController {
	@Autowired
	private IConhecimentoService service;
	
	@GetMapping("/")
	public List<Conhecimento> allConhecimento(){
		return service.findAllConhecimento();
	}
	
	@PostMapping("/add")
	public Conhecimento newConhecimento(@RequestBody Conhecimento conhecimento) {
		return service.newConhecimento(conhecimento);
	}

	@PutMapping("/{id}")
    public ResponseEntity<Conhecimento> updateConhecimento(@PathVariable("id") long id, @RequestBody Conhecimento updatedConhecimento) {
        Conhecimento updatedConhecimentoEntity = service.updateConhecimento(id, updatedConhecimento);
        if (updatedConhecimentoEntity != null) {
            return ResponseEntity.ok(updatedConhecimentoEntity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
