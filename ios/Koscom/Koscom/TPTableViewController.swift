//
//  TPTableViewController.swift
//  Koscom
//
//  Created by SeoungJun Oh on 2021/01/27.
//  Copyright © 2021 SeoungJun Oh. All rights reserved.
//

import UIKit

class TPTableViewController: UITableViewController  {

    var stockName:String = ""
    var stockPrice:Int = 0
    var stockCode:String = ""
    var isSubscribed:Bool = false
    
    lazy var rightButton: UIBarButtonItem = {
        let button = UIBarButtonItem(title: "right", style: .plain, target: self, action: #selector(buttonPressed(_:)))
        //self.rightButton.image = UIImage(systemName: "heart")
        button.tag = 1
        return button
        
    }()
    
    override func viewDidLoad() {
        super.viewDidLoad()

        self.navigationItem.title=stockName
        //self.navigationItem.rightBarButtonItem = UIBarButtonItem(image: UIImage(systemName: "heart"), style: .plain, target: nil, action: nil)
        self.navigationItem.rightBarButtonItem = self.rightButton
        checkSubscribe()
        
        self.view.backgroundColor = UIColor.systemGray5
        
        
        getStockData(stockCode: stockCode, tableView: self.tableView)
        getFinanceData(stockCode: stockCode, tableView: self.tableView)
        getNewsData(stockCode: stockCode, tableView: self.tableView)
    }

    func checkSubscribe() {
        self.rightButton.image = UIImage(systemName: "heart")
        for stockPair in stockList{
            if stockPair.name==stockName{
                self.rightButton.image = UIImage(systemName: "heart.fill")
                isSubscribed = !isSubscribed
                break
            }
        }
    }
    
    
    @objc private func buttonPressed(_ sender: Any) {
        if let button = sender as? UIBarButtonItem {
            switch button.tag {
            case 1: // Change the background color to blue.
                if !isSubscribed{
                    self.rightButton.image = UIImage(systemName: "heart.fill")
                    var newStock=Stock(name: stockInfoList[0].name, price: stockInfoList[0].price, code :stockInfoList[0].code, type :stockInfoList[0].type, priorPrice: stockInfoList[0].priorPrice, difference: stockInfoList[0].difference)
                    stockList.append(newStock)
                    doSubscribe(stockCode: newStock.code)
                }
                else{
                    self.rightButton.image = UIImage(systemName: "heart")
                    
                    var idx:Int = 0
                    for stockPair in stockList{
                        if stockPair.name==stockName{
                            undoSubscribe(stockCode: stockPair.code)
                            stockList.remove(at:idx )
                            break
                        }
                        idx+=1
                    }
                }
                isSubscribed = !isSubscribed
            
            default:
                print("error")
            }
        }
    }
    // MARK: - Table view data source

    override func numberOfSections(in tableView: UITableView) -> Int {
        // #warning Incomplete implementation, return the number of sections
        return 3
    }

    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        // #warning Incomplete implementation, return the number of rows
        if section == 1{
            if let fi = financeInfo {
                return 1
            }
            else {
                return 0
            }
        }
        else if section == 2 {
            return stockNewsList.count
        }
        return stockInfoList.count
    }

    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        switch indexPath.section{
        case 0:
            let cell = tableView.dequeueReusableCell(withIdentifier: "FirstTableViewCell", for: indexPath) as! FirstTableViewCell
            
            cell.nameLabel.text = stockInfoList[indexPath.row].name
            cell.priceLabel.text = String(stockInfoList[indexPath.row].price)
            
            let type = stockInfoList[indexPath.row].type
            if type == "KOSPI" {
                cell.typeImage.image = UIImage(named: "kospi.png")
            }
            else {
                cell.typeImage.image = UIImage(named: "kosdaq.png")
            }
            
            let diff = stockInfoList[indexPath.row].difference
            if diff > 0{
                cell.diffLabel.text = "+" + String(stockInfoList[indexPath.row].difference)
                cell.diffLabel.textColor = UIColor.red
                cell.layer.addBorder([.left], color: UIColor.red, width: 4.0)
            }
            else if diff < 0 {
                cell.diffLabel.text = "" + String(stockInfoList[indexPath.row].difference)
                cell.diffLabel.textColor = UIColor.blue
                cell.layer.addBorder([.left], color: UIColor.blue, width: 4.0)
            }
            else {
                cell.diffLabel.text = "" + String(stockInfoList[indexPath.row].difference)
                cell.diffLabel.textColor = UIColor.black
                cell.layer.addBorder([.left], color: UIColor.black, width: 4.0)
            }
            return cell
        case 1:
            let cell = tableView.dequeueReusableCell(withIdentifier: "SecondTableViewCell", for: indexPath) as! SecondTableViewCell
            
            if let fi = financeInfo {
                cell.currentRatio.text = String(fi.currentRatio)+"%"
                cell.deptToEquity.text = String(fi.deptToEquity)+"%"
                cell.returnOnEquity.text = String(fi.returnOnEquity)+"%"
                cell.returnOnAsset.text = String(fi.returnOnAsset)+"%"
                cell.operationProfit.text = String(fi.operationProfit)+"%"
                cell.revenueGrowth.text = String(fi.revenueGrowth)+"%"
                cell.operationIncomeGrowth.text = String(fi.operationIncomeGrowth)+"%"
                cell.earningPerShare.text = String(fi.earningPerShare)
                cell.priceEarningRatio.text = String(fi.priceEarningRatio)+"%"
                cell.bookvaluePerShare.text = String(fi.bookvaluePerShare)
                cell.priceBookvalueRatio.text = String(fi.priceBookvalueRatio)+"%"
                cell.dividendYield.text = String(fi.dividendYield)+"%"
            }
            cell.firstView.layer.addBorder([.bottom], color: UIColor.black, width: 1.0)
            cell.firstView.layer.addBorder([.left], color: UIColor.black, width: 1.0)
            cell.secondView.layer.addBorder([.bottom], color: UIColor.black, width: 1.0)
            cell.secondView.layer.addBorder([.right], color: UIColor.black, width: 1.0)
            cell.thirdView.layer.addBorder([.right], color: UIColor.black, width: 1.0)
            cell.thirdView.layer.addBorder([.top], color: UIColor.black, width: 1.0)
            cell.fourthView.layer.addBorder([.top], color: UIColor.black, width: 1.0)
            cell.fourthView.layer.addBorder([.left], color: UIColor.black, width: 1.0)
            
            return cell
        case 2:
            let cell = tableView.dequeueReusableCell(withIdentifier: "ThirdTableViewCell", for: indexPath) as! ThirdTableViewCell
            
            cell.titleLable.text! = stockNewsList[indexPath.row].title
            cell.subTitleLabel.text! = stockNewsList[indexPath.row].pubDate
            
            //cell.backgroundColor = UIColor.systemGray5
            
            cell.contentView.layer.shadowColor = UIColor.black.cgColor
            cell.contentView.layer.shadowOpacity = 0.2
            cell.contentView.layer.shadowOffset = .zero
            cell.contentView.layer.shadowRadius = 5
            return cell
        default:
            let cell = tableView.dequeueReusableCell(withIdentifier: "FirstTableViewCell", for: indexPath) as! FirstTableViewCell
            
            
            return cell
        }
        let cell = tableView.dequeueReusableCell(withIdentifier: "FirstTableViewCell", for: indexPath) as! FirstTableViewCell
        return cell
    }
    
    override func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        if indexPath.section != 2 {
            return
        }
        
        guard let url = URL(string : stockNewsList[indexPath.row].link) else {
            return
        }
        
        if UIApplication.shared.canOpenURL(url) {
            UIApplication.shared.open(url, options: [:], completionHandler: nil)
        } else {
            print("Cannot open url")
        }
    }
    
    override func tableView(_ tableView: UITableView, titleForHeaderInSection section: Int) -> String? {
        if section == 2 {
            return "관련 뉴스"
        }
        return nil
    }

}
