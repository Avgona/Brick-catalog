package com.avgona.assignment.repository;

import com.avgona.assignment.models.Brick;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrickRepository extends JpaRepository<Brick, Long> {
    Brick findByColor(String color);
}
