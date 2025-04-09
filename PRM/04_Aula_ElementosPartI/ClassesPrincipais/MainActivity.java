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






    }
}