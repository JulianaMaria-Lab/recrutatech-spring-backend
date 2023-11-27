package com.digitalwave.recrutatech.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.digitalwave.recrutatech.entity.Attitude;
import com.digitalwave.recrutatech.interfaces.IAttitudeService;
import com.digitalwave.recrutatech.repository.AttitudeRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AttitudeService implements IAttitudeService {
	
	@Autowired
	private AttitudeRepository aRepo;
	
	@Override
	public Attitude newAtitude(Attitude attitude) {
		return aRepo.save(attitude);
	}

	public List<Attitude> findAllAtitude(){
		return aRepo.findAll();
	}
	
    public Attitude findAtitudeId(Long id) {
        Optional<Attitude> aOp = aRepo.findById(id);
        if(aOp.isEmpty()) {
            throw new IllegalArgumentException("Atitude não encontrada!");
        }
        return aOp.get();
    }
    
    @Override
    public Attitude updateAtitude(Long id, Attitude updateAtitude) {
        Optional<Attitude> aOp = aRepo.findById(id);

        if (aOp.isPresent()) {
        	Attitude existingAtitude = aOp.get();

            if (!ObjectUtils.isEmpty(updateAtitude.getContent())) {
            	existingAtitude.setContent(updateAtitude.getContent());
            }

            return aRepo.save(existingAtitude);
        } else {
            throw new EntityNotFoundException("Atitude não encontrada - ID: " + id);
        }
    }
    
	public void deleteAtitude(Long id) {
		aRepo.deleteById(id);
	}

}
