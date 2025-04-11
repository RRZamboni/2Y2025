package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    // 1) Atributos
    EditText txtFunc, txtCargo, txtSalario;
    TextView valor;
    Switch swAumentinho;
    SeekBar barraAumento;
    Button btnTestar;

    double valorTexto = 0 ; // Recuperar valor da seekBar




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2)  Iniciando os elementos
        txtSalario = (EditText) findViewById(R.id.txtSalario);
        txtCargo = (EditText) findViewById(R.id.txtCargo);
        txtFunc = (EditText) findViewById(R.id.txtFunc);
        barraAumento = (SeekBar) findViewById(R.id.barraAumento);
        swAumentinho = (Switch) findViewById(R.id.swAumento);
        valor = (TextView) findViewById(R.id.valor);
        btnTestar = (Button) findViewById(R.id.btnTestar);

        // 3) Configurando  a seekBar para ficar inativa
        barraAumento.setEnabled(false);
        barraAumento.setMax(75);


        // 4) Evento do Switch
        swAumentinho.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b)
            {
                // Configuro a barra como ativa
                barraAumento.setEnabled(true);
            }
        });//

        // 5) Evento do seekBar
        barraAumento.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progresso, boolean b)
            {
                valorTexto = progresso;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {
                valor.setText(valorTexto + "%");
            }
        });//

        // 6) Evento do btnTestar
        btnTestar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //Recuperando valores dos EditTexts
                String nome = txtFunc.getText().toString();
                String cargo = txtCargo.getText().toString();
                double salario = Double.parseDouble(
                               txtSalario.getText().toString());

                //Fazendo a continha
                double novoSalario = salario + (salario * (valorTexto/100));

                //Variável com a mensagem
                String mensagem = "Nome: " + nome + "\n" +
                                  "Cargo: " + cargo + "\n" +
                                  "Sal. Anterior: R$" + salario + "\n" +
                                  "Novo Sal.: R$" + novoSalario;

                //Mostrando
                Toast.makeText(MainActivity.this,
                                mensagem,
                                Toast.LENGTH_LONG).show();

            }
        });//




    }
}