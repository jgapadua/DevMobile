//
//  ViewController.swift
//  imc_Joao.Gabriel
//
//  Created by COTEMIG on 11/03/19.
//  Copyright © 2019 Cotemig. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    @IBOutlet weak var txtPeso: UITextField!
    @IBOutlet weak var txtAltura: UITextField!
    @IBOutlet weak var lblResultado: UILabel!
    @IBOutlet weak var imgResposta: UIImageView!
    @IBAction func btnCalcular(_ sender: Any) {
        let peso = Double(txtPeso.text!)
        let altura = Double(txtAltura.text!)
        var resultado : Double = 0;
        
        resultado = peso!/(altura! * altura!)
        if (resultado < 16){
            lblResultado.text = String(format: "%.2f", resultado, "magreza")
            imgResposta.image = UIImage(named:"magreza");
        }
        else if (resultado < 18.5){
            lblResultado.text = String(format: "%.2f", resultado, " abaixo")
            imgResposta.image = UIImage(named:"abaixo");
        }
        else if (resultado < 25){
            lblResultado.text = String(format: "%.2f", resultado, "ideal")
            imgResposta.image = UIImage(named:"ideal");
        }
        else if (resultado <= 30){
            lblResultado.text = String(format: "%.2f", resultado, "sobre")
            imgResposta.image = UIImage(named:"sobre-peso");
        }
        else if (resultado > 30){
            lblResultado.text = String(format: "%.2f", resultado,"obesidade")
            imgResposta.image = UIImage(named:"obesidade");
        }
    }
}
        
    

        

    
    
    




