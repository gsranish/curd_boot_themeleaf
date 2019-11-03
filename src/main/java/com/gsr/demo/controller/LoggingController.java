package com.gsr.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoggingController {
	
	public static final Logger LOOGER =LoggerFactory.getLogger(LoggingController.class);
	
	@GetMapping("/log")
	public String index() {
		LOOGER.info("logger info started");
		LOOGER.trace("trace info started");
		LOOGER.debug("debug info started");
		LOOGER.warn("warn info started");
		LOOGER.error("error info started");
		
		return "Anish! Check out the Logs to see the output";
		
	}

}
