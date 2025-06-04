package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Tela2 extends AppCompatActivity
{
    //1) Atributos
    Button btnVoltarTela2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        // 2) Iniciando os elementos
        btnVoltarTela2 = (Button) findViewById(R.id.btnVoltarTela2);

        //3) Evento Botao
        btnVoltarTela2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //Instanciando a classe Intent
                Intent it = new Intent(Tela2.this,
                        MainActivity.class);

                //'Chamando' a outra activity
                startActivity(it);
            }
        });


    }
}