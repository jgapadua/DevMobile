//
//  ProdutosModel.swift
//  produtos_IOS_JoaoGabriel
//
//  Created by COTEMIG on 24/06/19.
//  Copyright © 2019 Cotemig. All rights reserved.
//

class ProdutosModel{
    var categoria : String?
    var nome : String?
    var preco : String?
    var quantidade : String?
    
    init(categoria:String?, nome:String?,preco:String?, quantidade:String?)
    {
        self.categoria=categoria
        self.nome=nome
        self.preco=preco
        self.quantidade=quantidade
    }
    
    
}
