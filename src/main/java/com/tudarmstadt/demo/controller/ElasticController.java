package com.tudarmstadt.demo.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tudarmstadt.demo.model.ElasticEmail;
import com.tudarmstadt.demo.service.ElasticService;

@RestController
@RequestMapping("/search")
@Api(value = "ElasticControllerAPI")
@CrossOrigin
public class ElasticController {
	
	@Autowired
	public ElasticService elasticService;
	
	@RequestMapping(path = "/text", method = RequestMethod.GET)
	@ApiOperation("Gets the emails with specific text")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = ElasticEmail.class)})
	public List<ElasticEmail> getAllEmail(@RequestParam String text){
		
		List<ElasticEmail> emails = elasticService.findByText(text);
		
		return emails;
	}

}