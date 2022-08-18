package com.example.usuario.produtos_joaogabrielamorimpadua;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class ListaProdutoActivity extends AppCompatActivity {

    ListView listView;
    ArrayAdapter adapter;
    ArrayList produtosList= new ArrayList<>();
    private DatabaseReference databaseProdutos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_produto);
        listView=(ListView)findView


        adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,produtosList);

    }
}
