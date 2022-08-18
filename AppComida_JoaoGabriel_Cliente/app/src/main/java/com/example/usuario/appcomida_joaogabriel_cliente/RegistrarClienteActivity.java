package com.example.usuario.appcomida_joaogabriel_cliente;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrarClienteActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText lEmail, lNome, lCPF, lEndereco, lTelefone, lSenha, lSenha2;

    FirebaseDatabase databaseCliente = FirebaseDatabase.getInstance();
    DatabaseReference myRef= databaseCliente.getReference("Cliente");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_cliente);
        mAuth = FirebaseAuth.getInstance();
        lEmail = (EditText) findViewById(R.id.edtEmail);
        lNome = (EditText) findViewById(R.id.edtNome);
        lCPF = (EditText) findViewById(R.id.edtCPF);
        lEndereco = (EditText) findViewById(R.id.edtEndereco);
        lTelefone = (EditText) findViewById(R.id.edtTelefone);
        lSenha = (EditText) findViewById(R.id.edtSenha);
        lSenha2 = (EditText) findViewById(R.id.edtConfirma);

    }

    public void Gravar(View view) {
       final String email, nome, CPF, endereco, telefone, senha, senha2;
        email = lEmail.getText().toString();
        senha = lSenha.getText().toString();
        senha2 = lSenha2.getText().toString();

        nome = lNome.getText().toString();
        CPF = lCPF.getText().toString();
        endereco = lEndereco.getText().toString();
        telefone = lTelefone.getText().toString();

        if (senha.equals(senha2)) {

            mAuth.createUserWithEmailAndPassword(email, senha)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                FirebaseUser user = mAuth.getCurrentUser();
                                //Gravando informações do usuario no Realtime Database
                                String id = myRef.push().getKey();
                                Cliente objCliente = new Cliente(id, email, nome, CPF, endereco, telefone, user.getUid());
                                myRef.child(id).setValue(objCliente);

                                //Limpando as caixas de texto
                                lEmail.setText("");
                                lSenha.setText("");
                                lSenha2.setText("");
                                lNome.setText("");
                                lCPF.setText("");
                                lEndereco.setText("");
                                lTelefone.setText("");

                                Toast.makeText(RegistrarClienteActivity.this, "Cliente registrado!",
                                        Toast.LENGTH_SHORT).show();


                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(RegistrarClienteActivity.this, "Falha ao salvar o cliente!",
                                        Toast.LENGTH_SHORT).show();

                            }

                            // ...
                        }
                    });
        } else
            Toast.makeText(RegistrarClienteActivity.this, "Senhas diferentes.",
                    Toast.LENGTH_SHORT).show();
    }

    public void Voltar(View view) {
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
    }
}