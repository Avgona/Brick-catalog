package com.avgona.assignment.controllers;

import com.avgona.assignment.models.Brick;
import com.avgona.assignment.service.BrickService;
import com.avgona.assignment.service.ReservationService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/bricks")
public class BrickRestController {

    private final BrickService brickService;


    @Autowired
    public BrickRestController(BrickService brickService) {
        this.brickService = brickService;
    }

    @ApiOperation(value = "Find all bricks")
    @GetMapping
    public List<Brick> getBricks(){
        return brickService.findAll();
    }

    @ApiOperation(value = "Find a brick by id", notes = "Provides brick's information by id")
    @GetMapping("/{id}")
    public Brick getById(@PathVariable long id){
        return brickService.findById(id);
    }
}
