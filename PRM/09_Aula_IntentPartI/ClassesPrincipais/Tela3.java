package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Tela3 extends AppCompatActivity
{
    //1) Atributos
    Button btnVoltarTela3;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela3);

        // 2) Iniciando os elementos
        btnVoltarTela3 = (Button) findViewById(R.id.btnVoltarTela3);

        //3) Evento Botao
        btnVoltarTela3.setOnClickListener(new View.OnClickListener()
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
