//
//  ListarAlunosViewController.swift
//  Prova2_DM_IOS_JoaoGabrielAmorimPadua
//
//  Created by COTEMIG on 19/08/19.
//  Copyright © 2019 Cotemig. All rights reserved.
//

import UIKit
import FirebaseDatabase

var alunosList=[AlunosModel]()
var Myindex = 0

class ListarAlunosViewController: UIViewController, UITableViewDelegate, UITableViewDataSource{
    
    
    @IBOutlet weak var tblAlunos: UITableView!
    
    func tableView(_ tableView: UITableView,numberOfRowsInSection section: Int) -> Int {
        return alunosList.count
    }
    public func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell =
            tableView.dequeueReusableCell(withIdentifier:
                "cell", for:indexPath) as!
        ViewControllerTableViewCell
        
        let alu: AlunosModel
        
        alu = alunosList[indexPath.row]
        
        cell.lblNome.text = alu.nome
        
        
        return cell
    }
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        var ref:DatabaseReference!
        ref = Database.database().reference().child("alunos")
        
        ref.observe(DataEventType.value,with:{(snapshot)in
            if snapshot.childrenCount>0
            {
                alunosList.removeAll()
                for alunos in snapshot.children.allObjects as![DataSnapshot]{
                    let alunosObject = produtos.value as? [String: AnyObject]
                    
                    let alunosNumeroMatricula =  produtosObject?["nome"]
                    
                    
                    let alunos = AlunosModel (nome:alunoNome)
                    alunosList.append(alunos)
                }
                self.tblAlunos.reloadData()
            }
        })
        
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
