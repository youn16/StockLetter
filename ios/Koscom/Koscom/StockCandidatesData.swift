//
//  StockCandidatesData.swift
//  Koscom
//
//  Created by SeoungJun Oh on 2021/01/27.
//  Copyright © 2021 SeoungJun Oh. All rights reserved.
//

import Foundation


class candidate: Codable{
    var name:String
    var type:String
    var code:String
    
    init(name:String, type:String, code:String) {
        self.name=name
        self.type=type
        self.code=code
    }
    
    enum CodingKeys: String, CodingKey {
        case name = "stockName"
        case type = "marketType"
        case code = "stockCode"
    }
}

var stockCandidates:[candidate] = []

var tempCandidates:[candidate] = []
