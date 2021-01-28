//
//  ThirdTableViewCell.swift
//  Koscom
//
//  Created by SeoungJun Oh on 2021/01/27.
//  Copyright © 2021 SeoungJun Oh. All rights reserved.
//

import UIKit

class ThirdTableViewCell: UITableViewCell {

    @IBOutlet weak var titleLable: UILabel!
    @IBOutlet weak var subTitleLabel: UILabel!
    @IBOutlet weak var bgView: BgView!
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
