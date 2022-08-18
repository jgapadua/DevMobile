//
//  SegundaViewController.swift
//  Login_JoaoGabriel
//
//  Created by COTEMIG on 08/04/19.
//  Copyright © 2019 Cotemig. All rights reserved.
//

import UIKit

class SegundaViewController: UIViewController {

    var nome : String = ""
    
    @IBOutlet weak var lbl_usuario: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        lbl_usuario.text="Seja bem vindo \(nome)!!!"
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    

    

}
