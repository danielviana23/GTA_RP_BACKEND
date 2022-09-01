package com.jogos.rp;

import com.jogos.rp.core.sessao.SessaoRP;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
@Configuration
@EnableJpaRepositories
public class RpApplication {

	public static void main(String[] args) {
		SpringApplication.run(RpApplication.class, args);
	}

}