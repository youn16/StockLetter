//
//  CallAPI.swift
//  Koscom
//
//  Created by SeoungJun Oh on 2021/01/27.
//  Copyright © 2021 SeoungJun Oh. All rights reserved.
//

import Foundation
import Alamofire

func getURL(url:String, params:[String: Any]) -> URL {
        let urlParams = params.compactMap({ (key, value) -> String in
        return "\(value)"
        }).joined(separator: "/")
        let withURL = url + "/\(urlParams)"
        let encoded = withURL.addingPercentEncoding(withAllowedCharacters: .urlQueryAllowed)! //+ "&serviceKey=" + metroKey
        return URL(string:encoded)!
    }
    
func getData(routeTableView:UITableView?){  //내가 구독하고 있는 기업들의 정보 받아오는 메소드
        let url = globalURL + "/user/subscription"
        
        AF.request(url,method: .get).validate()
        .responseString { response in
        print(" - API url: \(String(describing: response.request!))")

        //if case success
        switch response.result {
            case .success(let value):
            let responseString = NSString(data: response.data!, encoding:
            String.Encoding.utf8.rawValue )
            //let xml = try! XML.parse(String(responseString!))
            print(responseString)
                    
            
            stockList.removeAll()
            let decoder = JSONDecoder()
            do{
                let stocks = try decoder.decode([Stock].self, from: response.data!)
                for stock in stocks{
                    stockList.append(stock)
                }
            } catch{
                print(error)
            }
            routeTableView?.reloadData()
                    
            case .failure(let error):
                print(error)
                
            }
        }
        
    
}

func doSubscribe(stockCode:String){ //기업 구독 메소드

    let url = globalURL + "/user/subscription/" + stockCode
        
    AF.request(url,method: .post).validate()
    .responseString { response in
    print(" - API url: \(String(describing: response.request!))")

        //if case success
    switch response.result {
        case .success(let value):
            print(response.data!)
//        let responseString = NSString(data: response.data!, encoding:
//        String.Encoding.utf8.rawValue )
//        print(responseString)
                    
        case .failure(let error):
            print(error)
                
        }
    }
        
}

func undoSubscribe(stockCode:String){   //기업 구독 취소 메소드

    let url = globalURL + "/user/subscription/" + stockCode
        
    AF.request(url,method: .delete).validate()
    .responseString { response in
    print(" - API url: \(String(describing: response.request!))")

        //if case success
    switch response.result {
        case .success(let value):
            print(response.data!)
//        let responseString = NSString(data: response.data!, encoding:
//        String.Encoding.utf8.rawValue )
//        print(responseString)
                    
        case .failure(let error):
            print(error)
                
        }
    }
        
}

func getCandidatesData(){   //자동완성 전체 후보군 받아오는 메소드

        let url = globalURL + "/stock"
        
        AF.request(url,method: .get).validate()
        .responseString { response in
        print(" - API url: \(String(describing: response.request!))")

        //if case success
        switch response.result {
            case .success(let value):
            let responseString = NSString(data: response.data!, encoding:
            String.Encoding.utf8.rawValue )
            //let xml = try! XML.parse(String(responseString!))
            //print(responseString)
                    
            //if let json = try? JSONSerialization.jsonObject(with: response.data!, options: []) as? [[AnyHashable:Any]]
            
            let decoder = JSONDecoder()
            do{
                let stocks = try decoder.decode([candidate].self, from: response.data!)
                for stock in stocks{
                    //print(stock.name)
                    stockCandidates.append(stock)
                }
            } catch{
                print(error)
            }
                    
            case .failure(let error):
                print(error)
                
            }
        }
        
}

func getStockData(stockCode:String){

        let url = globalURL + "/stock/" + stockCode
        
        AF.request(url,method: .get).validate()
        .responseString { response in
        print(" - API url: \(String(describing: response.request!))")

        //if case success
        switch response.result {
            case .success(let value):
            let responseString = NSString(data: response.data!, encoding:
            String.Encoding.utf8.rawValue )
            //let xml = try! XML.parse(String(responseString!))
            print(responseString)
                    
            
            let decoder = JSONDecoder()
            do{
                let stockInfo = try decoder.decode(StockInfo.self, from: response.data!)
            } catch{
                print(error)
            }
                    
            case .failure(let error):
                print(error)
                
            }
        }
        
}


func getFinanceData(stockCode : String){    //재무재표 받아오는 메소드

        let url = globalURL + "/stock/" + stockCode + "/finance"
        
        AF.request(url,method: .get).validate()
        .responseString { response in
        print(" - API url: \(String(describing: response.request!))")

        //if case success
        switch response.result {
            case .success(let value):
            let responseString = NSString(data: response.data!, encoding:
            String.Encoding.utf8.rawValue )
            
            print(responseString)
            
            
            let decoder = JSONDecoder()
            do{
                let stocks = try decoder.decode(FinanceInfo.self, from: response.data!)
                print(stocks)
            } catch{
                print(error)
            }
                    
            case .failure(let error):
                print(error)
                
            }
        }
        
}


func getNewsData(stockCode : String, tableView : UITableView){    //재무재표 받아오는 메소드

        let url = globalURL + "/stock/" + stockCode + "/news"
        
        AF.request(url,method: .get).validate()
        .responseString { response in
        print(" - API url: \(String(describing: response.request!))")

        //if case success
        switch response.result {
            case .success(let value):
            let responseString = NSString(data: response.data!, encoding:
            String.Encoding.utf8.rawValue )
            
            print(responseString)
            
            
            let decoder = JSONDecoder()
            do{
                stockNewsList = try decoder.decode([News].self, from: response.data!)
            } catch{
                print(error)
            }
                    
            tableView.reloadData()
            case .failure(let error):
                print(error)
                
            }
        }
        
}
