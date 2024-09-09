package com.lima.sew5backend;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String artist;
    private String genre;
    /**
     * Length in seconds
     */
    private int length;

    protected Song() {}

    public Song(String title, String artist, String genre, int length) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.length = length;
    }

    @Override
    public String toString() {
        return String.format(
                "Song[id=%d, title='%s', artist='%s', genre='%s', length=%d]",
                id, title, artist, genre, length);
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getGenre() {
        return genre;
    }

    public int getLength() {
        return length;
    }
}
