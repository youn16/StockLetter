package com.example.demo.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity(name="end_price")
@Table(name= "end_price")
public class EndPrice {
	@Id
	Long eid;
    @Column(columnDefinition = "create_date")
	Date createDate;
    @Column(columnDefinition = "stock_code")
	String stockCode;
    @Column(columnDefinition = "prior_price")
	int priorPrice;    
}
