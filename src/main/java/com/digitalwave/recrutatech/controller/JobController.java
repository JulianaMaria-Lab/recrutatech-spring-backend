package com.digitalwave.recrutatech.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalwave.recrutatech.entity.Job;
import com.digitalwave.recrutatech.interfaces.IJobService;

@RestController
@RequestMapping(value="/job")
@CrossOrigin
public class JobController {
	
	@Autowired
	private IJobService service;
	
	@GetMapping("/")
	public List<Job> allJobs(){
		return service.findAllJobs();
	}
	
	@PostMapping("/add")
	public Job newJob(@RequestBody Job job) {
		return service.newJob(job);
	}
	
	@GetMapping (value="/{id}")
	public Job findId (@PathVariable("id") Long id) {
		return service.findJobId(id);
	}
	
  @GetMapping("/status/")
  public List<Job> getJobsByStatus(String jobStatus) {
     return service.findAllJobStatus(jobStatus);
  }
    
  @PutMapping("/{id}")
  public ResponseEntity<Job> updateJob(@PathVariable("id") long id, @RequestBody Job updatedJob) {
    Job updatedJobEntity = service.updateJob(id, updatedJob);
    if (updatedJobEntity != null) {
      return ResponseEntity.ok(updatedJobEntity);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteJob(@PathVariable("id") long id) {
    service.deleteJob(id);
    return ResponseEntity.noContent().build();
  }

}
