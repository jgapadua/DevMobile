package com.example.usuario.produtos_joaogabrielamorimpadua;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CadastroProdutoActivity extends AppCompatActivity {
    FirebaseDatabase databaseProdutos;
    DatabaseReference myRef;
    private EditText nomeView, valorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_produto);

        databaseProdutos = FirebaseDatabase.getInstance();
        myRef = databaseProdutos.getReference("Produtos");

        nomeView=(EditText) findViewById(R.id.edtNomeProduto);
        valorView=(EditText) findViewById(R.id.edtValorProduto);

    }

    public void CadastrarProduto(View view) {
        String id = myRef.push().getKey();

        String nome= nomeView.getText().toString();
        String valor= valorView.getText().toString();

        Produto objProduto = new Produto(id,nome,valor);

        myRef.child(id).setValue(objProduto);

        nomeView.setText("");
        valorView.setText("");
    }
}
