package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FinanceRatioInfo {
	String stockName;
	String stockCode;

	float currentRatio;
	float deptToEquity;
	float returnOnEquity;
	float returnOnAsset;
	float operationProfit;
	float revenueGrowth;
	float operationIncomeGrowth;
	
	float earningPerShare;
	float priceEarningRatio;
	float bookvaluePerShare;
	float priceBookvalueRatio;
	float dividendYield;

}
