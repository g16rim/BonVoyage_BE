package com.ssafy.BonVoyage;

import com.ssafy.BonVoyage.config.YamlPropertySourceFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = {"classpath:secretfile.yml"}, factory = YamlPropertySourceFactory.class)

public class BonVoyageApplication {

	public static void main(String[] args) {
		SpringApplication.run(BonVoyageApplication.class, args);
	}

}
