package com.example.usuario.fornecedor;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;

public class RegistrarFornecedorActivity extends AppCompatActivity {

     EditText lEmail, lNome, lCNPJ, lEndereco, lTelefone, lSenha, lSenha2;
     ImageView lImageView;
    private FirebaseAuth mAuth;

    FirebaseDatabase databaseFornecedor = FirebaseDatabase.getInstance();
    DatabaseReference myRef = databaseFornecedor.getReference("Fornecedor");

    FirebaseStorage storage;
    StorageReference storageReference;

    private final int PICK_IMAGE_REQUEST=71;
    private Uri filePath;
    String urlFoto = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_fornecedor);

        mAuth = FirebaseAuth.getInstance();
         storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();

        lImageView=(ImageView) findViewById(R.id.imgImagem);
        lEmail = (EditText) findViewById(R.id.edtEmail);
        lNome = (EditText) findViewById(R.id.edtNome);
        lCNPJ = (EditText) findViewById(R.id.edtCNPJ);
        lEndereco = (EditText) findViewById(R.id.edtEndereco);
        lTelefone = (EditText) findViewById(R.id.edtTelefone);
        lSenha = (EditText) findViewById(R.id.edtSenha);
        lSenha2 = (EditText) findViewById(R.id.edtConfirma);


    }

    private void SalvarFornecedor(final String authId){
        final String email,nome,CNPJ,endereco,telefone;

        email = lEmail.getText().toString();
        nome = lNome.getText().toString();
        CNPJ=lCNPJ.getText().toString();
        endereco=lEndereco.getText().toString();
        telefone=lTelefone.getText().toString();

        if (filePath!=null)
        {
         StorageReference ref = storageReference.child("images/"+authId);
         ref.putFile(filePath)
                 .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                     @Override
                     public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                         //Aqui caso de sucesso do upload...
                         //Você captura a URL da imagem pra poder salvar
                         urlFoto=taskSnapshot.getDownloadUrl().toString();

                         //Gravando informações do usuario no Realtime Database (inclusive a url da foto)
                         String id =myRef.push().getKey();
                         Fornecedor objFornecedor = new Fornecedor(id,email,nome,CNPJ,endereco,telefone,authId,urlFoto);
                         myRef.child(id).setValue(objFornecedor);

                         //Limpando as caixas de texto
                         lEmail.setText("");
                         lSenha.setText("");
                         lSenha2.setText("");
                         lNome.setText("");
                         lCNPJ.setText("");
                         lEndereco.setText("");
                         lTelefone.setText("");
                         lImageView.setImageResource(android.R.color.transparent);

                         Toast.makeText(RegistrarFornecedorActivity.this,"Imagem gravada com sucesso!", Toast.LENGTH_SHORT).show();
                     }
                 });
        }
    }

    public void Gravar(View view) {
        final String email, senha, senha2   ;
        email = lEmail.getText().toString();
        senha = lSenha.getText().toString();
        senha2 = lSenha2.getText().toString();


        if (senha.equals(senha2)) {

            mAuth.createUserWithEmailAndPassword(email, senha)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Usuario gravado com sucesso
                                FirebaseUser user = mAuth.getCurrentUser();
                                String authId=user.getUid();


                                //Gravando FOTO e pegando seu caminho
                                SalvarFornecedor(authId);



                Toast.makeText(RegistrarFornecedorActivity.this, "Fornecedor registrado!",
                        Toast.LENGTH_SHORT).show();
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(RegistrarFornecedorActivity.this, "Falha ao salvar o fornecedor!",
                                        Toast.LENGTH_SHORT).show();

                            }

                            // ...
                        }
                    });
        }
        else
            Toast.makeText(RegistrarFornecedorActivity.this, "Senhas diferentes.",
                    Toast.LENGTH_SHORT).show();
    }

    public void Voltar(View view) {
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
    }

    private void SalvarImagem (String nome){
        if(filePath!=null)
        {
         StorageReference ref = storageReference.child("images/"+nome);
         ref.putFile(filePath)
                 .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
             @Override
             public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                 Toast.makeText(RegistrarFornecedorActivity.this,"Imagem gravada com sucesso!",Toast.LENGTH_SHORT).show();

             }

         })
                 .addOnFailureListener(new OnFailureListener() {
             @Override
             public void onFailure(@NonNull Exception e) {
                 Toast.makeText(RegistrarFornecedorActivity.this,"Falha ao gravar imagem"+e.getMessage(),Toast.LENGTH_SHORT).show();

             }
         })
                 .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
             @Override
             public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {

             }
         });



        }
    }

    public void CarregarImagem(View view) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select Picture"),PICK_IMAGE_REQUEST);

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK
                && data != null && data.getData()!= null)
        {
            filePath=data.getData();
            try{
                Bitmap bitmap= MediaStore.Images.Media.getBitmap(getContentResolver(),filePath);
                lImageView.setImageBitmap(bitmap);
            }
            catch (IOException e)
            {
                Toast.makeText(RegistrarFornecedorActivity.this,"Erro ao carregar imagem!",
                        Toast.LENGTH_SHORT).show();
                 e.printStackTrace();
            }
        }


    }


}