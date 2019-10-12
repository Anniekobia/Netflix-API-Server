package com.example.netflix.services;

import com.example.netflix.model.Category;
import com.example.netflix.model.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {

    Movie suggestMovie(String name, Category categor);

    List <Movie> getMovies(Long id,String type);

    Movie updateMovie(Long movie_id, String name, Long category_id, Long user_id);

    void deleteMovie(Long user_id,Long movie_id);
}
