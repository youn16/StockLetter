//
//  RecommendationTableViewCell.swift
//  Koscom
//
//  Created by SeoungJun Oh on 2021/01/28.
//  Copyright © 2021 SeoungJun Oh. All rights reserved.
//

import UIKit

class RecommendationTableViewCell: UITableViewCell {

    @IBOutlet weak var typeImage: UIImageView!
    @IBOutlet weak var nameLabel: UILabel!
    @IBOutlet weak var typeLabel: UILabel!
    @IBOutlet weak var priceLabel: UILabel!
    var cod:String = ""
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }

}
