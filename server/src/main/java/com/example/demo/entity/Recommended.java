package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Entity(name="Recommended")
@Table(name= "Recommended")
@Data
public class Recommended {
	@Id
	@Column(columnDefinition = "stock_code", nullable = false)
    private String stockCode;
    
    @Column(nullable = false)
    private String stockName;
    
    @Column(columnDefinition = "character_type", nullable = false)
    private int characterType;
    
    @Column(columnDefinition = "market_type", nullable = false)
    private String marketType;
    
    @CreatedDate
    @Column(columnDefinition = "recommended_date", nullable = false)
    private Date recommendedDate;
    
    @Column(columnDefinition = "finance_grade", nullable = false)
	String financeGrade;
	
    @Column(columnDefinition = "price_grade", nullable = false)
	String priceGrade;	
	
    @Column(columnDefinition = "total_market_value", nullable = false)
	float totalMarketValue;
    
    @Column(columnDefinition = "rank", nullable = false)
	int rank;
}
