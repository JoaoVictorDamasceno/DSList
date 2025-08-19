package com.brsuperior.dslist.services;

import com.brsuperior.dslist.DTOs.GameMinDTO;
import com.brsuperior.dslist.entities.Game;
import com.brsuperior.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll (){
        List<Game> result = gameRepository.findAll();
        return result.stream().map(GameMinDTO::new).toList();
    }

}
