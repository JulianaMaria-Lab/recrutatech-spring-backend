package com.digitalwave.recrutatech.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import com.digitalwave.recrutatech.entity.Kaa;
import com.digitalwave.recrutatech.entity.Rank;
import com.digitalwave.recrutatech.entity.Job;
import com.digitalwave.recrutatech.interfaces.IJobService;
import com.digitalwave.recrutatech.repository.KaaRepository;
import com.digitalwave.recrutatech.repository.JobRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class JobService implements IJobService {
	
	@Autowired
	private JobRepository jobRepo;
	
	@Autowired
	private KaaRepository chaRepo;
	
	@Autowired
	private RankService rankService;
	
    @Override
    public Job newJob(Job job) {
        Long chaId = job.getKaa().getId();
        Kaa kaa = chaRepo.findById(chaId)
                .orElseThrow(() -> new EntityNotFoundException("Cha não encontrado com o ID: " + chaId));
        job.setKaa(kaa);
        return jobRepo.save(job);
    }

	public List<Job> findAllJobs(){
		return jobRepo.findAll();
	}
	
    public Job findJobId(Long id) {
        Optional<Job> jobOp = jobRepo.findById(id);
        if(jobOp.isEmpty()) {
            throw new IllegalArgumentException("Vaga não encontrada!");
        }
        return jobOp.get();
    }

    public List<Job> findAllJobStatus(String jobStatus) {
        return jobRepo.findAllByJobStatus(jobStatus);
    }
    @Override
    public Job updateJob(Long id, Job updatedJob) {
        Optional<Job> jobOp = jobRepo.findById(id);

        if (jobOp.isPresent()) {
            Job existingJob = jobOp.get();

            if (!ObjectUtils.isEmpty(updatedJob.getJobTitle())) {
                existingJob.setJobTitle(updatedJob.getJobTitle());
            }

            if (!ObjectUtils.isEmpty(updatedJob.getJobLevel())) {
                existingJob.setJobLevel(updatedJob.getJobLevel());
            }

            if (!ObjectUtils.isEmpty(updatedJob.getJobDescription())) {
                existingJob.setJobDescription(updatedJob.getJobDescription());
            }

            if (!ObjectUtils.isEmpty(updatedJob.getJobStatus())) {
                existingJob.setJobStatus(updatedJob.getJobStatus());
            }

            if (!ObjectUtils.isEmpty(updatedJob.getKaa())) {
                existingJob.setKaa(updatedJob.getKaa());
            }
            
            if (updatedJob.getRank() != null && updatedJob.getRank().getId() != 0) {
                // Obtenha o Rank existente pelo id
                Rank existingRank = rankService.findRankId(updatedJob.getRank().getId());

                // Associe o Rank existente ao Job
                existingJob.setRank(existingRank);
            }

            
            return jobRepo.save(existingJob);
        } else {
            throw new EntityNotFoundException("Vaga não encontrada - ID: " + id);
        }
    }
        
	public void deleteJob(Long id) {
		jobRepo.deleteById(id);
	}

}
