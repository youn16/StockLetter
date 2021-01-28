package com.example.demo.entity;

import com.example.demo.util.FlexibleFloatDeserializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Data;

@Data
public class DartInfo {

    @JsonProperty("bsns_year")
	String bsnsYear;
    @JsonProperty("corp_code")
	String corpCode;
    @JsonProperty("stock_code")
	String stockCode;
    @JsonProperty("account_nm")
	String accountNm;
    @JsonProperty("thstrm_amount")
    @JsonDeserialize(using = FlexibleFloatDeserializer.class)
    float thstrmAmount;
    @JsonProperty("frmtrm_amount")
    @JsonDeserialize(using = FlexibleFloatDeserializer.class)
    float frmtrmAmount;
    String ord;
	

}


