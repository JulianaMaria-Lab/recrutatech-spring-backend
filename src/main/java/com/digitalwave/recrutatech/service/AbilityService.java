package com.digitalwave.recrutatech.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.digitalwave.recrutatech.entity.Ability;
import com.digitalwave.recrutatech.interfaces.IAbilityService;
import com.digitalwave.recrutatech.repository.AbilityRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AbilityService implements IAbilityService {
	
	@Autowired
	private AbilityRepository hRepo;
	
	@Override
	public Ability newHabilidade(Ability ability) {
		return hRepo.save(ability);
	}

	public List<Ability> findAllHabilidade(){
		return hRepo.findAll();
	}
	
    public Ability findHabilidadeId(Long id) {
        Optional<Ability> hOp = hRepo.findById(id);
        if(hOp.isEmpty()) {
            throw new IllegalArgumentException("Habilidade não encontrada!");
        }
        return hOp.get();
    }
    
    @Override
    public Ability updateHabilidade(Long id, Ability updateHabilidade) {
        Optional<Ability> hOp = hRepo.findById(id);

        if (hOp.isPresent()) {
        	Ability existingHabilidade = hOp.get();

            if (!ObjectUtils.isEmpty(updateHabilidade.getContent())) {
            	existingHabilidade.setContent(updateHabilidade.getContent());
            }

            return hRepo.save(existingHabilidade);
        } else {
            throw new EntityNotFoundException("Habilidade não encontrada - ID: " + id);
        }
    }
    
	public void deleteHabilidade(Long id) {
		hRepo.deleteById(id);
	}

}
