package com.example.demo.entity;

import com.example.demo.dto.StockAnalyzerDTO;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimilarStock{
	@JsonProperty("stock_name")
	String stockName;
	@JsonProperty("stock_code")
	String stockCode;
	float finance;
	@JsonProperty("price_merit")
	float priceMerit;
}

