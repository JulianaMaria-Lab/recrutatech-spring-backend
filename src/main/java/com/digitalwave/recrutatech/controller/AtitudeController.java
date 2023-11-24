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

import com.digitalwave.recrutatech.entity.Atitude;
import com.digitalwave.recrutatech.interfaces.IAtitudeService;

@RestController
@RequestMapping(value="/ati")
@CrossOrigin
public class AtitudeController {
	
	@Autowired
	private IAtitudeService service;
	
	@GetMapping("/")
	public List<Atitude> allAtitude(){
		return service.findAllAtitude();
	}
	
	@PostMapping("/add")
	public Atitude newAtitude(@RequestBody Atitude atitude) {
		return service.newAtitude(atitude);
	}

	@PutMapping("/{id}")
    public ResponseEntity<Atitude> updateAtitude(@PathVariable("id") long id, @RequestBody Atitude updatedAtitude) {
        Atitude updatedAtitudeEntity = service.updateAtitude(id, updatedAtitude);
        if (updatedAtitudeEntity != null) {
            return ResponseEntity.ok(updatedAtitudeEntity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
