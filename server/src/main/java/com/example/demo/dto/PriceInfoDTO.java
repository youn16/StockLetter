package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PriceInfoDTO {
	private String stockName;
	private String stockCode;
	private int openPrice;
	private int highPrice;
	private int lowPrice;
	private int tradePrice;

}
