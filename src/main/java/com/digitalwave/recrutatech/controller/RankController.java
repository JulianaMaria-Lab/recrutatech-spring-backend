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
	public Rank newRank(@RequestBody Rank rank) {
		return service.newRank(rank);
	}
	
    @PutMapping("/{id}")
    public ResponseEntity<Rank> updateRank(@PathVariable("id") long id, @RequestBody Rank updatedRank) {
    	Rank updatedRankEntity = service.updateRank(id, updatedRank);
        if (updatedRankEntity != null) {
            return ResponseEntity.ok(updatedRankEntity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRank(@PathVariable("id") long id) {
        service.deleteRank(id);
        return ResponseEntity.noContent().build();
    }

}
