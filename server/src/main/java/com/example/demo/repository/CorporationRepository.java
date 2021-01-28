package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Corporation;

public interface CorporationRepository extends JpaRepository<Corporation,Long> {
	  
	  public Corporation findByStockCode(String stockCode);
	  @Query(nativeQuery = true, value = "select * from corporation c ORDER BY stock_name asc")
	  public List<Corporation> findAllOrderByStockNameAsc();
	  public List<Corporation> findByStockNameContains(String stockName);
}
