package com.kiran;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component // or @Component
public class WelcomeService {

	@Value("${welcome.message}")
	private String welcomeMessage;


	public String retrieveWelcomeMessage() {
		return welcomeMessage;
	}
}