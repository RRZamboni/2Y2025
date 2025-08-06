package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class Tela2 extends AppCompatActivity
{
    // Atributos
    EditText txtNomeMigo, txtIdadeMigo;
    Button btnCadastrar;
    ListView listinha;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        // 2) Iniciando
        txtNomeMigo = (EditText) findViewById(R.id.txtNomeMigo);
        txtIdadeMigo = (EditText) findViewById(R.id.txtIdadeMigo);
        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
        listinha = (ListView) findViewById(R.id.listinha);

        //Criando um ArrayList
        ArrayList<String> listaChuchu = new ArrayList<String>();


        //3) Evento do btnCadastrar
        btnCadastrar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //Recuperando os valores
                String nome = txtNomeMigo.getText().toString();
                String idade = txtIdadeMigo.getText().toString();

                //Adicionando migos
                listaChuchu.add(nome + "," + idade);

                //Adaptando a lista para o layout
                ArrayAdapter<String> adaptador =
                        new ArrayAdapter<String>(Tela2.this,
                                android.R.layout.simple_list_item_1,
                                listaChuchu);

                //Adicionando a lista no listview
                listinha.setAdapter(adaptador);

                //Apagar os campos
                txtIdadeMigo.setText("");
                txtNomeMigo.setText("");
            }
        });
    }
}