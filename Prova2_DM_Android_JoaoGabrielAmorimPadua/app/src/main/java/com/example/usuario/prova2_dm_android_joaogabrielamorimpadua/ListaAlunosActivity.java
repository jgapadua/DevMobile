package com.example.usuario.prova2_dm_android_joaogabrielamorimpadua;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListaAlunosActivity extends AppCompatActivity {

    ListView listView;
    ArrayAdapter adapter;
    ArrayList alunosList;
    private DatabaseReference databasealunos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);
        listView = (ListView) findViewById(R.id.lstAlunos);
        databasealunos = FirebaseDatabase.getInstance().getReference("Alunos");

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, alunosList);

    }

    protected void onStart() {
        super.onStart();

        databasealunos.addValueEventListener(new ValueEventListener() {
            public void onDataChange(DataSnapshot dataSnapshot) {
                alunosList.clear();
                for (DataSnapshot cadastroAluno : dataSnapshot.getChildren()) {
                    Aluno aluno = cadastroAluno.getValue(Aluno.class);
                    alunosList.add(aluno.getAlunoNome());
                }
                adapter = new ArrayAdapter(ListaAlunosActivity.this, android.R.layout.simple_list_item_1, alunosList);
                listView.setAdapter(adapter);

            }

            public void onCancelled(DatabaseError databaseError) {

            }

        });

    }


    public void Adicionar(View view) {
        Intent i = new Intent(getApplicationContext(),CadastroAlunoActivity.class);
        startActivity(i);
    }

}

