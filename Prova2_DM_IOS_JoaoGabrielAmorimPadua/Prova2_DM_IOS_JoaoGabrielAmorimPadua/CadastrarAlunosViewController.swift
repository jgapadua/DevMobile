//
//  ViewController.swift
//  Prova2_DM_IOS_JoaoGabrielAmorimPadua
//
//  Created by COTEMIG on 19/08/19.
//  Copyright © 2019 Cotemig. All rights reserved.
//

import UIKit
import FirebaseDatabase

class CadastrarAlunosViewController: UIViewController {
    @IBOutlet weak var txtNumeroMatricula: UITextField!
    @IBOutlet weak var txtNome: UITextField!
    @IBOutlet weak var txtTurma: UITextField!
    @IBOutlet weak var txtTurno: UITextField!
    
    @IBAction func btnSalvar(_ sender: Any) {
        
        let numero =
            txtNumeroMatricula.text!
        let nome = txtNome.text!
        let turma = txtTurma.text!
        let turno = txtTurno.text!
        
        var ref : DatabaseReference!
        ref = Database.database().reference()
        ref.child("alunos").child(nome).setValue(["numeromatricula":numero,
                                                    "nome":nome,
                                                    "turma":turma,
                                                    "turno":turno])
        
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

