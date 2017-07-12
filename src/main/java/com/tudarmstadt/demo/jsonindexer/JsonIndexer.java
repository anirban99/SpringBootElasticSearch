package com.tudarmstadt.demo.jsonindexer;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tudarmstadt.demo.dao.ElasticEmailRepository;
import com.tudarmstadt.demo.model.ElasticEmail;

@Component
public class JsonIndexer {
	
	private static Logger LOGGER = Logger.getLogger("Log");

	  @Autowired
	  ElasticEmailRepository elasticEmailRepository;

	  public static boolean initialized = false;

	  public static String fileName;

	  private int totalEmails;

	  public void initialize() {
	    ObjectMapper mapper = new ObjectMapper();

	    try {
	    	elasticEmailRepository.deleteAll();
	    	ElasticEmail [] elasticEmails = mapper.readValue(new File(fileName), ElasticEmail[].class);
	      for (ElasticEmail elasticEmail : elasticEmails) {
	    	  elasticEmail.setDocid(elasticEmail.getId().toString());
	      }
	      
	      elasticEmailRepository.save(Arrays.asList(elasticEmails));
	      
	      LOGGER.info(elasticEmails.length + " Emails saved");
	      
	      initialized = true;
	      totalEmails = elasticEmails.length;
	    } catch (IOException e) {
	      LOGGER.severe(fileName + " is not found");
	    }
	  }

	  public static void setFileName(String file) {
	    fileName = file;
	  }

	  public int getTotalEmails() {
	    return totalEmails;  
	  }
	  
	  public static boolean isInitialized() {
	    return initialized;
	  }

}
