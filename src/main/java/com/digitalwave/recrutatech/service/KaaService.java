package com.digitalwave.recrutatech.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.digitalwave.recrutatech.entity.Attitude;
import com.digitalwave.recrutatech.entity.Kaa;
import com.digitalwave.recrutatech.entity.Knowledge;
import com.digitalwave.recrutatech.entity.Ability;
import com.digitalwave.recrutatech.interfaces.IKaaService;
import com.digitalwave.recrutatech.repository.AttitudeRepository;
import com.digitalwave.recrutatech.repository.KaaRepository;
import com.digitalwave.recrutatech.repository.KnowledgeRepository;
import com.digitalwave.recrutatech.repository.AbilityRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class KaaService implements IKaaService {
    @Autowired
    private KaaRepository KaaRepo;
    @Autowired
    private KnowledgeRepository cRepo;
    @Autowired
    private AbilityRepository hRepo;
    @Autowired
    private AttitudeRepository aRepo;

    public Kaa createKaa(Knowledge knowledge, Ability ability, Attitude attitude) {
        Kaa kaa = new Kaa();
        kaa.setKnowledge(knowledge);
        kaa.setAbility(ability);
        kaa.setAttitude(attitude);
        return KaaRepo.save(kaa);
    }

    @Override
    public Kaa newKaa(Kaa kaa) {
        Long KnowledgeId = kaa.getKnowledge().getId();
        Knowledge knowledge = cRepo.findById(KnowledgeId)
                .orElseThrow();
        kaa.setKnowledge(knowledge);

        Long AbilityId = kaa.getAbility().getId();
        Ability ability = hRepo.findById(AbilityId)
                .orElseThrow();
        kaa.setAbility(ability);

        Long AttitudeId = kaa.getAttitude().getId();
        Attitude attitude = aRepo.findById(AttitudeId)
                .orElseThrow();
        kaa.setAttitude(attitude);

        return KaaRepo.save(kaa);
    }

    public List<Kaa> findAllKaa() {
        return KaaRepo.findAll();
    }

    public Kaa findKaaId(Long id) {
        Optional<Kaa> KaaOp = KaaRepo.findById(id);
        if (KaaOp.isEmpty()) {
            throw new IllegalArgumentException("Kaa não encontrado!");
        }
        return KaaOp.get();
    }

    @Override
    public Kaa updateKaa(Long id, Kaa updateKaa) {
        Optional<Kaa> KaaOp = KaaRepo.findById(id);

        if (KaaOp.isPresent()) {
            Kaa existingKaa = KaaOp.get();

            if (!ObjectUtils.isEmpty(updateKaa.getKnowledge())) {
                existingKaa.setKnowledge(updateKaa.getKnowledge());
            }
            if (!ObjectUtils.isEmpty(updateKaa.getAbility())) {
                existingKaa.setAbility(updateKaa.getAbility());
            }

            if (!ObjectUtils.isEmpty(updateKaa.getAttitude())) {
                existingKaa.setAttitude(updateKaa.getAttitude());
            }

            return KaaRepo.save(existingKaa);
        } else {
            throw new EntityNotFoundException("Kaa não encontrado - ID: " + id);
        }
    }

    public void deleteKaa(Long id) {
        KaaRepo.deleteById(id);
    }

}
