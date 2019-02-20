package com.cognizant.devtest.moviesmanager.domain.repository;

import com.cognizant.devtest.moviesmanager.domain.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
