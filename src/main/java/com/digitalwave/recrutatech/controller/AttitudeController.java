package com.digitalwave.recrutatech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	public List<Attitude> allAttitude(){
		return service.findAllAttitude();
	}
	
	@PostMapping("/add")
	public Attitude newAttitude(@RequestBody Attitude attitude) {
		return service.newAttitude(attitude);
	}

}
