package com.example.netflix.services;


import com.example.netflix.model.Category;
import com.example.netflix.model.Movie;

import java.util.List;

public interface MovieService {
    Movie suggestMovie(Movie movie,Long identification);

    List<Movie> getMoviesByCategoryAndType(Category category, String type);

    List<Movie> getAllMovies();

    Movie updateMovie(Long movie_id, Long user_identification, Movie movie);

    void deleteMovie(Long user_identification,Long movie_id);
}
