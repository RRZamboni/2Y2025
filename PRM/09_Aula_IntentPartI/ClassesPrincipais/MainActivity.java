package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    //1) Atributos
    Button btnTela2, btnTela3;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2) Iniciando os elementos
        btnTela2 = (Button) findViewById(R.id.btnTela2);
        btnTela3 = (Button) findViewById(R.id.btnTela3);

        //3) Evento btnTela2
        btnTela2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                /*   !!! INTENT !!!
                    Classe responsável pela manipulação
                    de activities...Permitindo uma 'ligação'
                    e passagem de valores!!!
                 */

                //Instanciando a classe Intent
                Intent it = new Intent(MainActivity.this,
                                              Tela2.class);

                //'Chamando' a outra activity
                startActivity(it);

            }
        });

        // 4) Evento btnTela3
        btnTela3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //Instanciando a classe Intent
                Intent it = new Intent(MainActivity.this,
                        Tela3.class);

                //'Chamando' a outra activity
                startActivity(it);

            }
        });


    }
}