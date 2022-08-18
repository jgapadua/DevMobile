//
//  ViewController.swift
//  Login_JoaoGabriel
//
//  Created by COTEMIG on 01/04/19.
//  Copyright © 2019 Cotemig. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    
    @IBOutlet weak var lbl_usuario: UITextField!
    
    @IBOutlet weak var lbl_senha: UITextField!
    
    @IBAction func btn_logar(_ sender: UIButton) {
        if(lbl_usuario.text == "Joao" && lbl_senha.text == "123456")
            {
        performSegue(withIdentifier: "segue0", sender: self)
        }
            else{
            let myMessage = "Usuário ou senha invalido..."
            
            let myAlert =
                UIAlertController(title: myMessage,message:nil,preferredStyle:UIAlertControllerStyle.alert)
            
            
            myAlert.addAction(UIAlertAction(title:"OK",style: UIAlertActionStyle.default, handler: nil))
            
            self.present(myAlert,animated: true,completion: nil)
        }
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if let logar = segue.destination as? SegundaViewController
        {
            logar.nome = lbl_usuario.text!
        }
    }
    
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        self.view.endEditing(true)
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
