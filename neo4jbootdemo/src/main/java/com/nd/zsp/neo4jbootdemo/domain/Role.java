package com.nd.zsp.neo4jbootdemo.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import org.neo4j.ogm.annotation.*;
import org.neo4j.ogm.annotation.typeconversion.Convert;
import org.neo4j.ogm.id.UuidStrategy;
import org.neo4j.ogm.typeconversion.UuidStringConverter;

import java.util.UUID;

@JsonIdentityInfo(generator = JSOGGenerator.class)
@RelationshipEntity(type = "ACTS_IN")
public class Role {
    @Id
    @GeneratedValue(strategy = UuidStrategy.class)
    @Convert(UuidStringConverter.class)
    private UUID id;

    private String role;

    @StartNode
    private Actor actor;

    @EndNode
    private Movie movie;

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", actor=" + actor +
                ", movie=" + movie +
                '}';
    }

    public Role() {
    }

    public Role(String role, Actor actor) {
        this.role = role;
        this.actor = actor;
    }

    public Role(String role, Actor actor, Movie movie) {
        this.role = role;
        this.actor = actor;
        this.movie = movie;
    }

    public Role(UUID id, String role, Actor actor, Movie movie) {
        this.id = id;
        this.role = role;
        this.actor = actor;
        this.movie = movie;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
