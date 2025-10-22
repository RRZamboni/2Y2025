package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    //1) Atributos
    Button btnSaque, btnDeposito, btnExecutar;
    EditText txtNome, txtValor;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2) Iniciar os elementos
        txtNome = (EditText) findViewById(R.id.txtNome);
        txtValor = (EditText) findViewById(R.id.txtValor);
        btnDeposito = (Button) findViewById(R.id.btnDeposito);
        btnSaque = (Button) findViewById(R.id.btnSaque);
        btnExecutar = (Button) findViewById(R.id.btnExecutar);


        //Botao Saque
        btnSaque.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //Habilitando os itens invisíveis
                txtValor.setVisibility(View.VISIBLE);
                txtNome.setVisibility(View.VISIBLE);
                btnExecutar.setVisibility(View.VISIBLE);
            }
        });

        // btnExecutar
        btnExecutar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //Recuperando os valores
                double valor = Double.parseDouble(
                           txtValor.getText().toString());
                String titular = txtNome.getText().toString();

                //Intanciando a classe Conta
                Conta continha = new Conta();

                //Fazendo o saque
                double retorno = continha.Saque(valor);

                //Toast
                Toast.makeText(MainActivity.this,
                                "Saldo atual: R$"+retorno,
                                Toast.LENGTH_LONG).show();
            }
        });



    }
}