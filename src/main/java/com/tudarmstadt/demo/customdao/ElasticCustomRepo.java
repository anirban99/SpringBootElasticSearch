package com.tudarmstadt.demo.customdao;

import java.util.List;

import com.tudarmstadt.demo.model.ElasticEmail;


public interface ElasticCustomRepo {
	
	public List<ElasticEmail> findByText(String text);

}
