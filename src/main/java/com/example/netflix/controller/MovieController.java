package com.example.netflix.controller;

import com.example.netflix.model.Movie;
import com.example.netflix.services.CategoryService;
import com.example.netflix.services.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    private final MovieService movieService;
    private final CategoryService categoryService;

    public MovieController(MovieService movieService, CategoryService categoryService) {
        this.movieService = movieService;
        this.categoryService = categoryService;
    }

    @PostMapping(value = "movies")
    public Movie suggestMovie(@RequestParam Long identificationNumber, @RequestBody Movie movie){
        return  movieService.suggestMovie(movie,identificationNumber);
    }

    @GetMapping(value = "movies/{category_id}")
    public List<Movie> getMoviesByCategoryIdAndType(@PathVariable Long category_id, @RequestParam(value="type") String type){
            return movieService.getMoviesByCategoryAndType(categoryService.getCategory(category_id),type);
    }

    @GetMapping(value = "movies")
    public List<Movie> getAllMovies(){
        return movieService.getAllMovies();
    }

    @PatchMapping("movies/{movie_id}")
    public Movie updateMovie(@PathVariable Long movie_id,@RequestParam(value="user_id") Long user_id,@RequestBody Movie movie){
        return movieService.updateMovie(movie_id,user_id,movie);
    }

    @DeleteMapping("movies/{movie_id}")
    public void deleteMovie(@PathVariable Long movie_id, @RequestParam(value="user_id") Long user_id){
        movieService.deleteMovie(user_id,movie_id);
    }
}
