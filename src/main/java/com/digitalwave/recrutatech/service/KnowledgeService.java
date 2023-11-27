package com.digitalwave.recrutatech.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.digitalwave.recrutatech.entity.Knowledge;
import com.digitalwave.recrutatech.interfaces.IKnowledgeService;
import com.digitalwave.recrutatech.repository.KnowledgeRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class KnowledgeService implements IKnowledgeService {
	
	@Autowired
	private KnowledgeRepository cRepo;
	
	@Override
	public Knowledge newKnowledge(Knowledge knowledge) {
		return cRepo.save(knowledge);
	}

	public List<Knowledge> findAllKnowledge(){
		return cRepo.findAll();
	}
	
    public Knowledge findKnowledgeId(Long id) {
        Optional<Knowledge> cOp = cRepo.findById(id);
        if(cOp.isEmpty()) {
            throw new IllegalArgumentException("Knowledge não encontrado!");
        }
        return cOp.get();
    }
    
    @Override
    public Knowledge updateKnowledge(Long id, Knowledge updateKnowledge) {
        Optional<Knowledge> cOp = cRepo.findById(id);

        if (cOp.isPresent()) {
        	Knowledge existingKnowledge = cOp.get();

            if (!ObjectUtils.isEmpty(updateKnowledge.getContent())) {
            	existingKnowledge.setContent(updateKnowledge.getContent());
            }

            return cRepo.save(existingKnowledge);
        } else {
            throw new EntityNotFoundException("Knowledge não encontrado - ID: " + id);
        }
    }
    
	public void deleteKnowledge(Long id) {
		cRepo.deleteById(id);
	}

}
