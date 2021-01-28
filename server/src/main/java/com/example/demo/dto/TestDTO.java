package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TestDTO {
	@JsonProperty("jsonrpc")
	String jsonRpc;
	
	Result result;
	
	@Data
	public class Result{
		double eps;
		double bps;
		double per;
		double pbr;
		double divYd;
	}
}
