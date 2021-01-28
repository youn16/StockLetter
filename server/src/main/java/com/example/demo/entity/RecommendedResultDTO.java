package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;

import lombok.Data;

@Data
public class RecommendedResultDTO {

	private String stockCode;   	
    private String stockName;
    private int characterType;    
    private String marketType;
    private Date recommendedDate;
    private String financeGrade;
    private String priceGrade;
    private String totalMarketValue;   
    private int rank;
	private int price;
	private int follower;
	
	public RecommendedResultDTO(Recommended recommended) {
		this.stockCode = recommended.getStockCode();   	
	    this.stockName = recommended.getStockName();
	    this.characterType = recommended.getCharacterType();    
	    this.marketType= recommended.getMarketType();
	    this.recommendedDate = recommended.getRecommendedDate();
	    this.financeGrade= recommended.getFinanceGrade();
	    this.priceGrade= recommended.getPriceGrade();
	    this.totalMarketValue= Float.toString(recommended.getTotalMarketValue());   
	    this.rank= recommended.getRank();

	}
}
