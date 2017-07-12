package com.tudarmstadt.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;

import com.tudarmstadt.demo.customdao.ElasticCustomRepo;
import com.tudarmstadt.demo.model.ElasticEmail;


public class ElasticCustomService implements ElasticCustomRepo {

	@Autowired
	private ElasticsearchTemplate elasticSearchTemplate;
	
	@Override
	public List<ElasticEmail> findByText(String text) { 
		
		NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
	    
		MatchQueryBuilder matchPhraseQuery =  QueryBuilders.matchPhrasePrefixQuery("text",text);
	    nativeSearchQueryBuilder.withQuery(matchPhraseQuery);	    
	    NativeSearchQuery nativeSearchQuery = nativeSearchQueryBuilder.build();
	    
	    Page<ElasticEmail> queryForPage = elasticSearchTemplate.queryForPage(nativeSearchQuery, ElasticEmail.class);
	    
	    List<ElasticEmail> elasticEmail = new ArrayList<>();
	    queryForPage.forEach(page -> {
	       elasticEmail.add(page);
	    });
	    
	    return elasticEmail;
	}

}
