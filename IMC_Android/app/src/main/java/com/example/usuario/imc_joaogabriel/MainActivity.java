package com.example.usuario.imc_joaogabriel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtPeso;
    EditText edtAltura;
    TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtPeso= findViewById(R.id.edtPeso);
        edtAltura=findViewById(R.id.edtAltura);
        tvResultado=findViewById(R.id.tvResultado);
    }

    public void Efetuar(View view) {
        double peso;
        double altura;
        double resultado;

        resultado=0;
        peso=Double.parseDouble(edtPeso.getText().toString());
        altura=Double.parseDouble(edtAltura.getText().toString());

      //código do calculo

        resultado=(peso/(altura*altura));

        if(resultado<=16){
            tvResultado.setText(resultado+"Magreza");
        }
        else if(resultado<=18.5){
            tvResultado.setText(resultado+"Abaixo do Peso");
        }
        else if(resultado<=25){
            tvResultado.setText(resultado+"Peso ideal");
        }
        else if(resultado<=30){
            tvResultado.setText(resultado+"Sobrepeso");
        }
        else if(resultado>30){
            tvResultado.setText(resultado+"Obesidade");
        }

    }
}
