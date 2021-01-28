package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class PriceMasterInitDTO {
	@JsonProperty("jsonrpc")
	String jsonrpc;
	Result result;	
	
	@Data
	public class Result{
		float eps;
		float bps;
		float per;
		float pbr;
		float divYd;
	}
}
