package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    //1) Atributos
    EditText txtObjetos;
    ListView lista;
    Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2) Iniciando os elementos
        txtObjetos = (EditText) findViewById(R.id.txtObjetos);
        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
        lista = (ListView) findViewById(R.id.lista);

        //3) Criando o ArrayList
        ArrayList<String> listinha = new ArrayList<String>();

        // 4) Evento do botao
        btnCadastrar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //Adicionando valor do EditText no ArrayList<>
                String objeto = txtObjetos.getText().toString();
                listinha.add(objeto);

                //Adaptando o ArrayList
                ArrayAdapter<String> listaAdaptada =
                         new ArrayAdapter<String>(MainActivity.this,
                                     android.R.layout.simple_list_item_1,
                                      listinha);

                //Adicionando o ArrayList já adaptado ao layout
                lista.setAdapter(listaAdaptada);
            }
        });

        // Removendo item da lista
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                //Removendo item do ArrayList
                listinha.remove(i);
            }
        });



    }
}