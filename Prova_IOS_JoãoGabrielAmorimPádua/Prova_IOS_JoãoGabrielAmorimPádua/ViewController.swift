//
//  ViewController.swift
//  Prova_IOS_JoãoGabrielAmorimPádua
//
//  Created by COTEMIG on 22/04/19.
//  Copyright © 2019 Cotemig. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    @IBOutlet weak var lbl_preco: UITextField!
    @IBOutlet weak var lbl_quantidade: UITextField!
    @IBOutlet weak var lbl_idade: UITextField!
    
    @IBAction func btn_Calcular(_ sender: UIButton) {
       let preco=Double(lbl_preco.text!)
        let quantidade=Int(lbl_quantidade.text!)
        let idade=Int(lbl_idade.text!)
        var total:Double=0
        
        total = (preco! * quantidade!)
        if(idade > 60){
            lbl_resposta.text = total * 0.15;
        }
        performSegue(withIdentifier: "segue0", sender: self)
    }
    
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

