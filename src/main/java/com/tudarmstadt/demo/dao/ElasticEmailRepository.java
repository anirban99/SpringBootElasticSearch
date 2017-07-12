package com.tudarmstadt.demo.dao;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.tudarmstadt.demo.customdao.ElasticCustomRepo;
import com.tudarmstadt.demo.model.ElasticEmail;

@Repository
public interface ElasticEmailRepository extends ElasticsearchRepository <ElasticEmail , String>,
ElasticCustomRepo{

	public List <ElasticEmail> findByTextOrSender(String text, String sender);
}
