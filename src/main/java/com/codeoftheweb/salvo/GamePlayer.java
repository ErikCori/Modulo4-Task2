package com.codeoftheweb.salvo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class GamePlayer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private Date joinDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "player_id")
    private Player player;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "game_id")
    private Game game;

    public GamePlayer(){}

    public GamePlayer(Date joinDate, Game game, Player player){
        this.joinDate = joinDate;
        this.player = player;
        this.game = game;
    }

    //Getters

    public Date getJoinDate() {
        return joinDate;
    }

    public long getId(){
        return id;
    }

    @JsonIgnore
    public Player getPlayer(){
        return player;
    }
    @JsonIgnore
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
