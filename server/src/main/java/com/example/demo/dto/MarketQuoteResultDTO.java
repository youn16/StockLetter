package com.example.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class MarketQuoteResultDTO {
    @JsonProperty("jsonrpc")
	String jsonRpc;
    
    Result result;
    
    @Data
    public class Result{
        @JsonProperty("isulist")
        List<IssueDTO> isuList;    	
    }

}
