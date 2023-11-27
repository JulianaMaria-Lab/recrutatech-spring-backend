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

import com.digitalwave.recrutatech.entity.Attitude;
import com.digitalwave.recrutatech.interfaces.IAttitudeService;

@RestController
@RequestMapping(value="/attitude")
@CrossOrigin
public class AttitudeController {
	
	@Autowired
	private IAttitudeService service;
	
	@GetMapping("/")
	public List<Attitude> allAtitude(){
		return service.findAllAtitude();
	}
	
	@PostMapping("/add")
	public Attitude newAtitude(@RequestBody Attitude attitude) {
		return service.newAtitude(attitude);
	}

	@PutMapping("/{id}")
    public ResponseEntity<Attitude> updateAtitude(@PathVariable("id") long id, @RequestBody Attitude updatedAtitude) {
        Attitude updatedAtitudeEntity = service.updateAtitude(id, updatedAtitude);
        if (updatedAtitudeEntity != null) {
            return ResponseEntity.ok(updatedAtitudeEntity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
