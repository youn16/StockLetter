package com.example.demo.dto;

import com.example.demo.entity.Corporation;

import lombok.Data;

@Data
public class IndiCorporationDTO {
	private String stockName;
	private String stockCode;
	private String marketType;
	private String industry;
    private String coreProduct;
    private int stockPrice;
    private int priorPrice;
    private int difference;
    public IndiCorporationDTO(Corporation corp, int stockPrice,int priorPrice,int difference) {
    	this.stockName = corp.getStockName();
    	this.stockCode = corp.getStockCode();
    	this.marketType = corp.getMarketType();
    	this.industry = corp.getIndustry();
    	this.coreProduct = corp.getCoreProduct();
    	this.stockPrice = stockPrice;
    	this.priorPrice = priorPrice;
    	this.difference = difference;
    }
}
