package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    //1) Atributo
    EditText txtProduto, txtValorAumento;
    Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2) Ligando o layout com o Java
        txtProduto = (EditText) findViewById(R.id.txtProduto);
        txtValorAumento = (EditText) findViewById(R.id.txtValorAumento);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);

        //3) Criando o evento do botão
        btnCalcular.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                // Recuperando valores
                double valorProd = Double.parseDouble(txtProduto.getText().toString());
                double valorPorc = Double.parseDouble(txtValorAumento.getText().toString());

                //fazer a conta
                double resultado = valorProd + (valorProd * (valorPorc/100));

                // Mostrar o valor!!!!
                Toast.makeText(MainActivity.this,
                                "Novo valor: R$" + resultado,
                                Toast.LENGTH_LONG).show();
            }
        });

    }
}