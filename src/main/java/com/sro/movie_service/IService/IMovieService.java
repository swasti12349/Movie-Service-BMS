package com.sro.movie_service.IService;


import com.sro.movie_service.dto.MovieDTO;

import java.util.List;

public interface IMovieService {

    MovieDTO addMovie(MovieDTO movieDTO);
    List<MovieDTO> getAllMovies();
    MovieDTO getMovieById(Long id);
    MovieDTO updateMovie(Long id, MovieDTO movieDTO);
    void deleteMovie(Long id);

}
