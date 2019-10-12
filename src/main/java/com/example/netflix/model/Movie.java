package com.example.netflix.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    //@NotNull(groups = Update.class)
    private Long id;

    @Column(name = "name")
    //@NotNull(groups = Create.class)
    private String name;

    @ManyToMany(mappedBy = "movies")
    private Set<Category> categories = new HashSet<>();

    public Movie(String name) {
        this.name = name;
    }

    private Movie(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", categories=" + categories +
                '}';
    }
    public interface Create{}

    public interface Update{}
}