package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    // 1) Atributos
    Button btnCorrida, btnCiclismo, btnNatacao, btnMusculacao, btnCalcular;
    SeekBar seekBar;
    Switch swIntenso;
    TextView valorSeekBar;

    //Valor da Seek Bar!!!!
    int valor;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // 2) Iniciando os elementos
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnCiclismo = (Button) findViewById(R.id.btnCiclismo);
        btnMusculacao = (Button) findViewById(R.id.btnMusulacao);
        btnCorrida = (Button) findViewById(R.id.btnCorrida);
        btnNatacao = (Button) findViewById(R.id.btnNatacao);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        swIntenso = (Switch) findViewById(R.id.switch1);
        valorSeekBar = (TextView) findViewById(R.id.textView5);





        //////////////////Botao Corrida/////////////////
        btnCorrida.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //Variavel para definir kcal/min
                double kcalCorrida = 10;
            }
        });


        //////////////////Botao Natação/////////////////
        btnNatacao.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //Variavel para definir kcal/min
                double kcalNatacao = 9;

            }
        });

        //////////////////Botao Musculação/////////////////
        btnMusculacao.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //Variavel para definir kcal/min
                double kcalMusculacao = 5;
            }
        });

        //////////////////Botao Ciclismo/////////////////
        btnCiclismo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //Variavel para definir kcal/min
                double kcalCiclismo = 7;
            }
        });


        //////////////////////SeekBar////////////////////////
        seekBar.setMax(120);
        seekBar.setMin(5);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b)
            {
                valor = i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {
                //Mostrando o valor
                valorSeekBar.setText("%"+valor);
            }
        });





    }
}