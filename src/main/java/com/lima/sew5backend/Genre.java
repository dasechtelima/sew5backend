package com.lima.sew5backend;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Embeddable
public class Genre {
    @NotBlank
    @Size(min = 2, message = "Name should have atleast 2 characters")
    private String name;

    protected Genre() {
    }

    public Genre(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format(
                "Genre[name='%s']",
                name);
    }

    public String getName() {
        return name;
    }
}
