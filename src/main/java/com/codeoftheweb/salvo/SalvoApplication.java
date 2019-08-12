package com.codeoftheweb.salvo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.time.LocalDateTime;


@SpringBootApplication
public class SalvoApplication {

	public static void main(String[] args) {

		SpringApplication.run(SalvoApplication.class, args);
	}
	@Bean
	public CommandLineRunner initData(PlayerRepository repository1, GameRepository repository2, GamePlayerRepository repository3){
		return (args) -> {
			//save  a couple of players
			Player player1 = new Player("j.bauer@ctu.gov");
			Player player2 = new Player("c.obrian@ctu.gov");
			Player player3 = new Player("t.almeida@ctu.gov");
			Player player4 = new Player("d.palmer@whitehouse.gov");

			repository1.save(player1);
			repository1.save(player2);
			repository1.save(player3);
			repository1.save(player4);

			//save a couple of games

			Game game1 = new Game(LocalDateTime.parse("2018-02-17T15:20:15"));
			Game game2 = new Game(LocalDateTime.parse("2018-02-17T16:20:15"));
			Game game3 = new Game(LocalDateTime.parse("2018-02-17T17:20:15"));
			Game game4 = new Game(LocalDateTime.parse("2018-02-17T18:20:15"));
			Game game5 = new Game(LocalDateTime.parse("2018-02-17T19:20:15"));
			Game game6 = new Game(LocalDateTime.parse("2018-02-17T20:20:15"));

			repository2.save(game1);
			repository2.save(game2);
			repository2.save(game3);
			repository2.save(game4);
			repository2.save(game5);
			repository2.save(game6);

			//save a couple of PlayerGames

			GamePlayer gamePlayer1 = new GamePlayer(player1, game1);
			GamePlayer gamePlayer2 = new GamePlayer(player2, game1);
			GamePlayer gamePlayer3 = new GamePlayer(player1, game2);
			GamePlayer gamePlayer4 = new GamePlayer(player2, game2);
			GamePlayer gamePlayer5 = new GamePlayer(player2, game3);
			GamePlayer gamePlayer6 = new GamePlayer(player3, game3);
			GamePlayer gamePlayer7 = new GamePlayer(player1, game4);
			GamePlayer gamePlayer8 = new GamePlayer(player2, game4);
			GamePlayer gamePlayer9 = new GamePlayer(player3, game5);
			GamePlayer gamePlayer10 = new GamePlayer(player1, game5);
			GamePlayer gamePlayer11 = new GamePlayer(player4, game6);

			repository3.save(gamePlayer1);
			repository3.save(gamePlayer2);
			repository3.save(gamePlayer3);
			repository3.save(gamePlayer4);
			repository3.save(gamePlayer5);
			repository3.save(gamePlayer6);
			repository3.save(gamePlayer7);
			repository3.save(gamePlayer8);
			repository3.save(gamePlayer9);
			repository3.save(gamePlayer10);
			repository3.save(gamePlayer11);
		};
	}

}
