package com.example.demo.entity;

import java.util.List;

import lombok.Data;

@Data
public class DartResponse {
	String status;
	String message;
	List<DartInfo> list;
}
