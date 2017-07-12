package com.tudarmstadt.demo;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tudarmstadt.demo.jsonindexer.JsonIndexer;

@SpringBootApplication
@EnableAutoConfiguration
public class SpringBootElasticSearchApplication {

	private static Logger LOGGER;
	
	public static void main(String[] args) {
		
//		if (args.length == 1 && args[0].contains(".json")){
//		SpringApplication.run(SpringBootElasticSearchApplication.class, args);
//		JsonIndexer.setFileName(args[0]);
		
	    if (args.length == 2 && args[0].equals("-input") && args[1].contains(".json")){  
        SpringApplication.run(SpringBootElasticSearchApplication.class, args);
        JsonIndexer.setFileName(args[1]);
	    } else {
		LOGGER.info("Run command: java -jar /target/<file>.jar -input <file>.json");
	  }
   }
}
