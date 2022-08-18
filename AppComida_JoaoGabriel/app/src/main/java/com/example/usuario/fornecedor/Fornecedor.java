package com.example.usuario.fornecedor;

/**
 * Created by usuario on 16/09/2019.
 */

public class Fornecedor {

    private String FornecedorId;
    private  String Email;
    private  String Nome;
    private String CNPJ;
    private  String Endereco;
    private  String Telefone;
    private String AuthId;
    private String UrlFoto;



    public Fornecedor(String fornecedorId, String email, String nome, String CNPJ, String endereco,String telefone, String authId,String urlFoto) {
        FornecedorId = fornecedorId;
        Email = email;
        Nome = nome;
        this.CNPJ = CNPJ;
        Endereco = endereco;
        Telefone = telefone;
        AuthId = authId;
        UrlFoto = urlFoto;
    }

    public String getFornecedorId() {
        return FornecedorId;
    }

    public void setFornecedorId(String fornecedorId) {
        FornecedorId = fornecedorId;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {

        this.CNPJ = CNPJ;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String endereco) {
        Endereco = endereco;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String telefone) {
        Telefone = telefone;
    }

    public String getAuthId() {
        return AuthId;
    }

    public void setAuthId(String authId) {
        AuthId = authId;
    }

    public String getUrlFoto(){return  UrlFoto;}

    public void setUrlFoto(String urlFoto){UrlFoto=urlFoto;}
}
