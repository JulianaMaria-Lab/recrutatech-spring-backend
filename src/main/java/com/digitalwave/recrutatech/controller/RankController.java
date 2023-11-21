package com.digitalwave.recrutatech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalwave.recrutatech.entity.Rank;
import com.digitalwave.recrutatech.interfaces.IRankService;

@RestController
@RequestMapping(value="/rank")
@CrossOrigin
public class RankController {
	
	@Autowired
	private IRankService service;
	
	@GetMapping("/")
	public List<Rank> allRank(){
		return service.findAllRank();
	}
	
	@PostMapping("/add")
	public Rank newAtitude(@RequestBody Rank rank) {
		return service.newRank(rank);
	}

}
