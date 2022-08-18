//
//  LoginViewController.swift
//  produtos_IOS_JoaoGabriel
//
//  Created by COTEMIG on 17/06/19.
//  Copyright © 2019 Cotemig. All rights reserved.
//

import UIKit
import FirebaseAuth

class LoginViewController: UIViewController {
    
    @IBOutlet weak var txtUsuario: UITextField!
    @IBOutlet weak var txtSenha: UITextField!
    
    @IBAction func btnEntrar(_ sender: Any) {
        let email = txtUsuario.text!
        let senha = txtSenha.text!
        
        Auth.auth().signIn(withEmail:email,password:senha) { (user, error)  in
            if let u = user
            {
                self.performSegue(withIdentifier: "segue_menu",sender:self)
            }
            else
            {
                let alert = UIAlertController(title: "Error", message: "Usuario ou Senha não confere",preferredStyle: .alert)
                let OK = UIAlertAction(title: "OK", style: .default, handler: nil)
                alert.addAction(OK)
                self.present(alert,animated: true, completion: nil)
                
            }
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
