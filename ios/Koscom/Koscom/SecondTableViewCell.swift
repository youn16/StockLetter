//
//  SecondTableViewCell.swift
//  Koscom
//
//  Created by SeoungJun Oh on 2021/01/27.
//  Copyright © 2021 SeoungJun Oh. All rights reserved.
//

import UIKit

class SecondTableViewCell: UITableViewCell {

    @IBOutlet weak var fourthView: UIView!
    @IBOutlet weak var thirdView: UIView!
    @IBOutlet weak var secondView: UIView!
    @IBOutlet weak var firstView: UIView!
    @IBOutlet weak var bgView: UIView!
    @IBOutlet weak var currentRatio: UILabel!
    @IBOutlet weak var deptToEquity: UILabel!
    @IBOutlet weak var returnOnAsset: UILabel!
    @IBOutlet weak var returnOnEquity: UILabel!
    @IBOutlet weak var operationProfit: UILabel!
    @IBOutlet weak var revenueGrowth: UILabel!
    @IBOutlet weak var operationIncomeGrowth: UILabel!
    @IBOutlet weak var earningPerShare: UILabel!
    @IBOutlet weak var priceEarningRatio: UILabel!
    @IBOutlet weak var bookvaluePerShare: UILabel!
    @IBOutlet weak var priceBookvalueRatio: UILabel!
    @IBOutlet weak var dividendYield: UILabel!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
        self.bgView.layer.cornerRadius = 50
        self.bgView.layer.masksToBounds=true
        self.firstView.layer.cornerRadius = 50
        self.firstView.layer.masksToBounds=true
        self.secondView.layer.cornerRadius = 50
        self.secondView.layer.masksToBounds=true
        self.thirdView.layer.cornerRadius = 50
        self.thirdView.layer.masksToBounds=true
        self.fourthView.layer.cornerRadius = 50
        self.fourthView.layer.masksToBounds=true
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }

}
