package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity(name="Corporation")
@Table(name= "Corporation")
public class Corporation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cid;
    
    @Column(columnDefinition = "stock_name", nullable = false)
    private String stockName;
    
    @Column(columnDefinition = "stock_code", nullable = false)
    private String stockCode;
    
    @Column(columnDefinition = "market_type", nullable = false)
    private String marketType;
    
    @Column(columnDefinition = "corp_code", nullable = false)
    private String corpCode;

    @Column
    private String industry;
    
    @Column(columnDefinition = "core_product", nullable = false)
    private String coreProduct;
}
