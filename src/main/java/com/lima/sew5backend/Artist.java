package com.lima.sew5backend;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    protected Artist() {}

    public Artist(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format(
                "Artist[id=%d, name='%s']",
                id, name);
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
}
