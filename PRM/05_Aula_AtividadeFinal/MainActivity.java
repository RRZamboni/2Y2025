package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    // 1) Atributos
    Button btnCorrida, btnCiclismo, btnNatacao, btnMusculacao, btnCalcular;
    SeekBar seekBar;
    Switch swIntenso;
    TextView valorSeekBar;

    //Valor da Seek Bar!!!!
    int valor;
    double kcal;

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
                kcal = 10;
            }
        });


        //////////////////Botao Natação/////////////////
        btnNatacao.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //Variavel para definir kcal/min
                kcal = 9;

            }
        });

        //////////////////Botao Musculação/////////////////
        btnMusculacao.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //Variavel para definir kcal/min
                kcal = 5;
            }
        });

        //////////////////Botao Ciclismo/////////////////
        btnCiclismo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //Variavel para definir kcal/min
                kcal = 7;
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

        /////Botao calcular
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(swIntenso.isChecked())
                {
                    //Calculo
                    double ValorFinal = valor * kcal;

                    //Add 20%
                    ValorFinal = ValorFinal + (ValorFinal * 0.2);

                    Toast.makeText(MainActivity.this,
                       "Total de Calorias gastas é: " + ValorFinal,
                            Toast.LENGTH_LONG).show();
                }
                else
                {
                    //Calculo
                    double ValorFinal = valor * kcal;

                    //Mostrando o valor
                    Toast.makeText(MainActivity.this,
                            "Seu gasto foi: " + ValorFinal,
                            Toast.LENGTH_LONG).show();
                }
            }
        });


        // Clique longo botão corrida
        btnCorrida.setOnLongClickListener(new View.OnLongClickListener()
        {
            @Override
            public boolean onLongClick(View v)
            {
                Toast.makeText(MainActivity.this,
                              "Corrida melhora o condicionamento e queima muitas calorias!",
                              Toast.LENGTH_LONG ).show();
                return true;
            }
        });





    }
}
