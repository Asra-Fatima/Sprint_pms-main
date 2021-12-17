package com.pms.in;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ComPmsInApplication {

	private static final Logger LOG = LoggerFactory.getLogger(ComPmsInApplication.class);

	public static void main(String[] args) {

		LOG.info("START");
		SpringApplication.run(ComPmsInApplication.class, args);
		LOG.info("END");
	}

}
