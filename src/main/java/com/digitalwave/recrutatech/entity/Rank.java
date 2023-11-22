package com.digitalwave.recrutatech.entity;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "rank")
public class Rank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rank_id")
    private long id;

    @ElementCollection
    @CollectionTable(name = "rank_values")
    @Column(name = "value")
    @JoinColumn(name = "rank_id")
    private List<String[]> value;

    public Rank() {
    }

    public Rank(List<String[]> value) {
        this.value = value;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<String[]> getValue() {
        return value;
    }

    public void setValue(List<String[]> value) {
        this.value = value;
    }
}
