package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class RecommendedItem {
	@JsonProperty("stock_name")
	String stockName;
	
	@JsonProperty("stock_code")
	String stockCode;
	
	@JsonProperty("finance_grade")
	String financeGrade;
	
	@JsonProperty("price_grade")
	String priceGrade;	
	
	@JsonProperty("total_market_value")
	float totalMarketValue;

	int rank;
	
}
