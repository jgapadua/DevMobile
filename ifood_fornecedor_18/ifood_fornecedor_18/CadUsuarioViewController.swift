//
//  CadUsuarioViewController.swift
//  ifood_fornecedor_18
//
//  Created by COTEMIG on 09/09/19.
//  Copyright © 2019 Cotemig. All rights reserved.
//

import UIKit
import FirebaseAuth


class CadUsuarioViewController: UIViewController {

    @IBOutlet weak var txtemail: UITextField!
    @IBOutlet weak var txtsenha: UITextField!
    @IBOutlet weak var txtconfirmar: UITextField!
    
    @IBAction func btn_salvar(_ sender: UIButton) {
        
        let email = txtemail.text!
        let senha = txtsenha.text!
        let confirmarsenha = txtconfirmar.text!
        
       
        
        if(senha == confirmarsenha)
        {
            Auth.auth().createUser(withEmail: email, password: senha)
        }
        else
        {
            let ok = UIAlertAction(title: "OK", style: .default)
            {
                (action) in print ("OK")
            }
            let alert = UIAlertController(title: "Erro senha", message: "Senha não confere", preferredStyle: .alert)
            present(alert, animated: true, completion:  nil)
            alert.addAction(ok)
        }
    }
        
    

    
override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }
    

    

}
