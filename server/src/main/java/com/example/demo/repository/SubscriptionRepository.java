package com.example.demo.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription,Long> {
	
	public Subscription findByStockCode(String stockCode);
	
}
