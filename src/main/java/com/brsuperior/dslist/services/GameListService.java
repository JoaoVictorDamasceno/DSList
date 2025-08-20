package com.brsuperior.dslist.services;

import com.brsuperior.dslist.DTOs.GameListDTO;
import com.brsuperior.dslist.DTOs.GameMinDTO;
import com.brsuperior.dslist.entities.Game;
import com.brsuperior.dslist.entities.GameList;
import com.brsuperior.dslist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(GameListDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public GameListDTO findById(Long id){
        GameList result = gameListRepository.findById(id).orElseThrow(NoSuchElementException::new);
        return new GameListDTO(result);
    }

}
