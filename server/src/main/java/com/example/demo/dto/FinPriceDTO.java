package com.example.demo.dto;

import com.example.demo.entity.FinanceRatioInfo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FinPriceDTO {
	private FinanceRatioInfo financeInfo;
	private PriceInfoDTO priceInfo;
}
