package com.example.demo.service;

import java.nio.charset.Charset;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.dto.PriceMasterInitDTO;
import com.example.demo.dto.TestDTO;
import com.example.demo.entity.Corporation;
import com.example.demo.entity.DartInfo;
import com.example.demo.entity.DartResponse;
import com.example.demo.entity.FinanceInfo;
import com.example.demo.entity.FinanceRatioInfo;
import com.example.demo.repository.CorporationRepository;

@Service
public class FinanceService {
	
	@Autowired
	CorporationRepository corpRepository;
	@Autowired
	RestTemplate restTemplate;
	
	// 별도 Properties로 빼야 함
	String dartKey = "1f7a5f9c76c466ba9078c1f4a167c04b01fb9db4";
	String dataGoKey = "";
	String koscomKey = "l7xx89da28629888447387ba1a69a38847ec";

	// corpCode repository에서 받아와서 가져오기.
	public FinanceRatioInfo getFinanceRatioInfo(String stockCode){
	   
		Corporation corp = corpRepository.findByStockCode(stockCode);
		String corpCode = corp.getCorpCode();
		String corpName = corp.getStockName();
		String marketType = corp.getMarketType().toLowerCase();
		
	    String url = "https://opendart.fss.or.kr/api/fnlttSinglAcnt.json?crtfc_key="+dartKey+"&corp_code="+corpCode+"&bsns_year=2019&reprt_code=11011"; 
	    
	    String url3 = "https://opendart.fss.or.kr/api/fnlttSinglAcnt.json?crtfc_key="+dartKey+"&corp_code="+corpCode+"&bsns_year=2020&reprt_code=11012"; 
	    	
	    
	    // 코드는 나중에 함수화 시켜서 간결하게. 일단 기능 구현 이후 코드 깔끔히. 
	    
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("application","json",Charset.forName("UTF-8")));    //Response Header to UTF-8  
	
		UriComponents builder = UriComponentsBuilder.fromHttpUrl(url)
               .queryParam("serviceKey", dartKey)
               .queryParam("_type", "json")
               .build(false);    //자동으로 encode해주는 것을 막기 위해 false

		ResponseEntity<DartResponse> response =
				 restTemplate.getForEntity(
				  builder.toUriString(),
				  DartResponse.class);
		
		DartResponse dartInfoResponse = response.getBody();

		UriComponents builder3 = UriComponentsBuilder.fromHttpUrl(url3)
	               .queryParam("serviceKey", dartKey)
	               .queryParam("_type", "json")
	               .build(false);    //자동으로 encode해주는 것을 막기 위해 false

			ResponseEntity<DartResponse> response3 =
					 restTemplate.getForEntity(
					  builder3.toUriString(),
					  DartResponse.class);
			
			DartResponse dartInfoResponse2 = response.getBody();

			
		
	    String url2 = "https://sandbox-apigw.koscom.co.kr/v2/market/stocks/"+marketType+"/"+stockCode+"/master?apiKey="+koscomKey; 

	    UriComponents builder2 = UriComponentsBuilder.fromHttpUrl(url2)
	               .queryParam("_type", "json")
	               .build(false);    //자동으로 encode해주는 것을 막기 위해 false
		

		
	   PriceMasterInitDTO resultDTO =  restTemplate.getForEntity(
				  builder2.toUriString(),
				  PriceMasterInitDTO.class).getBody();
	   PriceMasterInitDTO.Result result = resultDTO.getResult();
	   
	   FinanceInfo financeInfo = _initiateFinanceInfo(dartInfoResponse.getList(),dartInfoResponse2.getList(),corpName,stockCode);
	   
//       return null;
       return _initiateFinanceRatioInfo(financeInfo,corpName,stockCode,result.getBps(),result.getEps(),result.getPbr(),result.getPer(),result.getDivYd());
	}
	
	private FinanceInfo _initiateFinanceInfo(List<DartInfo> dartInfos,List<DartInfo> dartInfo2s,String corpName,String stockCode) {
		
		
//		float currentAssetNow = dartInfos.get(0).getThstrmAmount(); // 유동자산
//		float nonCurrentAssetNow = dartInfos.get(9).getThstrmAmount(); // 비유동자산
//		float totalAssetNow = dartInfos.get(18).getThstrmAmount(); // 자산총계
//		float currentLiabilityNow = dartInfos.get(19).getThstrmAmount();  //유동부채
//		float nonCurrentLiabilityNow = dartInfos.get(30).getThstrmAmount(); // 비유동부채
//		float totalLiabilityNow = dartInfos.get(37).getThstrmAmount(); // 부채총계
//		float capitalNow = dartInfos.get(38).getThstrmAmount(); // 자본금
//		float retainedEarningNow = dartInfos.get(42).getThstrmAmount(); //이익잉여금
//		float totalEquityNow = dartInfos.get(44).getThstrmAmount(); // 자본총계
//		float salesNow = dartInfos.get(46).getThstrmAmount(); // 매출액
//		float operatingIncomeNow = dartInfos.get(50).getThstrmAmount(); // 영업이익
//		float incomeBeforeTaxExpenseNow = dartInfos.get(55).getThstrmAmount(); // 법인세차감전 순이익
//		float netIncomeNow = dartInfos.get(58).getThstrmAmount(); // 당기순이익
//		
		double currentAssetNow = dartInfos.get(0).getThstrmAmount(); // 유동자산
		double nonCurrentAssetNow = dartInfos.get(1).getThstrmAmount(); // 비유동자산
		double totalAssetNow = dartInfos.get(2).getThstrmAmount(); // 자산총계
		double currentLiabilityNow = dartInfos.get(3).getThstrmAmount();  //유동부채
		double nonCurrentLiabilityNow = dartInfos.get(4).getThstrmAmount(); // 비유동부채
		double totalLiabilityNow = dartInfos.get(5).getThstrmAmount(); // 부채총계
		double capitalNow = dartInfos.get(6).getThstrmAmount(); // 자본금
		double retainedEarningNow = dartInfos.get(7).getThstrmAmount(); //이익잉여금
		double totalEquityNow = dartInfos.get(8).getThstrmAmount(); // 자본총계
		double salesNow = dartInfos.get(9).getThstrmAmount(); // 매출액
		double operatingIncomeNow = dartInfos.get(10).getThstrmAmount(); // 영업이익
		double incomeBeforeTaxExpenseNow = dartInfos.get(11).getThstrmAmount(); // 법인세차감전 순이익
		double netIncomeNow = dartInfos.get(12).getThstrmAmount(); // 당기순이익
		
		
		double currentAssetPrior = dartInfos.get(0).getFrmtrmAmount(); 
		double nonCurrentAssetPrior = dartInfos.get(1).getFrmtrmAmount();
		double totalAssetPrior = dartInfos.get(2).getFrmtrmAmount();
		double currentLiabilityPrior = dartInfos.get(3).getFrmtrmAmount();
		double nonCurrentLiabilityPrior = dartInfos.get(4).getFrmtrmAmount();
		double totalLiabilityPrior = dartInfos.get(5).getFrmtrmAmount();
		double capitalPrior = dartInfos.get(6).getFrmtrmAmount();
		double retainedEarningPrior = dartInfos.get(7).getFrmtrmAmount();
		double totalEquityPrior = dartInfos.get(8).getFrmtrmAmount();
		double salesPrior = dartInfos.get(9).getFrmtrmAmount();
		double operatingIncomePrior = dartInfos.get(10).getFrmtrmAmount();
		double incomeBeforeTaxExpensePrior = dartInfos.get(11).getFrmtrmAmount();
		double netIncomePrior = dartInfos.get(12).getFrmtrmAmount();
		
		return new FinanceInfo(corpName,stockCode,currentAssetNow,nonCurrentAssetNow,totalAssetNow,currentLiabilityNow,nonCurrentLiabilityNow,
				totalLiabilityNow,capitalNow,retainedEarningNow,totalEquityNow,salesNow,operatingIncomeNow,incomeBeforeTaxExpenseNow,netIncomeNow,
				currentAssetPrior,nonCurrentAssetPrior,totalAssetPrior,currentLiabilityPrior,nonCurrentLiabilityPrior,
				totalLiabilityPrior,capitalPrior,retainedEarningPrior,totalEquityPrior,salesPrior,operatingIncomePrior,incomeBeforeTaxExpensePrior,netIncomePrior
				);
	}
	
	private FinanceRatioInfo _initiateFinanceRatioInfo(FinanceInfo financeInfo, String corpName, String stockCode, float bps,float eps, float pbr, float per, float divYd) {
				
		double currentRatio = financeInfo.getCurrentAssetNow() / financeInfo.getCurrentLiabilityNow() * 100;
		double deptToEquity = financeInfo.getTotalLiabilityNow() / financeInfo.getTotalEquityNow() * 100;
		double returnOnEquity = financeInfo.getNetIncomeNow() / financeInfo.getTotalEquityNow() * 100;
		double returnOnAsset = financeInfo.getNetIncomeNow() / financeInfo.getTotalAssetNow() * 100;
		double operProfit = financeInfo.getOperatingIncomeNow() / financeInfo.getSalesNow() * 100;
		double revenueGrowth = (financeInfo.getSalesNow()-financeInfo.getSalesPrior()) / financeInfo.getSalesPrior() * 100;
		double operIncomeGrowth = (financeInfo.getOperatingIncomeNow() - financeInfo.getOperatingIncomePrior())/ financeInfo.getOperatingIncomePrior() * 100;
		
		float earningPerShare = eps;
		float priceEarningRatio = per;
		float bookvaluePerShare = bps;
		float priceBookvalueRatio = pbr;
		float dividendYield = divYd;
		
		return new FinanceRatioInfo(corpName,stockCode,_customRound(currentRatio),_customRound(deptToEquity),_customRound(returnOnEquity),_customRound(returnOnAsset),_customRound(operProfit),_customRound(revenueGrowth),_customRound(operIncomeGrowth),
				earningPerShare,priceEarningRatio,bookvaluePerShare,priceBookvalueRatio,dividendYield);
	}
	
	private float _customRound(double number) {
		return Math.round(number*100)/ (float)100.0;
	}
}
