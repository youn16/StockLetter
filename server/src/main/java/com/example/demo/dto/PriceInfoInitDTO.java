package com.example.demo.dto;

import java.util.List;

import com.example.demo.dto.MarketQuoteResultDTO.Result;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
@Data
public class PriceInfoInitDTO {
	@JsonProperty("jsonrpc")
	String jsonRpc;
	    
	Result result;
	    
	@Data
	public class Result{
		int opnprc;
		int hgprc;
		int lwprc;
		@JsonProperty("trdPrc")
		int trdprc;
	}
	
}
