package com.example.meuprojetinhochuchu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    // 1) Atributos
    TextView titulo;
    Button btnTestar;
    TextView resposta;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2) 'Linkando' os itens da tela com os atributos
        titulo = (TextView) findViewById(R.id.Titulo);


    }
}