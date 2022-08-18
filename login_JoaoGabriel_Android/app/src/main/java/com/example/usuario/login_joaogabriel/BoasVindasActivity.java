package com.example.usuario.login_joaogabriel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BoasVindasActivity extends AppCompatActivity {
TextView Mensagem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boas_vindas);

        Bundle objBudle=getIntent().getExtras();

        if (objBudle != null){
                   String usuario;
                   Mensagem= (TextView)findViewById(R.id.tvMensagem);

                   usuario=objBudle.getString("Usuário");
                   Mensagem.setText("Seja bem vindo" + usuario);
        }
    }
}
