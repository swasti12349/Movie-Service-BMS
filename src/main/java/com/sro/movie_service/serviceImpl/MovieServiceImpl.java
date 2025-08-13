package com.sro.movie_service.serviceImpl;

import com.sro.movie_service.IService.IMovieService;
import com.sro.movie_service.Repository.MovieRepository;
import com.sro.movie_service.dto.MovieDTO;
import com.sro.movie_service.entity.Movie;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements IMovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public MovieDTO addMovie(MovieDTO movieDTO) {
        Movie movie = mapToEntity(movieDTO);
        Movie savedMovie = movieRepository.save(movie);
        return mapToDTO(savedMovie);
    }

    @Override
    public List<MovieDTO> getAllMovies() {
        List<Movie> movies = movieRepository.findAll();

        return movies.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MovieDTO getMovieById(Long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found with id: " + id));
        return mapToDTO(movie);
    }

    @Override
    public MovieDTO updateMovie(Long id, MovieDTO movieDTO) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found with id: " + id));

        movie.setTitle(movieDTO.getTitle());
        movie.setGenre(movieDTO.getGenre());
        movie.setDuration(movieDTO.getDuration());
        movie.setRating(movieDTO.getRating());

        Movie updatedMovie = movieRepository.save(movie);
        return mapToDTO(updatedMovie);
    }

    @Override
    public void deleteMovie(Long id) {
        if (!movieRepository.existsById(id)) {
            throw new RuntimeException("Movie not found with id: " + id);
        }
        movieRepository.deleteById(id);
    }

    // ✅ Helper Methods for Mapping
    private MovieDTO mapToDTO(Movie movie) {
        return new MovieDTO(
                movie.getId(),
                movie.getTitle(),
                movie.getGenre(),
                movie.getDuration(),
                movie.getRating()
        );
    }

    private Movie mapToEntity(MovieDTO movieDTO) {
        Movie movie = new Movie();
        movie.setTitle(movieDTO.getTitle());
        movie.setGenre(movieDTO.getGenre());
        movie.setDuration(movieDTO.getDuration());
        movie.setRating(movieDTO.getRating());
        return movie;
    }
}
