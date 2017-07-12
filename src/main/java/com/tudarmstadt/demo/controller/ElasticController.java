package com.tudarmstadt.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tudarmstadt.demo.model.ElasticEmail;
import com.tudarmstadt.demo.service.ElasticService;

@RestController
@RequestMapping("/search")
@CrossOrigin
public class ElasticController {
	
	@Autowired
	public ElasticService elasticService;
	
	@RequestMapping(path = "/text", method = RequestMethod.GET)
	public List<ElasticEmail> getAllEmail(@RequestParam String text){
		
		List<ElasticEmail> emails = elasticService.findByText(text);
		
		return emails;
	}

}