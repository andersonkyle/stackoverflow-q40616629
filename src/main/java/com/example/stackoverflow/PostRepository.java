package com.example.stackoverflow;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long>{

    public List<Post> findAllByOrderByPublishedOnDesc();

    @Query(value = "SELECT * FROM post ORDER BY published_on DESC", nativeQuery = true)
    public List<Post> customQuery();
}
