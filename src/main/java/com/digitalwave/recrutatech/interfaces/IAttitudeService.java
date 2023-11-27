package com.digitalwave.recrutatech.interfaces;

import java.util.List;

import com.digitalwave.recrutatech.entity.Attitude;

public interface IAttitudeService {
	public Attitude newAtitude(Attitude attitude);
	
	public List<Attitude> findAllAtitude();
	
	public Attitude findAtitudeId (Long id);
	
    public Attitude updateAtitude(Long id, Attitude updatedAtitude);
    
    void deleteAtitude(Long id);

}
