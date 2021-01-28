package com.example.demo.dto;

import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NewsDTO {
//	String newsUrl;
//	String newsTitle;
//
//	String newsWriter;
//	String newsTime;
//	String newsImg;
//	String newsText;
	
	String title;

	String originalLink;
    String link;
    String description;
    
    String pubDate;
    
}
