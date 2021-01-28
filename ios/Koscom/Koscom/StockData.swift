//
//  StockData.swift
//  Koscom
//
//  Created by SeoungJun Oh on 2021/01/24.
//  Copyright © 2021 SeoungJun Oh. All rights reserved.
//

import Foundation

class Stock: Codable{
    var name:String
    var price:Int
    var code:String
    var type:String
    var priorPrice:Int
    var difference:Int
    
    init(name:String, price:Int, code:String, type:String, priorPrice:Int, difference:Int) {
        self.name=name
        self.price=price
        self.code=code
        self.type=type
        self.priorPrice=priorPrice
        self.difference=difference
    }
    
    enum CodingKeys: String, CodingKey {
        case name = "stockName"
        case price = "stockPrice"
        case code = "stockCode"
        case type = "marketType"
        case priorPrice = "priorPrice"
        case difference = "difference"
    }
}

class StockInfo: Codable{
    var name:String
    var price:Int
    var code:String
    var type:String
    var priorPrice:Int
    var difference:Int
    
    init(name:String, price:Int, code:String, type:String, priorPrice:Int, difference:Int) {
        self.name=name
        self.price=price
        self.code=code
        self.type=type
        self.priorPrice=priorPrice
        self.difference=difference
    }
    
    enum CodingKeys: String, CodingKey {
        case name = "stockName"
        case price = "stockPrice"
        case code = "stockCode"
        case type = "marketType"
        case priorPrice = "priorPrice"
        case difference = "difference"
    }
}

class FinanceInfo: Codable{
    var stockName:String
    var stockCode:String
    var currentRatio:Float
    var deptToEquity:Float
    var returnOnEquity:Float
    var returnOnAsset:Float
    var operationProfit:Float
    var revenueGrowth:Float
    var operationIncomeGrowth:Float
    var earningPerShare:Float
    var priceEarningRatio:Float
    var bookvaluePerShare:Float
    var priceBookvalueRatio:Float
    var dividendYield:Float
    
    init(stockName:String, stockCode:String, currentRatio:Float, deptToEquity:Float, returnOnEquity:Float, returnOnAsset:Float, operationProfit:Float, revenueGrowth:Float, operationIncomeGrowth:Float, earningPerShare:Float, priceEarningRatio:Float, bookvaluePerShare:Float, priceBookvalueRatio:Float, dividendYield:Float) {
        self.stockName=stockName
        self.stockCode=stockCode
        self.currentRatio=currentRatio
        self.deptToEquity=deptToEquity
        self.returnOnEquity=returnOnEquity
        self.returnOnAsset=returnOnAsset
        self.operationProfit=operationProfit
        self.revenueGrowth=revenueGrowth
        self.operationIncomeGrowth=operationIncomeGrowth
        self.earningPerShare=earningPerShare
        self.priceEarningRatio=priceEarningRatio
        self.bookvaluePerShare=bookvaluePerShare
        self.priceBookvalueRatio=priceBookvalueRatio
        self.dividendYield=dividendYield
    }
    
}

class News: Codable {
    var title:String
    var originalLink:String
    var link:String
    var description:String
    var pubDate:String
    
    init(title:String, originalLink:String, link:String, description:String, pubDate:String) {
        self.title=title
        self.originalLink=originalLink
        self.link=link
        self.description=description
        self.pubDate=pubDate
    }
}

class RecommendCorp: Codable {
    var stockCode:String
    var stockName:String
    var characterType:Int
    var marketType:String
    var recommendedDate:String
    var financeGrade:String
    var priceGrade:String
    var totalMarketValue:String
    var rank:Int
    var price:Int
    
    init(stockCode:String, stockName:String, characterType:Int, marketType:String, recommendedDate:String, financeGrade:String, priceGrade:String, totalMarketValue:String, rank:Int, price:Int) {
        self.stockCode=stockCode
        self.stockName=stockName
        self.characterType=characterType
        self.marketType=marketType
        self.recommendedDate=recommendedDate
        self.financeGrade=financeGrade
        self.priceGrade=priceGrade
        self.totalMarketValue=totalMarketValue
        self.rank=rank
        self.price=price
    }
    
}



var globalURL = "http://15.164.102.110:8080"
//var globalURL = "http://192.168.100.112:8080"
var stockList:[Stock] = []
var stockNewsList:[News] = []
var financeInfo:FinanceInfo? = nil
var stockInfoList:[StockInfo] = []
var recommendCorpList:[RecommendCorp] = []
//Stock(name: "삼성전자", price: 88000, code :"1234"),
//Stock(name: "셀트리온", price: 70000, code :"1234"),
//Stock(name: "쿠팡", price: 1797980, code :"1234"),
//Stock(name: "아침햇살", price: 380129, code :"1234"),
//Stock(name: "메이플스토리", price: 39000, code :"1234")


//Stock(name: "셀트리온", price: 70000),
//Stock(name: "쿠팡", price: 1797980),
//Stock(name: "아침햇살", price: 380129),
//Stock(name: "메이플스토리", price: 39000),
//Stock(name: "잡주1", price: 39000),
//Stock(name: "잡주2", price: 49000),
//Stock(name: "잡주3", price: 59000),
//Stock(name: "잡주4", price: 69000),
//Stock(name: "잡주5", price: 19000),
//Stock(name: "잡주6", price: 29000),
//Stock(name: "잡주7", price: 39000),
//Stock(name: "잡주8", price: 49000)]
