package com.kiran.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserCommandLineRunner implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(UserCommandLineRunner.class);

	@Autowired
	UserRepository repository;

	@Override
	public void run(String... args) throws Exception {
		repository.save(new User("kiran", "Admin"));
		repository.save(new User("user", "User"));
		
		log.info(" ____________________Testing CommandLineRunner______________________");

		for (User user : repository.findByRole("User"))
		{
			log.info(user.toString() + "PASS: secret");
		}
		log.info(" ______Testing CommandLineRunner (Admin only)________");
		for(User user : repository.findByRole("Admin"))
		{
			log.info(user.toString() + "PASS: password");
		}
		log.info(" ________________________________________________________");

	}

}
