package com.example.netflix.services;

import com.example.netflix.EntityExistsException;
import com.example.netflix.model.Category;
import com.example.netflix.model.Movie;
import com.example.netflix.model.User;
import com.example.netflix.repositories.MovieRepository;
import com.example.netflix.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImplementation implements MovieService {
    private  final MovieRepository movieRepository;
    private final UserRepository userRepository;
    private  final CategoryService categoryService;

    public MovieServiceImplementation(MovieRepository movieRepository, UserRepository userRepository, CategoryService categoryService) {
        this.movieRepository = movieRepository;
        this.userRepository = userRepository;
        this.categoryService = categoryService;
    }

    @Override
    public Movie suggestMovie(Movie movie, Long identification) {
        Movie existingMovie = movieRepository.findByTitle(movie.getTitle());
        User user = userRepository.findByIdentificationNumber(identification);
        if (existingMovie==null) {
            for (Category category : movie.getCategories()) {
                category = categoryService.getCategory(category.getId());
                category.getMovies().add(movie);
            }
            movie.setUser(user);
            movie.setType("Suggested");
            return movieRepository.save(movie);
        }else {
            throw  new EntityExistsException("This movie has already been suggested");
        }
    }

    @Override
    public List<Movie> getMoviesByCategoryAndType(Category category, String type) {
        return movieRepository.findByCategoriesAndType(category,type);
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie updateMovie(Long movie_id,  Long user_id, Movie movie) {
        User user = userRepository.findByIdentificationNumber(user_id);
        Movie movie1 = movieRepository.findByIdAndUser(movie_id,user);
        for (Category category: movie1.getCategories()) {
            category = categoryService.getCategory(category.getId());
            movie1.getCategories().remove(category);
        }
        for (Category category : movie.getCategories()) {
            category = categoryService.getCategory(category.getId());
            movie1.getCategories().add(category);
        }
        movie1.setTitle(movie.getTitle());
        return movieRepository.save(movie1);
    }

    @Override
    public void deleteMovie(Long user_identification, Long movie_id) {
        Movie movie=movieRepository.findByIdAndUser(movie_id,userRepository.findByIdentificationNumber(user_identification));
        movieRepository.delete(movie);
    }


}
