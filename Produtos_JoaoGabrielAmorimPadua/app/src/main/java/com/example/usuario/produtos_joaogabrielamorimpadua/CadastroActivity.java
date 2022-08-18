package com.example.usuario.produtos_joaogabrielamorimpadua;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class CadastroActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText mPasswordView, mEmailView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        mAuth = FirebaseAuth.getInstance();
        mEmailView = (EditText) findViewById(R.id.edtEmail);
        mPasswordView=(EditText) findViewById(R.id.edtSenha);
    }

    public void EfetuarCadastro(View view) {
        String email=mEmailView.getText().toString().trim();
        String password=mPasswordView.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Email inválido",Toast.LENGTH_LONG).show();
            return;
        }
        else if (TextUtils.isEmpty(password)){
            Toast.makeText(this,"Senha inválida",Toast.LENGTH_LONG).show();
            return;
        }
        else{
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(CadastroActivity.this, "Registrado com sucesso", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                intent.putExtra("nome", mEmailView.getText().toString().trim());
                                startActivity(intent);
                            } else {
                                Toast.makeText(CadastroActivity.this, "Erro ao efetuar cadastro", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
        }
    }

    public void Voltar(View view) {
        Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
        startActivity(intent);
    }
}
