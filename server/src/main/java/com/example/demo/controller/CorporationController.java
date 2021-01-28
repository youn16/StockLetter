package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CorporationCodeDTO;
import com.example.demo.dto.CorporationDTO;
import com.example.demo.dto.FinPriceDTO;
import com.example.demo.dto.IndiCorporationDTO;
import com.example.demo.dto.NaverNews;
import com.example.demo.dto.NewsDTO;
import com.example.demo.dto.PriceInfoDTO;
import com.example.demo.dto.RecommendedItemDTO;
import com.example.demo.dto.SimilarCorporationDTO;
import com.example.demo.dto.StockPriceDTO;
import com.example.demo.entity.Corporation;
import com.example.demo.entity.FinanceRatioInfo;
import com.example.demo.entity.RecommendedResultDTO;
import com.example.demo.entity.SimilarStock;
import com.example.demo.service.CorporationService;
import com.example.demo.service.FinanceService;
import com.example.demo.service.UserService;

@RestController
@RequestMapping(value="/stock")
public class CorporationController {
	@Autowired
	CorporationService corpService;
	
	@Autowired
	FinanceService financeService;
	
	@RequestMapping(value="",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CorporationDTO> getCorporation(@RequestParam(required=false) String stockName) {		
		if(stockName == null) {
			return corpService.getCorporationList();
		}
		else {
			return corpService.getCorporationList(stockName);	
		}
	}
	
	@GetMapping(value="/{stockCode}",produces = MediaType.APPLICATION_JSON_VALUE)
	public IndiCorporationDTO getStockInfo(@PathVariable String stockCode) {		
		return corpService.getStockInfoByStockCode(stockCode);
		// Service 내로 집어넣을것		
	}
	
	@RequestMapping(value="/{stockCode}/similar",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<SimilarStock> getBasicSimilarInfo(@PathVariable String stockCode) {		
		return corpService.getSimilarCorporationByStockCode(stockCode);
		// Service 내로 집어넣을것		
	}

	
	@RequestMapping(value="/recommendation",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<RecommendedResultDTO> getBasicFinanceInfo(@RequestParam int characterType) {		
		return corpService.getCorporationWithPriceListByCharacter(characterType);
		// Service 내로 집어넣을것		
	}
	
	//key 값 별도 Property로 뺄 것.
	
	@GetMapping(value = "/{stockCode}/finance",produces = MediaType.APPLICATION_JSON_VALUE)
	public FinanceRatioInfo getBasicFinanceInfo(@PathVariable String stockCode) {
		 // Service 내로 집어넣을것
		 return financeService.getFinanceRatioInfo(stockCode);	
	}
	
	@GetMapping(value = "/{stockCode}/priceInfo",produces = MediaType.APPLICATION_JSON_VALUE)
	public PriceInfoDTO getBasicPriceInfo(@PathVariable String stockCode) {
		 // Service 내로 집어넣을것
		 return corpService.getPriceInfo(stockCode);	
	}
	
	@GetMapping(value = "/{stockCode}/news",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<NewsDTO> getBasicNewsInfo(@PathVariable String stockCode) {
		 // Service 내로 집어넣을것
		 return corpService.getNewsInformationByStockCode(stockCode);	
	}

	@GetMapping(value = "/{stockCode}/finPrice",produces = MediaType.APPLICATION_JSON_VALUE)
	public FinPriceDTO getFinanceAndPrice(@PathVariable String stockCode) {
		 // Service 내로 집어넣을것
		 return corpService.getFinanceAndPrice(stockCode);	
	}
}
