package com.digitalwave.recrutatech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalwave.recrutatech.entity.Atitude;
import com.digitalwave.recrutatech.entity.Cha;
import com.digitalwave.recrutatech.entity.Conhecimento;
import com.digitalwave.recrutatech.entity.Habilidade;
import com.digitalwave.recrutatech.interfaces.IChaService;

@RestController
@RequestMapping(value = "/cha")
@CrossOrigin
public class ChaController {

	@Autowired
	private IChaService service;

	@GetMapping("/")
	public List<Cha> allCha() {
		return service.findAllCha();
	}

	@GetMapping(value = "/{id}")
	public Cha findId(@PathVariable("id") Long id) {
		return service.findChaId(id);
	}

	@PostMapping("/add")
	public Cha createCha(@RequestBody Cha cha) {
		Conhecimento conhecimento = cha.getConhecimento();
		Habilidade habilidade = cha.getHabilidade();
		Atitude atitude = cha.getAtitude();

		return service.createCha(conhecimento, habilidade, atitude);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Cha> updateCha(@PathVariable("id") long id, @RequestBody Cha updatedCha) {
		Cha updatedChaEntity = service.updateCha(id, updatedCha);
		if (updatedChaEntity != null) {
			return ResponseEntity.ok(updatedChaEntity);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCha(@PathVariable("id") long id) {
		service.deleteCha(id);
		return ResponseEntity.noContent().build();
	}

}
