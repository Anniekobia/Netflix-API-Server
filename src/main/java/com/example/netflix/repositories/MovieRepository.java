package com.example.netflix.repositories;

import com.example.netflix.model.Category;
import com.example.netflix.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {

    Movie findByTitle(String title);

    List<Movie> findByCategoriesAndType(Optional<Category> category, String type);
//    List<Movie> findByCategoriesAndType(Long id, String type);
//
//    Movie findByIdAndUser(Long user_id, Long id);



}
