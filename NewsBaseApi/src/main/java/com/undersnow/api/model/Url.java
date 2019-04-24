package com.undersnow.api.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "urls", type = "url")
public class Url implements Serializable{
	/**
	 * 
	 */
	@Id
	private String id="devoxx";
	private static final long serialVersionUID = 1L;
	private String url,imgUrl,title;
 }