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
	public CommandLineRunner initData(PlayerRepository repository1, GameRepository repository2, GamePlayerRepository repository3){
		return (args) -> {
			//save  a couple of players

			repository1.save(new Player("j.bauer@ctu.gov"));
			repository1.save(new Player("c.obrian@ctu.gov"));
			repository1.save(new Player("t.almeida@ctu.gov"));
			repository1.save(new Player("d.palmer@whitehouse.gov"));

			//save a couple of games

			Date dateGame1 =  new Date();
			Date dateGame2 =  new Date();
			Date dateGame3 =  new Date();


			repository2.save(new Game(dateGame1));
			repository2.save(new Game(dateGame2));
			repository2.save(new Game(dateGame3));

			//save a couple of PlayerGames
		};
	}

}
