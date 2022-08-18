package com.example.usuario.produtos_joaogabrielamorimpadua;


public class Produto {
    private String produtoId;
    private  String produtoNome;
    private String produtoValor;

    public Produto(){

    }

    public Produto(String produtoId, String produtoNome, String produtoValor){
        this.produtoId=produtoId;
        this.produtoNome=produtoNome;
        this.produtoValor=produtoValor;
    }

    public String getProdutoId(){
        return produtoNome;
    }
    public  String getProdutoValor(){
        return  produtoValor;
    }
}
