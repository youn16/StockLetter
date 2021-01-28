//
//  MyPageViewController.swift
//  Koscom
//
//  Created by SeoungJun Oh on 2021/01/25.
//  Copyright © 2021 SeoungJun Oh. All rights reserved.
//

import UIKit

class MyPageViewController: UIViewController, UITableViewDelegate, UITableViewDataSource {

    @IBOutlet weak var tableView: UITableView!
    override func viewDidLoad() {
        super.viewDidLoad()

        tableView.delegate=self
        tableView.dataSource=self
        // Do any additional setup after loading the view.
    }
    
    func numberOfSections(in tableView: UITableView) -> Int {
            return 1
        }
        
        func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
            return 1
        }
        
        func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
            
            let cell = tableView.dequeueReusableCell(withIdentifier: "MyPageCell", for: indexPath) as! MyPageCell
            
            cell.nameLabel.text = "장효진"
            cell.attributeLabel.text = "성향 : 없음"
            
            
            
            //cell.bgView.backgroundColor = UIColor.systemGray5
            
            cell.contentView.layer.shadowColor = UIColor.black.cgColor
            cell.contentView.layer.shadowOpacity = 0.2
            cell.contentView.layer.shadowOffset = CGSize(width: 5, height: 5)
            cell.contentView.layer.shadowRadius = 5
    
            
            return cell
        }

}
