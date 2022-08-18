//
//  CadastrarProdutoViewController.swift
//  produtos_IOS_JoaoGabriel
//
//  Created by COTEMIG on 17/06/19.
//  Copyright © 2019 Cotemig. All rights reserved.
//

import UIKit
import FirebaseDatabase

class CadastrarProdutoViewController: UIViewController {
    
    @IBOutlet weak var txtNome: UITextField!
    @IBOutlet weak var txtPreco: UITextField!
    @IBOutlet weak var txtCategoria: UITextField!
    @IBOutlet weak var txtQuantidade: UITextField!
    
    @IBAction func btnCadastrar(_ sender: Any) {
        let nome = txtNome.text!
        let preco = txtPreco.text!
        let categoria = txtCategoria.text!
        let quantidade = txtQuantidade.text!
        
        var ref : DatabaseReference!
        ref = Database.database().reference()
        ref.child("produtos").child(nome).setValue(["nome":nome,
                                                    "preco":preco,
                                                "categoria":categoria,
                                          "quantidade":quantidade])
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
