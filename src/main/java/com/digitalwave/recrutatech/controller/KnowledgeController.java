package com.digitalwave.recrutatech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalwave.recrutatech.entity.Knowledge;
import com.digitalwave.recrutatech.interfaces.IKnowledgeService;

@RestController
@RequestMapping(value="/knoledge")
@CrossOrigin

public class KnowledgeController {
	@Autowired
	private IKnowledgeService service;
	
	@GetMapping("/")
	public List<Knowledge> allKnowledge(){
		return service.findAllKnowledge();
	}
	
	@PostMapping("/add")
	public Knowledge newKnowledge(@RequestBody Knowledge knowledge) {
		return service.newKnowledge(knowledge);
	}
	
}
