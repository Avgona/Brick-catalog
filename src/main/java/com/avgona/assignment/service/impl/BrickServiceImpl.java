package com.avgona.assignment.service.impl;

import com.avgona.assignment.models.Brick;
import com.avgona.assignment.repository.BrickRepository;
import com.avgona.assignment.service.BrickService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
public class BrickServiceImpl implements BrickService {

    private final BrickRepository brickRepository;

    @Autowired
    public BrickServiceImpl(BrickRepository brickRepository) {
        this.brickRepository = brickRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Brick> findAll() {
        return brickRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Brick findById(long id) {
        return brickRepository.findById(id).orElseThrow(() ->
                new RuntimeException("There's no brick with the " + id + " id"));
    }

    @Transactional(readOnly = true)
    @Override
    public Brick findByColor(String color) {
        return brickRepository.findByColor(color);
    }

    @Transactional
    @Override
    public void save(Brick brick) {
        brickRepository.save(brick);
    }

    @Transactional
    @Override
    public void deleteById(long id) {
        brickRepository.deleteById(id);
    }
}
