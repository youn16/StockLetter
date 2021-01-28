//
//  PracticeViewController.swift
//  Koscom
//
//  Created by SeoungJun Oh on 2021/01/26.
//  Copyright © 2021 SeoungJun Oh. All rights reserved.
//

import UIKit
import Alamofire

class PracticeViewController: UIViewController, UITableViewDelegate,UITableViewDataSource {

    @IBOutlet weak var tableView: UITableView!
    @IBOutlet weak var practiceView: PractiveView!
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        tableView.delegate=self
        tableView.dataSource=self
        
        self.view.backgroundColor = UIColor.systemGray5
        //self.tableView.backgroundColor = UIColor.systemGray5
        
        
        self.practiceView.layer.cornerRadius=20
        self.practiceView.layer.shadowColor = UIColor.black.cgColor
        self.practiceView.layer.shadowOpacity = 0.5
        self.practiceView.layer.shadowOffset = CGSize(width: 10, height: 10)
        self.practiceView.layer.shadowRadius = 10
        
        getData(routeTableView: tableView)
        getCandidatesData()
//        self.tableView.layer.cornerRadius=50
//        self.tableView.layer.masksToBounds = true
        //self.view.backgroundColor = UIColor.systemGray5
//        let footerView = UIView(frame: .init(x: 0, y: 0, width: self.view.frame.width, height: 90))
//        footerView.backgroundColor = UIColor.systemGray5
//        self.tableView.tableFooterView = footerView
    }
    

    override func viewWillAppear(_ animated: Bool) {
        self.tableView.reloadData()
    }
    
    func numberOfSections(in tableView: UITableView) -> Int {
        return 1
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return stockList.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        let cell = tableView.dequeueReusableCell(withIdentifier: "InfoCell", for: indexPath) as! InfoCell
        
        cell.nameLabel.text = stockList[indexPath.row].name
        cell.priceLabel.text = String(stockList[indexPath.row].price)
        cell.stockCode = stockList[indexPath.row].code
        
        let diff = stockList[indexPath.row].difference
        if diff > 0{
            cell.diffLabel.text = "+" + String(stockList[indexPath.row].difference)
            cell.diffLabel.textColor = UIColor.red
            cell.bgView.layer.addBorder([.left], color: UIColor.red, width: 4.0)
        }
        else if diff < 0 {
            cell.diffLabel.text = "" + String(stockList[indexPath.row].difference)
            cell.diffLabel.textColor = UIColor.blue
            cell.bgView.layer.addBorder([.left], color: UIColor.blue, width: 4.0)
        }
        else {
            cell.diffLabel.text = "" + String(stockList[indexPath.row].difference)
            cell.diffLabel.textColor = UIColor.black
            cell.bgView.layer.addBorder([.left], color: UIColor.black, width: 4.0)
        }
        
        
        //cell.bgView.backgroundColor = UIColor.systemGray5
        
        cell.contentView.layer.shadowColor = UIColor.black.cgColor
        cell.contentView.layer.shadowOpacity = 0.2
        cell.contentView.layer.shadowOffset = CGSize(width: 5, height: 5)
        cell.contentView.layer.shadowRadius = 5
        
//        let view = UIView(frame: CGRect(x: 0, y: 0, width: 50, height: 50))
//        view.layer.borderColor = UIColor.red.cgColor
//        view.layer.borderWidth = 1.0
//        cell.contentView.addSubview(view)
        
        return cell
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if segue.identifier=="stockSegue"{
            
            let stockView = segue.destination as! StockViewController
            
            //let button = sender as! UIButton
            
            //let cell=button.superview?.superview?.superview as! InfoCell
            let cell = sender as! InfoCell
            
            stockView.stockName=cell.nameLabel.text!
            stockView.stockPrice=Int(cell.priceLabel.text!)!
            stockView.stockCode=cell.stockCode
        }
    }

}


extension CALayer{
    func addBorder(_ arr_edge: [UIRectEdge], color: UIColor, width: CGFloat){
        for edge in arr_edge {
            let border = CALayer()
            switch edge {
            case UIRectEdge.top:
                border.frame = CGRect.init(x: 0, y: 0, width: frame.width, height: width)
                break
                case UIRectEdge.bottom:
                    border.frame = CGRect.init(x: 0, y: frame.height - width, width: frame.width, height: width)
                break
                case UIRectEdge.left:
                    border.frame = CGRect.init(x: 0, y: 0, width: width, height: frame.height)
                break
                case UIRectEdge.right:
                    border.frame = CGRect.init(x: frame.width - width, y: 0, width: width, height: frame.height)
                break
            default:
                break
            }
            border.backgroundColor = color.cgColor
            self.addSublayer(border)
        }
    }
}
