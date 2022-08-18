package com.example.usuario.prova2_dm_android_joaogabrielamorimpadua;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CadastroAlunoActivity extends AppCompatActivity{

    EditText compNumero;
    EditText compNome;
     EditText compTurma;
   EditText compTurno;
   DatabaseReference databasealunos;



@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_aluno);

    compNumero = findViewById(R.id.edtNumero);
    compNome = findViewById(R.id.edtNome);
    compTurma = findViewById(R.id.edtTurma);
    compTurno = findViewById(R.id.edtTurno);
    databasealunos=FirebaseDatabase.getInstance().getReference("Alunos");
    }

    public void SalvarAluno(View view) {
    String nome = databasealunos.push().getKey();
    }
}
