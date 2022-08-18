//
//  ViewController.swift
//  ifood_cliente_18
//
//  Created by COTEMIG on 02/09/19.
//  Copyright © 2019 Cotemig. All rights reserved.
//

import UIKit
import FirebaseAuth

class ViewController: UIViewController {
    @IBOutlet weak var txtemail: UITextField!
    @IBOutlet weak var txtsenha: UITextField!
    
    @IBAction func btn_entrar(_ sender: UIButton){
    let email = txtemail.text!
    let senha = txtsenha.text!
    
        Auth.auth().signIn(withEmail: email, password: senha){ (user, error) in
            
            if let u = user
            {
                self.performSegue(withIdentifier: "segue_menu", sender: self)
            }
    }
        
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }
}


