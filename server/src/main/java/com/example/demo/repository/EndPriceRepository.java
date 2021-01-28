package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Corporation;
import com.example.demo.entity.EndPrice;
import com.example.demo.entity.Recommended;

public interface EndPriceRepository extends JpaRepository<EndPrice,Long> {
	  public EndPrice findByStockCode(String stockCode);
}
