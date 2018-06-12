package com.nd.zsp.neo4jbootdemo.repository;


import com.nd.zsp.neo4jbootdemo.domain.Movie;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface MovieRepository extends Neo4jRepository<Movie, UUID>{
    Movie findByTitle(@Param("title") String title);
}
