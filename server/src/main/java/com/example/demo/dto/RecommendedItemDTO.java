package com.example.demo.dto;

import com.example.demo.entity.RecommendedItem;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class RecommendedItemDTO {

	String stockName;
	String stockCode;
	
	String financeGrade;
	String priceGrade;
	float totalMarketValue;
    int rank;

    int stockPrice;    
    
    String marketType;
    
    public RecommendedItemDTO(RecommendedItem item) {
    	this.stockName = item.getStockName();
    	this.stockCode = item.getStockCode();
    	
    	this.financeGrade = item.getFinanceGrade();
    	this.priceGrade = item.getPriceGrade();
    	this.totalMarketValue = item.getTotalMarketValue();
    	this.rank = item.getRank();
    	
    }
    
    public RecommendedItemDTO(RecommendedItem item,String marketType) {
    	this.stockName = item.getStockName();
    	this.stockCode = item.getStockCode();
    	
    	this.financeGrade = item.getFinanceGrade();
    	this.priceGrade = item.getPriceGrade();
    	this.totalMarketValue = item.getTotalMarketValue();
    	this.rank = item.getRank();
    	this.marketType = marketType;
    	
    }
}
