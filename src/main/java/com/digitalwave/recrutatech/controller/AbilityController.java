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

import com.digitalwave.recrutatech.entity.Ability;
import com.digitalwave.recrutatech.interfaces.IAbilityService;

@RestController
@RequestMapping(value="/ability")
@CrossOrigin
public class AbilityController {
	@Autowired
	private IAbilityService service;
	
	@GetMapping("/")
	public List<Ability> allHabilidade(){
		return service.findAllHabilidade();
	}
	
	@PostMapping("/add")
	public Ability newHabilidade(@RequestBody Ability ability) {
		return service.newHabilidade(ability);
	}

	@PutMapping("/{id}")
    public ResponseEntity<Ability> updateHabilidade(@PathVariable("id") long id, @RequestBody Ability updatedHabilidade) {
        Ability updatedhabilidadeEntity = service.updateHabilidade(id, updatedHabilidade);
        if (updatedhabilidadeEntity != null) {
            return ResponseEntity.ok(updatedhabilidadeEntity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
