package com.example.netflix.services;

import com.example.netflix.model.Category;
import com.example.netflix.model.Movie;
import com.example.netflix.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface MovieService {

    Movie suggestMovie(String title, Set<Category> categories, Long identification);

    List<Movie> getMovies(Long category_id,String type);
//
//    Movie updateMovie(Long movie_id, String name, Long category_id, Long user_identification);
//
//    void deleteMovie(Long user_identification,Long movie_id);
}
