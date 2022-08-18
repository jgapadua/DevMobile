//
//  SegundaViewController.swift
//  Prova_IOS_JoãoGabrielAmorimPádua
//
//  Created by COTEMIG on 22/04/19.
//  Copyright © 2019 Cotemig. All rights reserved.
//

import UIKit

class SegundaViewController: UIViewController {
    
    var nome : String = ""
    
    @IBOutlet weak var lbl_respsota: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        // Do any additional setup after loading the view.
        lbl_resposta.text="Valor Total da compra\(nome)"
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    
    
    
}

