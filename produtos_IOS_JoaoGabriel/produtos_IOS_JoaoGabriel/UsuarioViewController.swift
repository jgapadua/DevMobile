//
//  UsuarioViewController.swift
//  produtos_IOS_JoaoGabriel
//
//  Created by COTEMIG on 03/06/19.
//  Copyright © 2019 Cotemig. All rights reserved.
//

import UIKit
import FirebaseAuth


class UsuarioViewController: UIViewController {
    
    @IBOutlet weak var txt_email: UITextField!
    @IBOutlet weak var txt_senha: UITextField!
    @IBOutlet weak var txt_csenha: UITextField!
    
    
    @IBAction func btn_cadastrar(_ sender: Any) {
        let email=txt_email.text!
        let senha=txt_senha.text!
        let confirmarSenha=txt_csenha.text!
        
        if(senha != confirmarSenha){
            let alert = UIAlertController(title: "Error", message: "Senha não confere",preferredStyle: .alert)
            let OK = UIAlertAction(title: "OK", style: .default, handler: nil)
            alert.addAction(OK)
            present(alert,animated: true, completion: nil)
        }
        else{
            Auth.auth().createUser(withEmail: email, password: senha)
        }
    
    }


    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }
    */

}
