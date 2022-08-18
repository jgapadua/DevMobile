//
//  ListarProdutoViewController.swift
//  produtos_IOS_JoaoGabriel
//
//  Created by COTEMIG on 24/06/19.
//  Copyright © 2019 Cotemig. All rights reserved.
//

import UIKit
import FirebaseDatabase

class ListarProdutoViewController: UIViewController, UITableViewDelegate, UITableViewDataSource{
    
    var produtosList=[ProdutosModel]()
    @IBOutlet weak var tblProdutos: UITableView!
    
    func tableView(_ tableView: UITableView,numberOfRowsInSection section: Int) -> Int {
        return produtosList.count
    }
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "cell", for:indexPath) as! ViewControllerTableViewCell
    
        let prod: ProdutosModel
        
        prod = produtosList[indexPath.row]
            
        cell.lblnome.text = prod.nome
        cell.lblpreco.text = prod.preco
       
        return cell
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        var ref:DatabaseReference!
        ref = Database.database().reference().child("produtos")
        
        ref.observe(DataEventType.value,with:{(snapshot)in
            if snapshot.childrenCount>0
            {
                self.produtosList.removeAll()
                for produtos in snapshot.children.allObjects as![DataSnapshot]{
                    let produtosObject = produtos.value as? [String: AnyObject]
                    
                    let produtosNome =  produtosObject?["nome"]
                    let produtosCategoria = produtosObject?["categoria"]
                    let produtosPreco = produtosObject?["preco"]
                    let produtosQuantidade = produtosObject?["quantidade"]
                    
                    let produtos = ProdutosModel(nome:produtosNome as! String, categoria:produtosCategoria as! String, preco: produtosPreco as! String, quantidade:produtosQuantidade as! String)
                    self.produtosList.append(produto)
                }
                self.tblProdutos.reloadData()
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
