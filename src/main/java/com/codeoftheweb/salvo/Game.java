package com.codeoftheweb.salvo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;


@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    @OneToMany(mappedBy = "game", fetch = FetchType.EAGER)
    Set<GamePlayer> gamePlayers;

    private LocalDateTime creationDate;
    //DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/mm/yyyy, HH:mm:ss");

    public Game(){}

    public Game(LocalDateTime creationDate){
        this.creationDate = creationDate;
    }
    //Getters
    public long getId(){
        return id;
    }
    public LocalDateTime getCreationDate(){
        return creationDate;
    }
    public Set<GamePlayer> getGamePlayers() {
        return gamePlayers;
    }

    //Setters
    public void setCreationDate(LocalDateTime creationDate){
        this.creationDate = creationDate;
    }

    public void setGamePlayers(Set<GamePlayer> gamePlayers) {
        this.gamePlayers = gamePlayers;
    }

    public void addGamePlayer(GamePlayer gamePlayer){
        gamePlayer.setGame(this);
        gamePlayers.add(gamePlayer);
    }
    public List<Player> getPlayers(){
        return gamePlayers.stream().map(gamePlayer -> gamePlayer.getPlayer()).collect(toList());
    }
}
