package com.codeoftheweb.salvo;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


import static java.util.stream.Collectors.toList;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    @OneToMany(mappedBy = "player", fetch = FetchType.EAGER)
    private Set<GamePlayer> gamePlayers;

    private String username;

    public Player(){}

    public Player(String username){

        this.username = username;
    }

    public long getId(){
        return id;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {

        return username;
    }
    public String toString() {

        return username;
    }
    public void addGamePlayer(GamePlayer gamePlayer){
        gamePlayer.setPlayer(this);
        gamePlayers.add(gamePlayer);
    }
    public List<Game> getGames(){
        return gamePlayers.stream().map(gamePlayer -> gamePlayer.getGame()).collect(toList());
    }
}
