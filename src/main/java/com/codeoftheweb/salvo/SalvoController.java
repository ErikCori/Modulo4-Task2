package com.codeoftheweb.salvo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class SalvoController {
    @Autowired
    private GameRepository repo;

    @RequestMapping("/api/games")
    /*public List<Object> getAllGames(){
        return repo.findAll().stream().map(game -> game.getId()).collect(Collectors.toList());
    }*/
    public List<Object> getAllGames() {
        return repo.findAll().stream().map(game -> makeGameDto(game)).collect(Collectors.toList());
    }
    private Map<String, Object> makeGameDto(Game game){
        Map<String, Object> dto = new LinkedHashMap<String, Object>();
        dto.put("id", game.getId());
        dto.put("created", game.getCreationDate());
        return dto;
    }

}
