package com.example.demo.dto;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class NaverNews{
	String title;
    @JsonProperty("originallink")
	String originalLink;
    String link;
    String description;

    Date pubDate;
}