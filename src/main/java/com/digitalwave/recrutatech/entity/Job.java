package com.digitalwave.recrutatech.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="job")

public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "job_id")
	private long id;
	
	@Column(name="job_title")
	private String jobTitle;
	
	@Column(name="job_level")
	private String jobLevel;
	
	@Column(name="job_description", length = 1500)
	private String jobDescription;
	
	@Column(name="job_status")
	private String jobStatus;
	
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "kaa_id")
    private Kaa kaa;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rank_id")
    private Rank rank;

    public Job() {
    }

	public Job(String jobTitle, String jobLevel, String jobDescription, String jobStatus, Kaa kaa, Rank rank) {
		this.jobTitle = jobTitle;
		this.jobLevel = jobLevel;
		this.jobDescription = jobDescription;
		this.jobStatus = jobStatus;
		this.kaa = kaa;
		this.rank = rank;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getJobLevel() {
		return jobLevel;
	}

	public void setJobLevel(String jobLevel) {
		this.jobLevel = jobLevel;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	
	public String getJobStatus() {
		return jobStatus;
	}

	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}

    public Kaa getKaa() {
        return kaa;
    }

    public void setKaa(Kaa kaa) {
        this.kaa = kaa;
    }

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}
    
    
    
    
}


