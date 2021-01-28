package com.example.demo.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.PumpStreamHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.dto.CorporationCodeDTO;
import com.example.demo.dto.CorporationDTO;
import com.example.demo.dto.FinPriceDTO;
import com.example.demo.dto.IndiCorporationDTO;
import com.example.demo.dto.IssueDTO;
import com.example.demo.dto.MarketQuoteDTO;
import com.example.demo.dto.MarketQuoteResultDTO;
import com.example.demo.dto.NaverNews;
import com.example.demo.dto.NaverNewsDTO;
import com.example.demo.dto.NewsDTO;
import com.example.demo.dto.PriceInfoDTO;
import com.example.demo.dto.PriceInfoInitDTO;
import com.example.demo.dto.RecommendedItemDTO;
import com.example.demo.dto.SimilarCorporationDTO;
import com.example.demo.dto.StockAnalyzerDTO;
import com.example.demo.dto.StockAnalyzerDTO.Result;
import com.example.demo.dto.StockPriceDTO;
import com.example.demo.entity.Corporation;
import com.example.demo.entity.EndPrice;
import com.example.demo.entity.FinanceRatioInfo;
import com.example.demo.entity.Recommended;
import com.example.demo.entity.RecommendedItem;
import com.example.demo.entity.RecommendedResultDTO;
import com.example.demo.entity.SimilarStock;
import com.example.demo.entity.Subscription;
import com.example.demo.repository.CorporationRepository;
import com.example.demo.repository.EndPriceRepository;
import com.example.demo.repository.RecommendedRepository;

@Service
public class CorporationService {
	@Autowired
	CorporationRepository corporationRepository;
	
	@Autowired
	RecommendedRepository recommendedRepository;
	
	@Autowired
	EndPriceRepository endPriceRepository;
	
	@Autowired
	FinanceService financeService;
	
	@Autowired
	RestTemplate restTemplate;
	
	String koscomKey = "l7xx89da28629888447387ba1a69a38847ec";
	String clientId = "WcfVYNvKxNCx_km0RMNx";
	String clientSecret = "I66a2ptdIM";
	public List<CorporationDTO> getCorporationList() {
		List<Corporation> corporations = corporationRepository.findAllOrderByStockNameAsc();
		List<CorporationDTO> corpDTO = new ArrayList<CorporationDTO>();
		for(Corporation corp : corporations ) {
			corpDTO.add(new CorporationDTO(corp.getStockName(),corp.getStockCode(),corp.getMarketType()));
		}
		return corpDTO;
	}
	
	public FinPriceDTO getFinanceAndPrice(String stockCode){
		FinanceRatioInfo ratioInfo = financeService.getFinanceRatioInfo(stockCode);
		PriceInfoDTO priceInfo = getPriceInfo(stockCode);
		return new FinPriceDTO(ratioInfo,priceInfo);
	}
	public IndiCorporationDTO getStockInfoByStockCode(String stockCode){
		Corporation corp =  corporationRepository.findByStockCode(stockCode);	
		
		int price = getIndividualPrice(stockCode);
		int priorPrice = endPriceRepository.findByStockCode(stockCode).getPriorPrice();
		int difference = price-priorPrice;
		return new IndiCorporationDTO(corp,price,priorPrice,difference);
	}
	
	public List<CorporationDTO> getCorporationList(String name) {
		List<CorporationDTO> corpDTO = new ArrayList<CorporationDTO>();
		List<Corporation> corporations = corporationRepository.findByStockNameContains(name);
		for(Corporation corp : corporations ) {
			corpDTO.add(new CorporationDTO(corp.getStockName(),corp.getStockCode(),corp.getMarketType()));
		}
		
		return corpDTO;
	}
	
//	public List<RecommendedItemDTO> getCorporationWithPriceListByCharacter(int characterType){
//		int count = 0;
//		List<RecommendedItemDTO> recommendedItemDTOList = new ArrayList<RecommendedItemDTO>();
//		List<String> stockCodeList = new ArrayList<String>();
//				
//		String url = "https://sandbox-apigw.koscom.co.kr/v1/bigbot/ranked_stock_indicators/?type="+characterType+"&apikey="+koscomKey;
//	    // 코드는 나중에 함수화 시켜서 간결하게. 일단 기능 구현 이후 코드 깔끔히.     
//
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(new MediaType("application","json",Charset.forName("UTF-8")));    //Response Header to UTF-8  
//		
//	    UriComponents builder = UriComponentsBuilder.fromHttpUrl(url)
//               .queryParam("_type", "json")
//               .build(false);    //자동으로 encode해주는 것을 막기 위해 false
//	    
//		ResponseEntity<RecommendedItem[]> response =
//				 restTemplate.getForEntity(
//				  builder.toUriString(),RecommendedItem[].class);
//	
//		RecommendedItem[] recommendedItemArray = response.getBody();
//			
//		String stockPriceString = "";
//		
//		stockPriceString = stockPriceString.substring(0, stockPriceString.length()-1);
//		
//		String url2 = "https://sandbox-apigw.koscom.co.kr/v2/market/multiquote/stocks/kospi/price?isuCd="+stockPriceString+"&apikey="+koscomKey;
//	    // 코드는 나중에 함수화 시켜서 간결하게. 일단 기능 구현 이후 코드 깔끔히.     
//		
//		headers = new HttpHeaders();
//		headers.setContentType(new MediaType("application","json",Charset.forName("UTF-8")));    //Response Header to UTF-8  
//	
//	    builder = UriComponentsBuilder.fromHttpUrl(url2)
//               .queryParam("_type", "json")
//               .build(false);    //자동으로 encode해주는 것을 막기 위해 false
//	    
//		ResponseEntity<MarketQuoteResultDTO> response2 =
//				 restTemplate.getForEntity(
//				  builder.toUriString(),
//				  MarketQuoteResultDTO.class);
//		
//		List<IssueDTO> issueList = response2.getBody().getResult().getIsuList();
//		
//		count =0;
//		
//		for(IssueDTO issue : issueList) {
//			if(count==10) {
//				break;
//			}
//			recommendedItemDTOList.get(count).setStockPrice(issue.getTrdPrc());
//			count +=1;
//		}
//						
//		return null;
//	}
	
	public List<RecommendedResultDTO> getCorporationWithPriceListByCharacter(int characterType){
		
		List<Recommended> itemList = recommendedRepository.findByCharacterTypeOrderByRankAsc(characterType);
		
		String kospiStockCode = "";
		String kosdaqStockCode = "";
		
		List<RecommendedResultDTO> kospiList = new ArrayList<RecommendedResultDTO>();
		List<RecommendedResultDTO> kosdaqList = new ArrayList<RecommendedResultDTO>();
		
		for(Recommended item: itemList) {
			if( item.getMarketType().equals("KOSPI") ){
				kospiStockCode = kospiStockCode.concat(item.getStockCode()).concat(",");			
				kospiList.add(new RecommendedResultDTO(item));
			}
			
			else {
				kosdaqStockCode= kosdaqStockCode.concat(item.getStockCode()).concat(",");
				kosdaqList.add(new RecommendedResultDTO(item));
			}
		}
		
		kospiStockCode = kospiStockCode.substring(0, kospiStockCode.length()-1);
		kosdaqStockCode = kosdaqStockCode.substring(0, kosdaqStockCode.length()-1);

		
		_setPriceInRecommendedResultDTO("kospi",kospiStockCode,kospiList);
		_setPriceInRecommendedResultDTO("kosdaq",kosdaqStockCode,kosdaqList);
			
		kospiList.addAll(kosdaqList);
		
		return kospiList;
	}

	
	public List<StockPriceDTO> getCorporationWithPriceListBySubscriptionList(List<Subscription> subscriptionList) {
		int count = 0;
		List<StockPriceDTO> kospiPriceList= new ArrayList<StockPriceDTO>();
		List<StockPriceDTO> kosdaqPriceList= new ArrayList<StockPriceDTO>();
		String kospiString = "";
		String kosdaqString = "";
		
		for (Subscription subscription : subscriptionList) {	
			String stockCode = subscription.getStockCode();
			Corporation corporation = corporationRepository.findByStockCode(stockCode);
			EndPrice endPrice = endPriceRepository.findByStockCode(stockCode);
			StockPriceDTO stockPriceDTO = new StockPriceDTO(corporation.getStockName(),corporation.getStockCode(),corporation.getMarketType());
			stockPriceDTO.setPriorPrice(endPrice.getPriorPrice());
			if(corporation.getMarketType().equals("KOSPI")) {
				
				kospiString = kospiString.concat(stockCode).concat(",");
				
				kospiPriceList.add(stockPriceDTO);
			}
			else {
				kosdaqString =kosdaqString.concat(stockCode).concat(",");
				kosdaqPriceList.add(stockPriceDTO);
			}	
		}
		
		if(kospiString != "") {
			kospiString = kospiString.substring(0, kospiString.length()-1);			
			_setPriceResultDTO("kospi",kospiString,kospiPriceList);
		}
		
		if(kosdaqString != "") {
			kosdaqString = kosdaqString.substring(0, kosdaqString.length()-1);
			_setPriceResultDTO("kosdaq",kosdaqString,kosdaqPriceList);
		}			
		kospiPriceList.addAll(kosdaqPriceList);
		
		return kospiPriceList;	
	}
	
	private List<StockPriceDTO> _setPriceResultDTO(String marketType, String stockPriceString, List<StockPriceDTO> stockPriceDTOList) {
		
		if(stockPriceDTOList.size() >1 ) {
			int count = 0;
			String url = "https://sandbox-apigw.koscom.co.kr/v2/market/multiquote/stocks/"+marketType.toLowerCase()+"/price?isuCd="+stockPriceString+"&apikey="+koscomKey;
		    // 코드는 나중에 함수화 시켜서 간결하게. 일단 기능 구현 이후 코드 깔끔히.     
		    RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(new MediaType("application","json",Charset.forName("UTF-8")));    //Response Header to UTF-8  
		
		    UriComponents builder = UriComponentsBuilder.fromHttpUrl(url)
	               .queryParam("_type", "json")
	               .build(false);    //자동으로 encode해주는 것을 막기 위해 false
		    
			ResponseEntity<MarketQuoteResultDTO> response =
					restTemplate.getForEntity(
					builder.toUriString(),
					MarketQuoteResultDTO.class		
					);
				
			List<IssueDTO> issueList = response.getBody().getResult().getIsuList();
			
			for(IssueDTO issue : issueList) {	
				stockPriceDTOList.get(count).setStockPrice(issue.getTrdPrc());
				stockPriceDTOList.get(count).setDifference(issue.getTrdPrc() - stockPriceDTOList.get(count).getPriorPrice());
				count +=1;
			}
			return stockPriceDTOList;

		}
		else {
			int count = 0;
			String url = "https://sandbox-apigw.koscom.co.kr/v2/market/stocks/"+marketType+"/"+stockPriceString+"/price?apiKey="+koscomKey;
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(new MediaType("application","json",Charset.forName("UTF-8")));    //Response Header to UTF-8  
		
		    UriComponents builder = UriComponentsBuilder.fromHttpUrl(url)
	               .queryParam("_type", "json")
	               .build(false);    //자동으로 encode해주는 것을 막기 위해 false
		    
			ResponseEntity<MarketQuoteDTO> response =
	
					restTemplate.getForEntity(
					builder.toUriString(),
					MarketQuoteDTO.class
					
					);
			
			stockPriceDTOList.get(0).setStockPrice(response.getBody().getResult().getTrdPrc());			
			stockPriceDTOList.get(0).setDifference(response.getBody().getResult().getTrdPrc() - stockPriceDTOList.get(count).getPriorPrice());

			return stockPriceDTOList;
		}
		      
//	   
//		if(stockPriceDTOList.size() >1 ) {
//			int count = 0;
//			String url = "https://sandbox-apigw.koscom.co.kr/v2/market/multiquote/stocks/"+marketType.toLowerCase()+"/price?isuCd="+stockPriceString+"&apikey="+koscomKey;
//	
//			// 코드는 나중에 함수화 시켜서 간결하게. 일단 기능 구현 이후 코드 깔끔히.     
//		   
//			HttpHeaders headers = new HttpHeaders();
//			headers.setContentType(new MediaType("application","json",Charset.forName("UTF-8")));    //Response Header to UTF-8  
//		
//		    UriComponents builder = UriComponentsBuilder.fromHttpUrl(url)
//	               .queryParam("_type", "json")
//	               .build(false);    //자동으로 encode해주는 것을 막기 위해 false
//		    
//			ResponseEntity<MarketQuoteResultDTO> response =
//	
//					restTemplate.getForEntity(
//					builder.toUriString(),
//					MarketQuoteResultDTO.class
//					
//					);
//			
//			List<IssueDTO> issueList = response.getBody().getResult().getIsuList();
//			
//			for(IssueDTO issue : issueList) {
//				recommendedResultDTOList.get(count).setPrice(issue.getTrdPrc());
//				count +=1;	
//			}
//			return recommendedResultDTOList;
//		}	
//		else {
//			int count = 0;
//
//			String url = "https://sandbox-apigw.koscom.co.kr/v2/market/stocks/"+marketType+"/"+stockPriceString+"/price?apiKey="+koscomKey;
//	
//			// 코드는 나중에 함수화 시켜서 간결하게. 일단 기능 구현 이후 코드 깔끔히.     
//		   
//			HttpHeaders headers = new HttpHeaders();
//			headers.setContentType(new MediaType("application","json",Charset.forName("UTF-8")));    //Response Header to UTF-8  
//		
//		    UriComponents builder = UriComponentsBuilder.fromHttpUrl(url)
//	               .queryParam("_type", "json")
//	               .build(false);    //자동으로 encode해주는 것을 막기 위해 false
//		    
//			ResponseEntity<MarketQuoteDTO> response =
//	
//					restTemplate.getForEntity(
//					builder.toUriString(),
//					MarketQuoteDTO.class
//					
//					);
//			
//			recommendedResultDTOList.get(0).setPrice(response.getBody().getResult().getTrdPrc());			
//			return recommendedResultDTOList;
//		}
	}

	
	public List<SimilarStock> getSimilarCorporationByStockCode(String stockCode){
		
		String url = "https://sandbox-apigw.koscom.co.kr/v1/bigbot/stock_analyzer/?code="+stockCode+"&apikey="+koscomKey;
	    
	    // 코드는 나중에 함수화 시켜서 간결하게. 일단 기능 구현 이후 코드 깔끔히. 
	    
	    RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("application","json",Charset.forName("UTF-8")));    //Response Header to UTF-8  
	
	    UriComponents builder = UriComponentsBuilder.fromHttpUrl(url)
               .queryParam("_type", "json")
               .build(false);    //자동으로 encode해주는 것을 막기 위해 false
	    
    
		ResponseEntity<StockAnalyzerDTO> response =
				 restTemplate.getForEntity(
				  builder.toUriString(),
				  StockAnalyzerDTO.class);
		
		Result result = response.getBody().getResult();
		
		SimilarStock financeBest = result.getFinanceBest();
		SimilarStock pmBest = result.getPmBest();
	
		
		
		return null;
	}

	
	public List<NewsDTO> getNewsInformationByStockCode(String stockCode){
		
        String apiURL = "https://openapi.naver.com/v1/search/news.json?query=" + stockCode + "&sort=date&display=12";
        

    	HttpHeaders headers = new HttpHeaders();

    	headers.add("X-Naver-Client-Id", clientId);
    	headers.add("X-Naver-Client-Secret", clientSecret);
    	headers.setContentType(new MediaType("application","json",Charset.forName("UTF-8")));    //Response Header to UTF-8  

    	HttpEntity entity = new HttpEntity(headers);

    	UriComponents builder = UriComponentsBuilder.fromHttpUrl(apiURL)
                   .queryParam("_type", "json")
                   .build(false);    //자동으로 encode해주는 것을 막기 위해 false
    	    
        
    	ResponseEntity<NaverNewsDTO> response =
   			 restTemplate.exchange(
   				  builder.toUriString(),HttpMethod.GET,entity,
   				NaverNewsDTO.class);

    	List<NaverNews> itemList = response.getBody().getItems();
    	List<NewsDTO> newsList = new ArrayList<NewsDTO>();

    	for (NaverNews news : itemList) {
    		String title = news.getTitle();
    		title = title.replace("<b>", "");
            title = title.replace("</b>", "");
            title = title.replace("&quot", "");
            title = title.replace("&nbsp", "");
            title = title.replace("&amp", "");
            title = title.replace(";", "");
            
            String description = news.getDescription();
            description = description.replace("<b>", "");
            description = description.replace("</b>", "");
            description = description.replace("&quot", "");
            description = description.replace("&nbsp", "");
            description = description.replace("&amp", "");
            description = description.replace(";", "");
            
            DateFormat format = new SimpleDateFormat("yyyy.MM.dd HH:MM");
            String date = format.format(news.getPubDate());

            newsList.add(new NewsDTO(title,news.getOriginalLink(),news.getLink(),description,date));
    	}
		return newsList;
	}
	
//	public List<NewsDTO> getNewsInformationByStockCode(String stockCode){
//		
//		List<NewsDTO> newsList= new ArrayList<NewsDTO>();
//		String[] command = new String[4];
////        command[0] = "python";
//		
//		command[0] = "python3";
//        command[1] = "~/hackathon.py";
//
//
//        command[2] = stockCode;
//
//         		
//        String string ="";
//        
//        try {
//            string = execPython(command);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    
//        String[] strArr = string.split(" _url_dlm");
//        
//        for (String str : strArr) {
//        	
//        	if(str.isEmpty()) {
//        		break;
//        	}
//        	String[] newsArr = str.split(" _dlm");        	
//        	
//        	String url = newsArr[0];
//        	String title = newsArr[1];
//        	String writer = newsArr[2];
//        	String time = newsArr[3];
//        	String img = newsArr[4];
//        	String text = newsArr[5];
//        	
//        	newsList.add(new NewsDTO(url,title,writer,time,img,text));
//        }
//        
//		return newsList;
//	}
	
	public PriceInfoDTO getPriceInfo(String stockCode) {
		
		Corporation corporation = corporationRepository.findByStockCode(stockCode);
		String marketType = corporation.getMarketType();
		
		String url = "https://sandbox-apigw.koscom.co.kr/v2/market/stocks/"+marketType.toLowerCase()+"/"+stockCode+"/price?apikey="+koscomKey;
		
		// 코드는 나중에 함수화 시켜서 간결하게. 일단 기능 구현 이후 코드 깔끔히.     
	   
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("application","json",Charset.forName("UTF-8"))); 
		
	    UriComponents builder = UriComponentsBuilder.fromHttpUrl(url)
               .queryParam("_type", "json")
               .build(false);    //자동으로 encode해주는 것을 막기 위해 false
	    
		ResponseEntity<PriceInfoInitDTO> response =
				restTemplate.getForEntity(
				builder.toUriString(),
				PriceInfoInitDTO.class
		);
		
		PriceInfoInitDTO.Result priceInfoInitDTO = response.getBody().getResult();
		
		return new PriceInfoDTO(corporation.getStockName(),stockCode,priceInfoInitDTO.getOpnprc(),priceInfoInitDTO.getHgprc(),priceInfoInitDTO.getLwprc(),priceInfoInitDTO.getTrdprc());
		
	}
	
	
	
	
	
	private List<RecommendedResultDTO> _setPriceInRecommendedResultDTO(String marketType, String stockPriceString, List<RecommendedResultDTO> recommendedResultDTOList) {
		
		
		if(recommendedResultDTOList.size() >1 ) {
			int count = 0;
			String url = "https://sandbox-apigw.koscom.co.kr/v2/market/multiquote/stocks/"+marketType.toLowerCase()+"/price?isuCd="+stockPriceString+"&apikey="+koscomKey;
	
			// 코드는 나중에 함수화 시켜서 간결하게. 일단 기능 구현 이후 코드 깔끔히.     
		   
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(new MediaType("application","json",Charset.forName("UTF-8")));    //Response Header to UTF-8  
		
		    UriComponents builder = UriComponentsBuilder.fromHttpUrl(url)
	               .queryParam("_type", "json")
	               .build(false);    //자동으로 encode해주는 것을 막기 위해 false
		    
			ResponseEntity<MarketQuoteResultDTO> response =
	
					restTemplate.getForEntity(
					builder.toUriString(),
					MarketQuoteResultDTO.class
					
					);
			
			List<IssueDTO> issueList = response.getBody().getResult().getIsuList();
			
			for(IssueDTO issue : issueList) {
				recommendedResultDTOList.get(count).setPrice(issue.getTrdPrc());
				count +=1;	
			}
			return recommendedResultDTOList;
		}	
		else {
			int count = 0;

			String url = "https://sandbox-apigw.koscom.co.kr/v2/market/stocks/"+marketType+"/"+stockPriceString+"/price?apiKey="+koscomKey;
	
			// 코드는 나중에 함수화 시켜서 간결하게. 일단 기능 구현 이후 코드 깔끔히.     
		   
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(new MediaType("application","json",Charset.forName("UTF-8")));    //Response Header to UTF-8  
		
		    UriComponents builder = UriComponentsBuilder.fromHttpUrl(url)
	               .queryParam("_type", "json")
	               .build(false);    //자동으로 encode해주는 것을 막기 위해 false
		    
			ResponseEntity<MarketQuoteDTO> response =
	
					restTemplate.getForEntity(
					builder.toUriString(),
					MarketQuoteDTO.class
					
					);
			
			recommendedResultDTOList.get(0).setPrice(response.getBody().getResult().getTrdPrc());			
			return recommendedResultDTOList;
		}
	}
	
	public String execPython(String[] command) throws IOException, InterruptedException {

		CommandLine commandLine = CommandLine.parse(command[0]);
        for (int i = 1, n = command.length; i < n; i++) {
            commandLine.addArgument(command[i]);
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PumpStreamHandler pumpStreamHandler = new PumpStreamHandler(outputStream);

        DefaultExecutor executor = new DefaultExecutor();
        
        executor.setStreamHandler(pumpStreamHandler);
        int result = executor.execute(commandLine);
        
        return outputStream.toString("EUC-KR");
         
    }  
	
	public int getIndividualPrice(String stockCode){

		Corporation corporation = corporationRepository.findByStockCode(stockCode);
		String marketType = corporation.getMarketType();
		
		String url = "https://sandbox-apigw.koscom.co.kr/v2/market/stocks/"+marketType.toLowerCase()+"/"+stockCode+"/price?apikey="+koscomKey;
		
		// 코드는 나중에 함수화 시켜서 간결하게. 일단 기능 구현 이후 코드 깔끔히.     
	   
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("application","json",Charset.forName("UTF-8"))); 
		
	    UriComponents builder = UriComponentsBuilder.fromHttpUrl(url)
               .queryParam("_type", "json")
               .build(false);    //자동으로 encode해주는 것을 막기 위해 false
	    
		ResponseEntity<PriceInfoInitDTO> response =
				restTemplate.getForEntity(
				builder.toUriString(),
				PriceInfoInitDTO.class
		);
		
		PriceInfoInitDTO.Result priceInfoInitDTO = response.getBody().getResult();
		
		return priceInfoInitDTO.getTrdprc();
         
    }  
	

}
