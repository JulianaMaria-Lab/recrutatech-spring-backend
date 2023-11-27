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

import com.digitalwave.recrutatech.entity.Attitude;
import com.digitalwave.recrutatech.entity.Kaa;
import com.digitalwave.recrutatech.entity.Knowledge;
import com.digitalwave.recrutatech.interfaces.IKaaService;
import com.digitalwave.recrutatech.entity.Ability;

@RestController
@RequestMapping(value = "/kaa")
@CrossOrigin
public class KaaController {

	@Autowired
	private IKaaService service;

	@GetMapping("/")
	public List<Kaa> allKaa() {
		return service.findAllKaa();
	}

	@GetMapping(value = "/{id}")
	public Kaa findId(@PathVariable("id") Long id) {
		return service.findKaaId(id);
	}

	@PostMapping("/add")
	public Kaa createKaa(@RequestBody Kaa kaa) {
		Knowledge knowledge = kaa.getKnowledge();
		Ability ability = kaa.getAbility();
		Attitude attitude = kaa.getAttitude();

		return service.createKaa(knowledge, ability, attitude);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Kaa> updateKaa(@PathVariable("id") long id, @RequestBody Kaa updatedKaa) {
		Kaa updatedKaaEntity = service.updateKaa(id, updatedKaa);
		if (updatedKaaEntity != null) {
			return ResponseEntity.ok(updatedKaaEntity);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteKaa(@PathVariable("id") long id) {
		service.deleteKaa(id);
		return ResponseEntity.noContent().build();
	}

}
