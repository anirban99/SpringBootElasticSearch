package com.tudarmstadt.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tudarmstadt.demo.dao.ElasticEmailRepository;
import com.tudarmstadt.demo.jsonindexer.JsonIndexer;
import com.tudarmstadt.demo.model.ElasticEmail;

@Service
public class ElasticService {
	
	@Autowired
	ElasticEmailRepository elasticEmailRepository;
	
	@Autowired
	JsonIndexer jsonIndexer;

	public List<ElasticEmail> findByText(String text){
		
		if(!JsonIndexer.isInitialized()) {
			jsonIndexer.initialize();  
		    }
		
		if(text.contains(" ")) {
		      return elasticEmailRepository.findByText(text);
		    }

		return elasticEmailRepository.findByTextOrSender(text, text);
	}
	
	public void setEmailRepository(ElasticEmailRepository elasticEmailRepository) {
	    this.elasticEmailRepository = elasticEmailRepository;
	  }
	
	public void setJsonIndexer(JsonIndexer jsonIndexer) {
	    this.jsonIndexer = jsonIndexer;
	  }
}
