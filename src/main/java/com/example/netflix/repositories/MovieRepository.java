package com.example.netflix.repositories;

import com.example.netflix.model.Category;
import com.example.netflix.model.Movie;
import com.example.netflix.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {

    Movie findByTitle(String title);

    List<Movie> findByCategoriesAndType(Category category, String type);

    Movie findByIdAndUser(Long id, User user);
}
