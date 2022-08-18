package com.example.usuario.appcomida_joaogabriel_cliente;

/**
 * Created by usuario on 16/09/2019.
 */

public class Cliente {
    private String ClienteId;
    private  String Email;
    private  String Nome;
    private String CPF;
    private  String Endereco;
    private  String Telefone;
    private String AuthId;

    public Cliente(){

    }

    public Cliente(String clienteId, String email, String nome, String CPF, String endereco,String telefone, String authId) {
        ClienteId = clienteId;
        Email = email;
        Nome = nome;
        this.CPF = CPF;
        Endereco = endereco;
        Telefone = telefone;
        AuthId = authId;
    }

    public String getClienteId() {
        return ClienteId;
    }

    public void setClienteId(String clienteId) {
        ClienteId = clienteId;
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

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
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
}
