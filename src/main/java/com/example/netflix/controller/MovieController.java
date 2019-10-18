package com.example.netflix.controller;

import com.example.netflix.model.Movie;
import com.example.netflix.model.User;
import com.example.netflix.services.MovieService;
import com.example.netflix.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping(value = "movies/{category_id}")
    public List<Movie> findByCategoryIdAndType(@PathVariable Long category_id, @RequestParam(value="type") String type){
        return movieService.getMovies(category_id,type);
//        return movieService.getMovies(category_id,type);
    }

    @PostMapping
    public Movie suggestMovie(@RequestParam Long identificationNumber,@RequestBody Movie movie){
        return movieService.suggestMovie(movie.getTitle(),movie.getCategories(),identificationNumber);
    }

//    @PatchMapping("movies/{id}/")
//    public Movie updateMovie(@PathVariable Long id,@RequestParam(value="user_id") Long user_id,@RequestParam(value="movie_name") String movie_name,@RequestParam(value="movie_category") Long movie_category){
//        return movieService.updateMovie(id,movie_name,movie_category,user_id);
//    }
//
//    @DeleteMapping("movies/{id}")
//    public void deleteMovie(@PathVariable Long id, @RequestParam(value="user_id") Long user_id){
//        movieService.deleteMovie(user_id,id);
//    }
}
