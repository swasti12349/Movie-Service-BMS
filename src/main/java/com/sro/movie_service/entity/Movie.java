package com.sro.movie_service.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String genre;
    private int duration;  // in minutes
    private double rating; // 0-10 scale

    public Movie() {}

    public Movie(String title, String genre, int duration, double rating) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.rating = rating;
    }
     public Movie(Long id, String title, String genre, int duration, double rating) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}