package com.example.demo.dto;

import lombok.Data;

@Data
public class StockPriceDTO {
	String stockName;
	String stockCode;
	String marketType;
	int stockPrice;
	int priorPrice;
	int difference;
	
	public StockPriceDTO(String stockName, String stockCode,String marketType) {
		this.stockName = stockName;
		this.stockCode = stockCode;
		this.marketType = marketType;
	}
}
