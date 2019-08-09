package com.codeoftheweb.salvo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class GamePlayer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "player_id")
    private Player player;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "game_id")
    private Game game;

    public GamePlayer(){}

    public GamePlayer(Player player, Game game){
        this.player = player;
        this.game = game;
    }

    //Getters
    public Player getPlayer(){
        return player;
    }
    public Game getGame(){
        return game;
    }

    //Setters
    public void setPlayer(Player player){
        this.player = player;
    }
    public void setGame(Game game){
        this.game = game;
    }
}
