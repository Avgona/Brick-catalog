package com.avgona.assignment.service.impl;

import com.avgona.assignment.models.Brick;
import com.avgona.assignment.repository.BrickRepository;
import com.avgona.assignment.service.BrickService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrickServiceImpl implements BrickService {

    private final BrickRepository brickRepository;

    @Autowired
    public BrickServiceImpl(BrickRepository brickRepository) {
        this.brickRepository = brickRepository;
    }

    @Override
    public List<Brick> findAll() {
        return brickRepository.findAll();
    }

    @Override
    public Brick findById(long id) {
        Optional<Brick> brickById = brickRepository.findById(id);
        Brick brick;

        if(brickById.isPresent())
            brick = brickById.get();
        else
            throw new RuntimeException("There's no brick with the " + id + " id");

        return brick;
    }

    @Override
    public Brick findByColor(String color) {
        return brickRepository.findByColor(color);
    }

    @Override
    public void save(Brick brick) {
        brickRepository.save(brick);
    }

    @Override
    public void deleteById(long id) {
        brickRepository.deleteById(id);
    }
}
