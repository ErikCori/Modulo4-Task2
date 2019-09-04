package com.codeoftheweb.salvo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
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
			Player player5 = new Player("null");

			playerRepository.saveAll(Arrays.asList(player1, player2, player3, player4, player5));

			//save a couple of games

			Date date1 = new Date();
			Date date2 = Date.from(date1.toInstant().plusSeconds(3600));
			Date date3 = Date.from(date1.toInstant().plusSeconds(7200));
			Date date4 = Date.from(date2.toInstant().plusSeconds(3600));
			Date date5 = Date.from(date2.toInstant().plusSeconds(7200));
			Date date6 = Date.from(date3.toInstant().plusSeconds(3600));
			Date date7 = Date.from(date3.toInstant().plusSeconds(7200));
			Date date8 = Date.from(date4.toInstant().plusSeconds(3600));

			Game game1 = new Game(date1);
			Game game2 = new Game(date2);
			Game game3 = new Game(date3);
			Game game4 = new Game(date4);
			Game game5 = new Game(date5);
			Game game6 = new Game(date6);
			Game game7 = new Game(date7);
			Game game8 = new Game(date8);

			gameRepository.saveAll(Arrays.asList(game1, game2, game3, game4, game5, game6, game7, game8));


			//save a couple of GamePlayers

			GamePlayer gamePlayer1 = new GamePlayer(date1, game1, player1);
			GamePlayer gamePlayer2 = new GamePlayer(date1, game1, player2);
			GamePlayer gamePlayer3 = new GamePlayer(date2, game2, player1);
			GamePlayer gamePlayer4 = new GamePlayer(date2, game2, player2);
			GamePlayer gamePlayer5 = new GamePlayer(date3, game3, player4);
			GamePlayer gamePlayer6 = new GamePlayer(date3, game3, player2);
			GamePlayer gamePlayer7 = new GamePlayer(date4, game4, player2);
			GamePlayer gamePlayer8 = new GamePlayer(date4, game4, player1);
			GamePlayer gamePlayer9 = new GamePlayer(date5, game5, player4);
			GamePlayer gamePlayer10 = new GamePlayer(date5, game5, player1);
			GamePlayer gamePlayer11 = new GamePlayer(date6, game6, player3);
			GamePlayer gamePlayer12 = new GamePlayer(date6, game6, player5);
			GamePlayer gamePlayer13 = new GamePlayer(date7, game7, player4);
			GamePlayer gamePlayer14 = new GamePlayer(date7, game7, player5);
			GamePlayer gamePlayer15 = new GamePlayer(date8, game8, player3);
			GamePlayer gamePlayer16 = new GamePlayer(date8, game8, player4);


			gamePlayerRepository.saveAll(Arrays.asList(gamePlayer1, gamePlayer2, gamePlayer3, gamePlayer4, gamePlayer5, gamePlayer6,
													gamePlayer7, gamePlayer8, gamePlayer9, gamePlayer10, gamePlayer11, gamePlayer12,
													gamePlayer13, gamePlayer14, gamePlayer15, gamePlayer16));


		};
	}

}
