//
//  InfoCell.swift
//  Koscom
//
//  Created by SeoungJun Oh on 2021/01/21.
//  Copyright © 2021 SeoungJun Oh. All rights reserved.
//

import UIKit

class InfoCell: UITableViewCell {

    
    @IBOutlet weak var nameLabel: UILabel!
    @IBOutlet weak var priceLabel: UILabel!
    @IBOutlet weak var diffLabel: UILabel!
    @IBOutlet weak var bgView: UIView!
    @IBOutlet weak var typeImage: UIImageView!
    var stockCode:String = ""
    
    override func awakeFromNib() {
        super.awakeFromNib()

        // Initialization code
        self.bgView.layer.cornerRadius = 10
        self.bgView.layer.masksToBounds=true
        
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }

}
