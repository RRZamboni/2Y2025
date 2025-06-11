package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Tela2 extends AppCompatActivity
{

    //1) Atributos
    TextView txtDados;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        //2) Iniciando
        txtDados = (TextView) findViewById(R.id.txtDados);

        // 3) Chamando o Intent para receber os dados
        Intent it = getIntent();

        // 4) Montanto um texto show!
        String texto = "Usuário Cadastrado com Sucesso!!! " +
                       "\n Nome: " + it.getStringExtra("Valor1") +
                       "\n Email: " + it.getStringExtra("Valor2") +
                       "\n Senha: " + it.getStringExtra("Valor3");

        //4) Mostrando no TextView
        txtDados.setText(texto);
    }
}