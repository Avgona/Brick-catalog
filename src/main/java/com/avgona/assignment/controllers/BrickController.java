package com.avgona.assignment.controllers;

import com.avgona.assignment.exceptions.AmountOfBoundException;
import com.avgona.assignment.models.Brick;
import com.avgona.assignment.models.Reservation;
import com.avgona.assignment.service.BrickService;
import com.avgona.assignment.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("catalog")
public class BrickController {

    private final BrickService brickService;
    private final ReservationService reservationService;

    @Autowired
    public BrickController(BrickService brickService, ReservationService reservationService) {
        this.brickService = brickService;
        this.reservationService = reservationService;
    }

    @GetMapping("/index")
    public String index(Model model){
        List<Brick> bricks = brickService.findAll();
        model.addAttribute("bricks", bricks);
        model.addAttribute("reservation", new Reservation());
        return "catalog";
    }

    @PostMapping("/sell")
    public String sell(@ModelAttribute("order") Reservation reservation) {
        Brick brick = brickService.findById(reservation.getIdOfBrick());

        switch (reservation.getTypeOfClient()){
            case "Retail":
                if(brick.getAmountOfBricks() >= reservation.getAmountOfBricks()) {
                    brick.setAmountOfBricks(brick.getAmountOfBricks() - reservation.getAmountOfBricks());
                    brick.setAmountOfPallet(brick.getAmountOfPallet() - ((float) (reservation.getAmountOfBricks()) / brick.getAmountOfBricksInPallet()));
                }
                else
                    throw new AmountOfBoundException("There's no such quantity of bricks. Try again.");

            case "Wholesale":
                if(brick.getAmountOfPallet() >= reservation.getAmountOfPallet()) {
                    brick.setAmountOfPallet(brick.getAmountOfPallet() - reservation.getAmountOfPallet());
                    brick.setAmountOfBricks((brick.getAmountOfBricks() - ((int) (reservation.getAmountOfPallet() * brick.getAmountOfBricksInPallet()))));
                }
                else
                    throw new AmountOfBoundException("There's no such quantity of pallets. Try again.");
        }

        brickService.save(brick);
        reservationService.save(reservation);

        return "redirect:/catalog/index";
    }

    // Method restocks a warehouse
    @PostMapping("/restock")
    public String order(){
        List<Brick> bricks = brickService.findAll();

        bricks.get(0).setAmountOfBricks(5000);
        bricks.get(0).setAmountOfPallet(50);

        bricks.get(1).setAmountOfBricks(5000);
        bricks.get(1).setAmountOfPallet(71.4285714F);

        bricks.get(2).setAmountOfBricks(5000);
        bricks.get(2).setAmountOfPallet(20);

        for(int i = 0; i < 3; i++)
            brickService.save(bricks.get(i));

        return "redirect:/catalog/index";
    }
}
