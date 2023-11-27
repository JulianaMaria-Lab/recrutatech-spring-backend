package com.digitalwave.recrutatech.interfaces;

import java.util.List;
import com.digitalwave.recrutatech.entity.Knowledge;
import com.digitalwave.recrutatech.interfaces.IKnowledgeService;

public interface IKnowledgeService {
	public Knowledge newKnowledge(Knowledge knowledge);
	
	public List<Knowledge> findAllKnowledge();
	
	public Knowledge findKnowledgeId (Long id);
	
    public Knowledge updateKnowledge(Long id, Knowledge updatedKnowledge);
    
    void deleteKnowledge(Long id);

}
