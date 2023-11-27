package com.digitalwave.recrutatech.interfaces;

import java.util.List;

import com.digitalwave.recrutatech.entity.Ability;

public interface IAbilityService {
	public Ability newHabilidade(Ability ability);
	
	public List<Ability> findAllHabilidade();
	
	public Ability findHabilidadeId (Long id);
	
    public Ability updateHabilidade(Long id, Ability updatedHabilidade);
    
    void deleteHabilidade(Long id);

}
