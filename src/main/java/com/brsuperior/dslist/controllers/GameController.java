package com.brsuperior.dslist.controllers;

import com.brsuperior.dslist.DTOs.GameDTO;
import com.brsuperior.dslist.DTOs.GameMinDTO;
import com.brsuperior.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameMinDTO> findAll(){
        return gameService.findAll();
    }

    @GetMapping(value = "/{id}")
    public GameDTO findByID(@PathVariable Long id){
        GameDTO result = gameService.findById(id);
        return result;
    }

}
