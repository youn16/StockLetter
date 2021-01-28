package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CorporationDTO {
	private String stockName;
	private String stockCode;
	private String marketType;
}
