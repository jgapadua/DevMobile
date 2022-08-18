package com.example.usuario.prova_android_joaogabrielamorimpadua;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
TextView Mensagem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle bd=getIntent().getExtras();



        if(bd != null){
            String resultado;
            Mensagem = (TextView)findViewById(R.id.tvFinal) ;

            resultado=(String) bd.getString("Resultado");
            Mensagem.setText("Valor da compra" + resultado);

        }
    }
}
