package com.habuma.spittr.data.jdbcTemplate;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;
import spittr.Spitter;
import spittr.data.SpitterRepository;

@Repository
public class JdbcSpitterRepository implements SpitterRepository{

    private JdbcOperations jdbcOperations;

    public JdbcSpitterRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public Spitter save(Spitter unsaved) {
        System.out.println("success");
        return null;
    }

    @Override
    public void atLeastOnce() {

    }

    @Override
    public Spitter findByUsername(String username) {
        return null;
    }

    @Override
    public void markAnything() {

    }
}
