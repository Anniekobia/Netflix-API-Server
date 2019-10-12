package com.example.netflix.services;

import com.example.netflix.model.Category;
import com.example.netflix.model.Movie;
import com.example.netflix.repositories.CategoryRepository;
import com.example.netflix.repositories.MovieRepository;

import java.util.List;

public class MovieServiceImplementation implements MovieService {
    private final MovieRepository movieRepository;
    private final CategoryRepository categoryRepository;

    public MovieServiceImplementation(MovieRepository movieRepository, CategoryRepository categoryRepository) {
        this.movieRepository = movieRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Movie suggestMovie(String name, Category category) {
        String type="Suggested";
        Movie movie= new Movie(name,category,type);
        return movieRepository.save(movie);
    }

    @Override
    public List<Movie> getMovies(Long id, String type) {
        return movieRepository.findByCategoriesAndType(id,type);
    }

    @Override
    public Movie updateMovie(Long movie_id, String name, Long category_id, Long user_id) {
        Movie movie = movieRepository.findByIdAndUser(user_id,movie_id);
        movie.setName(name);
        movie.setCategory(categoryRepository.findById(category_id));
        return movieRepository.save(movie);
    }

    @Override
    public void deleteMovie(Long user_id, Long movie_id) {
        Movie movie = movieRepository.findByIdAndUser(user_id,movie_id);
        movieRepository.delete(movie);
    }
}
