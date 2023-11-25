package com.digitalwave.recrutatech.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import com.digitalwave.recrutatech.entity.Cha;
import com.digitalwave.recrutatech.entity.Job;
import com.digitalwave.recrutatech.interfaces.IJobService;
import com.digitalwave.recrutatech.repository.ChaRepository;
import com.digitalwave.recrutatech.repository.JobRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class JobService implements IJobService {
	
	@Autowired
	private JobRepository jobRepo;
	
	@Autowired
	private ChaRepository chaRepo;
	
    @Override
    public Job newJob(Job job) {
        Long chaId = job.getCha().getId();
        Cha cha = chaRepo.findById(chaId)
                .orElseThrow(() -> new EntityNotFoundException("Cha não encontrado com o ID: " + chaId));
        job.setCha(cha);
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

            if (!ObjectUtils.isEmpty(updatedJob.getCha())) {
                Cha updatedCha = updatedJob.getCha();

                if (!ObjectUtils.isEmpty(updatedCha.getConhecimento())) {
                    existingJob.getCha().setConhecimento(updatedCha.getConhecimento());
                }

                if (!ObjectUtils.isEmpty(updatedCha.getHabilidade())) {
                    existingJob.getCha().setHabilidade(updatedCha.getHabilidade());
                }

                if (!ObjectUtils.isEmpty(updatedCha.getAtitude())) {
                    existingJob.getCha().setAtitude(updatedCha.getAtitude());
                }
            }
            
            if (!ObjectUtils.isEmpty(updatedJob.getRank())) {
                existingJob.setRank(updatedJob.getRank());
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
