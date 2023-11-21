package com.digitalwave.recrutatech.interfaces;

import java.util.List;

import com.digitalwave.recrutatech.entity.Rank;

public interface IRankService {
	public Rank newRank(Rank rank);
	
	public List<Rank> findAllRank();
	
	public Rank findRankId (Long id);
	
    public Rank updateRank(Long id, Rank updatedRank);
    
    void deleteRank(Long id);

}
