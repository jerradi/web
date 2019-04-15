package com.undersnow.api;
 
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Data;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

@RestController
class PublicController{
	
	@GetMapping("getUrls")
	public List<Url> getUrls(){
		return getRandomList();
	}
	public List<Url> getRandomList() {
		 return  Arrays.asList("7cdd58c2a0,2c5b5f7cdd58", "25716 --- [o-auto-1-exec-2] ", "9-04-15 14:05:33.657  INFO [demo-serv").stream().map(r-> new Url(r, r, r.substring(0, 5))).collect(Collectors.toList());
	}
}

@Data
@AllArgsConstructor
class Url {
	private String url,imgUrl,title;
	
}