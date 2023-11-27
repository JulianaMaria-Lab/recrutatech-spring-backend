package com.digitalwave.recrutatech.interfaces;

import java.util.List;

import com.digitalwave.recrutatech.entity.Attitude;
import com.digitalwave.recrutatech.entity.Kaa;
import com.digitalwave.recrutatech.entity.Knowledge;
import com.digitalwave.recrutatech.entity.Ability;

public interface IKaaService {
	public Kaa newKaa(Kaa kaa);

	public Kaa createKaa(Knowledge knowledge, Ability ability, Attitude attitude);
	
	public List<Kaa> findAllKaa();
	
	public Kaa findKaaId (Long id);
	
	public Kaa updateKaa(Long id, Kaa updateKaa);
	
	void deleteKaa (Long id);

	

}
