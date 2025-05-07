package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    // 1) Atributos
    TextView textoArtista;
    ImageView imagem;
    Spinner spinner;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2) 'Iniciando' os items
        imagem = (ImageView) findViewById(R.id.imagem);
        textoArtista = (TextView) findViewById(R.id.textoArtista);
        spinner = (Spinner) findViewById(R.id.spinner);

        // 3) Criando um ArrayList
        /*    Funciona como um array porém é
              uma classe, e permite a persistência
             de vários tipos, além de métodos de acesso!!!
         */
        ArrayList<String> listinha = new ArrayList<String>();
        listinha.add("Black Sabbath");
        listinha.add("Halloween");
        listinha.add("Mc Mento");
        listinha.add("Angra");
        listinha.add("Iron Maiden");

        // 4) Adaptando o ArrayList<> para colocar no layout
        ArrayAdapter<String> adaptador =
                new ArrayAdapter<>(MainActivity.this,
                         android.R.layout.simple_list_item_1,
                          listinha);

        // 5) Inserindo a Lista Adaptada no layout
        spinner.setAdapter(adaptador);


        // 6) Evento no Spinner
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                String itemSelecionado = listinha.get(i);

                Toast.makeText(MainActivity.this,
                                itemSelecionado,
                        Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }
        });












    }
}