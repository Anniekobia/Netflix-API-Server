package com.example.netflix.services;

import com.example.netflix.model.Category;
import com.example.netflix.model.Movie;
import com.example.netflix.model.User;
import com.example.netflix.repositories.CategoryRepository;
import com.example.netflix.repositories.MovieRepository;
import com.example.netflix.repositories.UserRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.Set;

@Service
public class MovieServiceImplementation implements MovieService {
    private final MovieRepository movieRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    public MovieServiceImplementation(MovieRepository movieRepository, CategoryRepository categoryRepository, UserRepository userRepository) {
        this.movieRepository = movieRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Movie suggestMovie(String title, Set<Category> categories, Long identification) {
        String type = "Suggested";
        Movie existingMovie = movieRepository.findByTitle(title);
        User user = userRepository.findByIdentificationNumber(identification);
        if (existingMovie == null) {
            Movie movie = new Movie(title,type, categories);
            for (Category category:categories) {
                movie.addCategory(category);
            }
            movie.setUser(user);
            return movieRepository.save(movie);
        } else {
            throw new EntityExistsException("This Movie has already been suggested");
        }
    }

    @Override
    public List<Movie> getMovies(Long category_id, String type) {
        return movieRepository.findByCategoriesAndType(categoryRepository.findById(category_id),type);
//        return movieRepository.findAll();

    }

//    @Override
//    public Movie updateMovie(Long movie_id, String name, Long category_id, Long user_id) {
//        Movie movie = movieRepository.findByIdAndUser(user_id,movie_id);
//        movie.setTitle(name);
//        movie.setCategory(categoryRepository.findById(category_id));
//        return movieRepository.save(movie);
//    }
//
//    @Override
//    public void deleteMovie(Long user_id, Long movie_id) {
//        Movie movie = movieRepository.findByIdAndUser(user_id,movie_id);
//        movieRepository.delete(movie);
//    }
}
