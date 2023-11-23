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

import com.digitalwave.recrutatech.entity.Ability;
import com.digitalwave.recrutatech.entity.Attitude;
import com.digitalwave.recrutatech.entity.KAA;
import com.digitalwave.recrutatech.entity.Knowledge;
import com.digitalwave.recrutatech.interfaces.IKAAService;

@RestController
@RequestMapping(value="/kaa")
@CrossOrigin
public class KAAController {
	
	@Autowired
	private IKAAService service;
	
	@GetMapping("/")
	public List<KAA> allKAA(){
		return service.findAllKAA();
	}
	
	@GetMapping (value="/{id}")
	public KAA findId (@PathVariable("id") Long id) {
		return service.findKAAId(id);
	}
	
	@PostMapping("/add")
	public KAA createKAA(@RequestBody KAA kaa) {
    Knowledge knowledge = kaa.getKnowledge();
    Ability ability = kaa.getAbility();
    Attitude attitude = kaa.getAttitude();

    return service.createKAA(knowledge, ability, attitude);
	}
	
  @PutMapping("/{id}")
  public ResponseEntity<KAA> updateKAA(@PathVariable("id") long id, @RequestBody KAA updatedKAA) {
      KAA updatedKAAEntity = service.updateKAA(id, updatedKAA);
      if (updatedKAAEntity != null) {
          return ResponseEntity.ok(updatedKAAEntity);
      } else {
          return ResponseEntity.notFound().build();
      }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteKAA(@PathVariable("id") long id) {
    service.deleteKAA(id);
    return ResponseEntity.noContent().build();
  }

}
