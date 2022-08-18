//
//  ViewControllerTableViewCell.swift
//  produtos_IOS_JoaoGabriel
//
//  Created by COTEMIG on 24/06/19.
//  Copyright © 2019 Cotemig. All rights reserved.
//

import UIKit

class ViewControllerTableViewCell: UITableViewCell {

    @IBOutlet weak var lblnome: UILabel!
    @IBOutlet weak var lblpreco: UILabel!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }

}
