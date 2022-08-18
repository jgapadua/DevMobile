package com.example.usuario.login_joaogabriel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    EditText usuario, senha;
    TextView Aviso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void EfetuarLogin(View view) {
        usuario = (EditText) findViewById(R.id.edtLogin);
        senha= (EditText) findViewById(R.id.edtSenha);

        String usr,pwd;

        usr = usuario.getText().toString();
        pwd = senha.getText().toString();

        switch (usr){
            case "João" :
                if(pwd.equals("123456"))
                {
             invocarTelaBoasVindas(usr);
                }
                else {
                    informarErro();
                }
                break;
            case "Ilg":
                if(pwd.equals("123456")){
                    invocarTelaBoasVindas(usr);
                }
                else{
                    informarErro();
                }
                break;
                default:
                    informarErro();
        }
    }

    private void informarErro() {
        Aviso = findViewById(R.id.tvAviso);
        Aviso.setText("Usuário ou senha inválidos");
    }

    private void invocarTelaBoasVindas(String usuario) {
        Intent objIntent = new Intent(  this,BoasVindasActivity.class);
        Bundle objBundle = new Bundle();
        objBundle.putString("Usuário",usuario);
        objIntent.putExtras(objBundle);
        startActivity(objIntent);
    }
}
