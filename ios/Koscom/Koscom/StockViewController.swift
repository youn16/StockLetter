//
//  StockViewController.swift
//  Koscom
//
//  Created by SeoungJun Oh on 2021/01/25.
//  Copyright © 2021 SeoungJun Oh. All rights reserved.
//

import UIKit

class StockViewController: UIViewController {

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

        // Do any additional setup after loading the view.
        self.navigationItem.title=stockName
        //self.navigationItem.rightBarButtonItem = UIBarButtonItem(image: UIImage(systemName: "heart"), style: .plain, target: nil, action: nil)
        self.navigationItem.rightBarButtonItem = self.rightButton

        checkSubscribe()
        getFinanceData(stockCode: stockCode)
        getStockData(stockCode: stockCode)
        
        //getNewsData(stockCode: stockCode)
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
                    var newStock=Stock(name: stockName, price: stockPrice, code :"068270", type :"KOSPI", priorPrice: 123, difference: 234)
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

    
    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */

}
