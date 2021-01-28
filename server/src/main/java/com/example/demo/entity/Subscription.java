package com.example.demo.entity;

import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity(name="Subscription")
@Table(name= "Subscription")
@RequiredArgsConstructor
public class Subscription {
    @Id
    @Column(columnDefinition = "stock_code", nullable = false)
    private String stockCode;
    
    public Subscription(String stockCode) {
    	this.stockCode = stockCode;
    }
    
}
