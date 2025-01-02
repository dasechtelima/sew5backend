package com.lima.sew5backend;

import jakarta.persistence.*;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;
    private String genre;
    /**
     * Length in seconds
     */
    private int length;

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setLength(int length) {
        this.length = length;
    }

    protected Song() {
    }

    public Song(String title, Artist artist, String genre, int length) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.length = length;
    }

    @Override
    public String toString() {
        return String.format(
                "Song[id=%d, title='%s', artist='%s', genre='%s', length=%d]",
                id, title, artist.getName(), genre, length);
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Artist getArtist() {
        return artist;
    }

    public String getGenre() {
        return genre;
    }

    public int getLength() {
        return length;
    }
}
