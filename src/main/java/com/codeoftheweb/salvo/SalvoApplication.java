package com.codeoftheweb.salvo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
public class SalvoApplication {

	public static void main(String[] args) {

		SpringApplication.run(SalvoApplication.class, args);
	}
	@Bean
	public CommandLineRunner initData(PlayerRepository repository){
		return (args) -> {
			//save  a couple of players
			repository.save(new Player("j.bauer@ctu.gov"));
			repository.save(new Player("c.obrian@ctu.gov"));
			repository.save(new Player("t.almeida@ctu.gov"));
			repository.save(new Player("d.palmer@whitehouse.gov"));
		};
	}
	public CommandLineRunner initData(GameRepository repository){
		return (args) -> {
			//save  a couple of players
			LocalDate dateGame1 = LocalDate.parse("2/17/2018, 3:20:15 PM");
			LocalDate dateGame2 = LocalDate.parse("2/17/2018, 4:20:15 PM");
			LocalDate dateGame3 = LocalDate.parse("")

			repository.save(new Game(dateGame1));
			repository.save(new Game(dateGame2));
			repository.save(new Game(dateGame3));
		};
	}
	public CommandLineRunner initData(GamePlayerRepository repository){
		return (args) -> {
			//save  a couple of players
			repository.save(new GamePlayer());
			repository.save(new Player("Juan"));
			repository.save(new Player("Matias"));
			repository.save(new Player("Micaela"));
			repository.save(new Player("Erik"));
		};
	}

}
