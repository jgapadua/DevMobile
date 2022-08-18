package com.example.usuario.prova2_dm_android_joaogabrielamorimpadua;

/**
 * Created by usuario on 19/08/2019.
 */

public class Aluno {
    private String alunoNumero;
    private String alunoNome;
    private String alunoTurma;
    private String alunoTurno;

    public Aluno() {
    }

    public Aluno(String alunoNumero, String alunoNome, String alunoTurma, String alunoTurno) {
        this.alunoNumero = alunoNumero;
        this.alunoNome = alunoNome;
        this.alunoTurma = alunoTurma;
        this.alunoTurno = alunoTurno;
    }

    public String getAlunoNumero() {
        return alunoNumero;
    }

    public String getAlunoNome() {
        return alunoNome;
    }

    public String getAlunoTurma() {
        return alunoTurma;
    }

    public String getAlunoTurno() {
        return alunoTurno;
    }
}
