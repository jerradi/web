package com.undersnow.api.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

import com.undersnow.api.model.Url;

public interface UrlRepository extends ElasticsearchCrudRepository< Url ,String > {
 
}
