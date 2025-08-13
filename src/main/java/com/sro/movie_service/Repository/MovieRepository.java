package com.sro.movie_service.Repository;

import com.sro.movie_service.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

}
