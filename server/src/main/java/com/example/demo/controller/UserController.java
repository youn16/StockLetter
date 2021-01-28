package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.StockPriceDTO;
import com.example.demo.entity.FinanceRatioInfo;
import com.example.demo.entity.Subscription;
import com.example.demo.service.FinanceService;
import com.example.demo.service.UserService;

@RestController
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping(value = "/subscription",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<StockPriceDTO> getSubscriptionDTO() {
		 // Service 내로 집어넣을것
		List<String> a = new ArrayList<String>();		
		return userService.getStockPrice(a);
	}
	
	@PostMapping(value = "/subscription/{stockCode}",produces = MediaType.APPLICATION_JSON_VALUE)
	public void registerSubscriptionDTO(@PathVariable String stockCode) {
		 // Service 내로 집어넣을것
		userService.registerSubscription(stockCode); 
	}	
	
	@DeleteMapping(value = "/subscription/{stockCode}",produces = MediaType.APPLICATION_JSON_VALUE)
	public void removeSubscriptionDTO(@PathVariable String stockCode) {
		 // Service 내로 집어넣을것
		userService.removeSubscription(stockCode); 
	}	
}
