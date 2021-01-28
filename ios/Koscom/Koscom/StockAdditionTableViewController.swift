//
//  StockAdditionTableViewController.swift
//  Koscom
//
//  Created by SeoungJun Oh on 2021/01/25.
//  Copyright © 2021 SeoungJun Oh. All rights reserved.
//

import UIKit

class StockAdditionTableViewController: UITableViewController, UISearchBarDelegate, UISearchControllerDelegate {

    var StockSearchBar:UISearchBar? = nil
    let StockSearchController = UISearchController()
    
    var candidates:Array<candidate> = []
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Uncomment the following line to preserve selection between presentations
        // self.clearsSelectionOnViewWillAppear = false

        // Uncomment the following line to display an Edit button in the navigation bar for this view controller.
        // self.navigationItem.rightBarButtonItem = self.editButtonItem
        
        StockSearchBar = StockSearchController.searchBar
        StockSearchBar?.delegate = self
        StockSearchController.delegate = self
        StockSearchController.searchResultsUpdater=self
        StockSearchController.hidesNavigationBarDuringPresentation = false
        StockSearchController.obscuresBackgroundDuringPresentation = false
        StockSearchController.searchBar.placeholder = "종목 입력"
        navigationItem.searchController = StockSearchController
        self.navigationItem.hidesSearchBarWhenScrolling = false
        definesPresentationContext = true
        
        candidates = stockCandidates
        
        self.view.backgroundColor = UIColor.systemGray5
        let footerView = UIView(frame: .init(x: 0, y: 0, width: self.view.frame.width, height: 90))
        footerView.backgroundColor = UIColor.systemGray5
        self.tableView.tableFooterView = footerView
        
    }

    func filterContentForSearchKeyword(_ searchKeyword: String) {
        if searchKeyword == ""{
            candidates = stockCandidates
        }
        else{
            var temp:Array < candidate > = []
            
            for stockPair in stockCandidates{
                if stockPair.name.contains(searchKeyword){
                    temp.append(stockPair)
                }
            }
            candidates = temp
        }
        tableView.reloadData()
    }
    // MARK: - Table view data source

    override func numberOfSections(in tableView: UITableView) -> Int {
        // #warning Incomplete implementation, return the number of sections
        return 1
    }

    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        // #warning Incomplete implementation, return the number of rows
        return candidates.count
    }

    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "SearchCell", for: indexPath) as! SearchCell
        
        cell.nameLabel.text = candidates[indexPath.row].name
        cell.priceLabel.text = String(candidates[indexPath.row].code)
        
        return cell
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
        if segue.identifier=="stockSegue"{
            
            let stockView = segue.destination as! StockViewController
            
            //let button = sender as! UIButton
            
            //let cell=button.superview?.superview as! SearchCell
            let cell = sender as! SearchCell
            
            stockView.stockName=cell.nameLabel.text!
            stockView.stockCode=cell.priceLabel.text!
            
        }
    }

}

extension StockAdditionTableViewController: UISearchResultsUpdating{
    func updateSearchResults(for searchController: UISearchController) {
        guard let searchKeyword = searchController.searchBar.text else{
            return
        }
        filterContentForSearchKeyword(searchKeyword)
    }
}
