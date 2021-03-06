//
//  RecommendationTableViewController.swift
//  Koscom
//
//  Created by SeoungJun Oh on 2021/01/28.
//  Copyright © 2021 SeoungJun Oh. All rights reserved.
//

import UIKit

class RecommendationTableViewController: UITableViewController {

    override func viewDidLoad() {
        super.viewDidLoad()

        // Uncomment the following line to preserve selection between presentations
        // self.clearsSelectionOnViewWillAppear = false

        // Uncomment the following line to display an Edit button in the navigation bar for this view controller.
        // self.navigationItem.rightBarButtonItem = self.editButtonItem
        getRecommendationData(investType: "1", tableView: self.tableView)
    }

    // MARK: - Table view data source

    override func numberOfSections(in tableView: UITableView) -> Int {
        // #warning Incomplete implementation, return the number of sections
        return 1
    }

    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        // #warning Incomplete implementation, return the number of rows
        return recommendCorpList.count
    }

    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "RecommendationTableViewCell", for: indexPath) as! RecommendationTableViewCell

        // Configure the cell...
        cell.nameLabel.text = recommendCorpList[indexPath.row].stockName
        cell.typeLabel.text = "현재 " + String(Int.random(in: 5...15)) + "명이 구독하고 있습니다."
        cell.priceLabel.text = String(recommendCorpList[indexPath.row].price)
        cell.cod = recommendCorpList[indexPath.row].stockCode
        let type = recommendCorpList[indexPath.row].marketType
        if type == "KOSPI" {
            cell.typeImage.image = UIImage(named: "kospi.png")
        }
        else {
            cell.typeImage.image = UIImage(named: "kosdaq.png")
        }
        return cell
    }
    
//    override func tableView(_ tableView: UITableView, titleForHeaderInSection section: Int) -> String? {
//        return "기업 추천"
//    }
    
    override func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
        return 80
    }
    /*
    // Override to support conditional editing of the table view.
    override func tableView(_ tableView: UITableView, canEditRowAt indexPath: IndexPath) -> Bool {
        // Return false if you do not want the specified item to be editable.
        return true
    }
    */

    /*
    // Override to support editing the table view.
    override func tableView(_ tableView: UITableView, commit editingStyle: UITableViewCell.EditingStyle, forRowAt indexPath: IndexPath) {
        if editingStyle == .delete {
            // Delete the row from the data source
            tableView.deleteRows(at: [indexPath], with: .fade)
        } else if editingStyle == .insert {
            // Create a new instance of the appropriate class, insert it into the array, and add a new row to the table view
        }    
    }
    */

    /*
    // Override to support rearranging the table view.
    override func tableView(_ tableView: UITableView, moveRowAt fromIndexPath: IndexPath, to: IndexPath) {

    }
    */

    /*
    // Override to support conditional rearranging of the table view.
    override func tableView(_ tableView: UITableView, canMoveRowAt indexPath: IndexPath) -> Bool {
        // Return false if you do not want the item to be re-orderable.
        return true
    }
    */

    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
            if segue.identifier == "stockSegue"{
                
                let stockView = segue.destination as! TPTableViewController
                
                //let button = sender as! UIButton
                
                //let cell=button.superview?.superview as! SearchCell
                let cell = sender as! RecommendationTableViewCell
                
    //            stockView.stockName=cell.nameLabel.text!
                stockView.stockCode=cell.cod
                stockView.stockName=cell.nameLabel.text!
            }
        }
}
