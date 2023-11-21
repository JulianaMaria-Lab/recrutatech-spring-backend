package com.digitalwave.recrutatech.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.digitalwave.recrutatech.entity.Rank;
import com.digitalwave.recrutatech.repository.RankRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class RankService {
	
	@Autowired
	private RankRepository rankRepo;
	
	public Rank newRank(Rank rank) {
		return rankRepo.save(rank);
	}

	public List<Rank> findAllRank(){
		return rankRepo.findAll();
	}
	
    public Rank findRankId(Long id) {
        Optional<Rank> rOp = rankRepo.findById(id);
        if(rOp.isEmpty()) {
            throw new IllegalArgumentException("Rank não encontrado!");
        }
        return rOp.get();
    }
    
    public Rank updateRank(Long id, Rank updateRank) {
        Optional<Rank> rOp = rankRepo.findById(id);

        if (rOp.isPresent()) {
        	Rank existingRank = rOp.get();

            if (!ObjectUtils.isEmpty(updateRank.getValue())) {
            	existingRank.setValue(updateRank.getValue());
            }

            return rankRepo.save(existingRank);
        } else {
            throw new EntityNotFoundException("Rank não encontrado - ID: " + id);
        }
    }
    
	public void deleteRank(Long id) {
		rankRepo.deleteById(id);
	}


}
