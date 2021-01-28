package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FinanceInfo {
	String stockName;
	String stockCode;
	
	double currentAssetNow;
	double nonCurrentAssetNow;
	double totalAssetNow;
	double currentLiabilityNow;
	double nonCurrentLiabilityNow;
	double totalLiabilityNow;
	double capitalNow;
	double retainedEarningNow;
	double totalEquityNow;
	double salesNow;
	double operatingIncomeNow;
	double incomeBeforeTaxExpenseNow;
	double netIncomeNow;
	
	double currentAssetPrior;
	double nonCurrentAssetPrior;
	double totalAssetPrior;
	double currentLiabilityPrior;
	double nonCurrentLiabilityPrior;
	double totalLiabilityPrior;
	double capitalPrior;
	double retainedEarningPrior;
	double totalEquityPrior;
	double salesPrior;
	double operatingIncomePrior;
	double incomeBeforeTaxExpensePrior;
	double netIncomePrior;
	
}
