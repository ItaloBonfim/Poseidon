package com.LeagueSocial;

import com.LeagueSocial.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LeagueSocialApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LeagueSocialApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


	}
}
