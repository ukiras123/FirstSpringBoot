package com.kiran;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kiran.configuration.BasicConfiguration;


@RestController
public class WelcomeController {

	//Dependency
	@Autowired
	private WelcomeService service;
	
	@Autowired
	BasicConfiguration conf;

	@RequestMapping("/welcome")
	public String welcome() {
		return service.retrieveWelcomeMessage();
	}

	@RequestMapping("/dynamic-conf")
	public Map dynamicConf() {
		Map map = new HashMap();
		map.put("message", conf.getMessage());
		map.put("number", conf.getNumber());
		map.put("value", conf.isValue());
		return map;
	}

}

