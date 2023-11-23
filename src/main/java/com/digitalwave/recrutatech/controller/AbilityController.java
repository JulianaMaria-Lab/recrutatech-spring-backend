package com.digitalwave.recrutatech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	public List<Ability> allAbility(){
		return service.findAllAbility();
	}
	
	@PostMapping("/add")
	public Ability newAbility(@RequestBody Ability ability) {
		return service.newAbility(ability);
	}

}
