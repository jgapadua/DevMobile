package com.example.usuario.prova_android_joaogabrielamorimpadua;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edtPreco,
    edtQuantidade, edtIdade;
    String resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       edtPreco =findViewById(R.id.edtPreco);
       edtQuantidade =findViewById(R.id.edtQuantidade);
        edtIdade =findViewById(R.id.edtIdade);

    }

    public void EfetuarCalculo(View view) {
        double preco;
        int quantidade;
        int idade;


        preco = Double.parseDouble(edtPreco.getText().toString());
        quantidade = Integer.parseInt(edtQuantidade.getText().toString());
        idade = Integer.parseInt(edtIdade.getText().toString());

        if(idade>60){
           resultado = ((preco * quantidade) * 0.15);
        }
        else{
            resultado = (preco * quantidade);
        }
        invocarMain2Activity(resultado);
    }

        private void invocarMain2Activity(String resultado){
            Intent i = new Intent(this,Main2Activity.class );
            Bundle bd = new Bundle();
            bd.putString("Resultado", resultado);
            i.putExtras(bd);
            startActivity(i);
    }










    }
}
