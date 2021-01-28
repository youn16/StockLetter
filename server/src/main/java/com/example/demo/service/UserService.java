package com.example.demo.service;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.dto.IssueDTO;
import com.example.demo.dto.MarketQuoteResultDTO;
import com.example.demo.dto.StockPriceDTO;
import com.example.demo.entity.Corporation;
import com.example.demo.entity.DartResponse;
import com.example.demo.entity.FinanceInfo;
import com.example.demo.entity.Subscription;
import com.example.demo.repository.CorporationRepository;
import com.example.demo.repository.SubscriptionRepository;

@Service
public class UserService {

	@Autowired
	SubscriptionRepository subscriptionRepository;
	
	@Autowired
	CorporationRepository corporationRepository;
	
	@Autowired
	CorporationService corporationService;
	

	public List<StockPriceDTO> getStockPrice(List<String> stockList){
		List<Subscription> subscriptionList = getSubscriptionList();
	
		return corporationService.getCorporationWithPriceListBySubscriptionList(subscriptionList);
	}
	
	public List<Subscription> getSubscriptionList() {
		return subscriptionRepository.findAll();
	}
	
	public void registerSubscription(String stockCode) {
		
		Subscription subscription = new Subscription(stockCode);
		if(subscriptionRepository.findByStockCode(stockCode) ==null){
			subscriptionRepository.save(subscription);
		}
	}

	public void removeSubscription(String stockCode) {
		
		Subscription subscription = subscriptionRepository.findByStockCode(stockCode);

		if(subscriptionRepository.findByStockCode(stockCode) != null){
			subscriptionRepository.delete(subscription);
		}
	}
	
}
