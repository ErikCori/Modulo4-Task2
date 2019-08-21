package com.codeoftheweb.salvo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;


@SpringBootApplication
public class SalvoApplication {

	public static void main(String[] args) {

		SpringApplication.run(SalvoApplication.class, args);
	}
	@Bean
	public CommandLineRunner initData(PlayerRepository playerRepository, GameRepository gameRepository, GamePlayerRepository gamePlayerRepository){
		return (args) -> {
			//save  a couple of players
			Player player1 = new Player("j.bauer@ctu.gov");
			Player player2 = new Player("c.obrian@ctu.gov");
			Player player3 = new Player("kim_bauer@gmail.com");
			Player player4 = new Player("t.almeida@ctu.gov");

			playerRepository.save(player1);
			playerRepository.save(player2);
			playerRepository.save(player3);
			playerRepository.save(player4);

			//save a couple of games

			Date date1 = new Date();
			Date date2 = Date.from(date1.toInstant().plusSeconds(3600));
			Date date3 = Date.from(date1.toInstant().plusSeconds(7200));

			Game game1 = new Game(date1);
			Game game2 = new Game(date2);
			Game game3 = new Game(date3);

			gameRepository.save(game1);
			gameRepository.save(game2);
			gameRepository.save(game3);

			//save a couple of PlayerGames

			GamePlayer gamePlayer1 = new GamePlayer(date1, game1, player1);
			GamePlayer gamePlayer2 = new GamePlayer(date1, game1, player2);
			GamePlayer gamePlayer3 = new GamePlayer(date2, game2, player1);
			GamePlayer gamePlayer4 = new GamePlayer(date2, game2, player2);
			GamePlayer gamePlayer5 = new GamePlayer(date3, game3, player2);
			GamePlayer gamePlayer6 = new GamePlayer(date3, game3, player4);


			gamePlayerRepository.save(gamePlayer1);
			gamePlayerRepository.save(gamePlayer2);
			gamePlayerRepository.save(gamePlayer3);
			gamePlayerRepository.save(gamePlayer4);
			gamePlayerRepository.save(gamePlayer5);
			gamePlayerRepository.save(gamePlayer6);

		};
	}

}
