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
    public List<Object> getAllGames() {
        return repo.findAll().stream().map(game -> makeGameDto(game)).collect(Collectors.toList());
    }
    private Map<String, Object> makeGameDto(Game game){
        Map<String, Object> dto = new LinkedHashMap<>();
        dto.put("id", game.getId());
        dto.put("created", game.getCreationDate());
        dto.put("gamePlayers", game.getGamePlayers().stream().map(g -> makeGamePlayerDto(g)));
        return dto;
    }
    private Map<String, Object> makeGamePlayerDto(GamePlayer gamePlayer){
        Map<String, Object> dto= new LinkedHashMap<>();
        dto.put("id", gamePlayer.getId());
        dto.put("player", makePlayerDto(gamePlayer.getPlayer()));
        return dto;
    }
    private Map<String, Object> makePlayerDto(Player player){
        Map<String, Object> dto = new LinkedHashMap<>();
        dto.put("id", player.getId());
        dto.put("email", player.getUsername());
        return dto;
    }

}
