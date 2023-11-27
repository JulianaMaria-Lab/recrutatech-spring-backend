package com.digitalwave.recrutatech.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ability")
public class Ability {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "h_content",columnDefinition = "TEXT", length = 1500)
    private String content;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

    public void saveAbility(String jsonResponse) {
        this.content = jsonResponse;
    }

    @Override
    public String toString() {
        return "Hability{" +
                "Content='" + content + '\'' +
                '}';
    }

}
