package com.example.demo.dto;

import java.util.List;

import com.example.demo.entity.FinanceBest;
import com.example.demo.entity.PmBest;
import com.example.demo.entity.SimilarStock;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class StockAnalyzerDTO {
	
    private Result result;	  
    @Data
	public class Result{
       	
    	@JsonProperty("pm_best")
    	PmBest pmBest;
    	
    	@JsonProperty("finance_best")
    	FinanceBest financeBest;
    	
    	@JsonProperty("similar_stocks")
    	List<SimilarStock> similarStocks;
    
	}
}
