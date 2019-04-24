package com.undersnow.api;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchAutoConfiguration;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchDataAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.undersnow.api.model.Url;
import com.undersnow.api.repository.UrlRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication(exclude = { ElasticsearchAutoConfiguration.class, ElasticsearchDataAutoConfiguration.class })
public class NewsBaseApi {

	public static void main(String[] args) {
		SpringApplication.run(NewsBaseApi.class, args);
	}

}

/**
 * 
 * @author undersnow
 *
 */
@Slf4j
@RestController
class PublicController {

	@Autowired
	private UrlRepository repo;

	private static Set<Url> urls = new HashSet<>();

 
	@GetMapping("addedUrls")
	public Set<Url> getUrl() {
	 Set<Url> mySet = new HashSet<>();
		  repo.findAll().forEach(x->mySet.add(x));
		 return mySet;
	}

	@GetMapping("del")
	public  Boolean delAll() {
	 Set<Url> mySet = new HashSet<>();
	 try {
		 repo. deleteAll();
		 return true;
	} catch (Exception e) {
		 
	}
		  
		 return false;
	}

	 

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, value = "addUrl")
	public void addUrl(@RequestBody Url url) {
		repo.save(url);
	}
}
