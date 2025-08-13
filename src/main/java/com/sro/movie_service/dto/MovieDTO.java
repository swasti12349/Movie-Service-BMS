package com.sro.movie_service.dto;

public class MovieDTO {

    private Long id;
    private String title;
    private String genre;
    private int duration;
    private double rating;

    public MovieDTO() {}

    public MovieDTO(Long id, String title, String genre, int duration, double rating) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.rating = rating;
    }

    // Getters & Setters
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
