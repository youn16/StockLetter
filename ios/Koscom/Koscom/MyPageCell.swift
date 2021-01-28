//
//  MyPageCell.swift
//  Koscom
//
//  Created by SeoungJun Oh on 2021/01/27.
//  Copyright © 2021 SeoungJun Oh. All rights reserved.
//

import UIKit

class MyPageCell: UITableViewCell {

    @IBOutlet weak var nameLabel: UILabel!
    @IBOutlet weak var attributeLabel: UILabel!
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
