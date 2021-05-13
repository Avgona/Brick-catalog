package com.avgona.assignment.service;

import com.avgona.assignment.models.Brick;

import java.util.List;

public interface BrickService {
    List<Brick> findAll();

    Brick findById(long id);

    Brick findByColor(String color);

    void save(Brick brick);

    void deleteById(long id);
}
