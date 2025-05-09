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

    int img;
    String txtArt;



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
        listinha.add("");
        listinha.add("Black Sabbath");
        listinha.add("Helloween");
        listinha.add("Kiss");
        listinha.add("Rush");
        listinha.add("Tralalero");

        // 4) Adaptando o ArrayList<> para colocar no layout
        ArrayAdapter<String> adaptador =
                new ArrayAdapter<>(MainActivity.this,
                        android.R.layout.simple_list_item_1,
                        listinha);

        // 5) Inserindo a Lista Adaptada no layout
        spinner.setAdapter(adaptador);

        ////////////////////////////////////////////////////////


        // 6) Evento no Spinner
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {

                //Recuperando valor selecionado
                String itemSelecionado = listinha.get(i);

                //Verificando campos
                if(itemSelecionado.equals(""))
                {
                    //Do nothing!!!! MOtherFocker!!!
                    imagem.setImageResource(R.drawable.ic_launcher_background);
                }

                if(itemSelecionado.equals("Black Sabbath"))
                {
                    //Coloco os valores nas variaveis
                    img = R.drawable.bs;
                    txtArt = "Black Sabbath é uma banda de heavy metal britânica formada no ano de 1968 em Birmingham.";
                }

                if(itemSelecionado.equals("Helloween"))
                {
                    //Coloco os valores nas variaveis
                    img = R.drawable.helo;
                    txtArt = "Helloween é uma influente banda de power metal alemã, fundada em 1984. É composta por Andi Deris (vocal), Dani Löble (bateria), Sascha Gerstner (guitarra), Michael Weikath (guitarra).";
                }

                if(itemSelecionado.equals("Kiss"))
                {
                    //Coloco os valores nas variaveis
                    img = R.drawable.kiss;
                    txtArt = "Kiss foi uma banda de hard rock dos Estados Unidos, formada em Nova Iorque em 1973 por Paul Stanley e Gene Simmons. A banda passou por algumas mudanças de formações, sendo Stanley e Simmons os dois integrantes da formação original da banda a participarem de todas elas.";
                }

                if(itemSelecionado.equals("Rush"))
                {
                    img = R.drawable.rush;
                    txtArt = "Rush foi uma banda formada em 1968 em Toronto, Ontário, que se destacou pela habilidade musical, composições complexas e letras ecléticas. ";
                }

                if(itemSelecionado.equals("Tralalero"))
                {
                    img = R.drawable.tralalero;
                    txtArt = " Tralalero Tralalá, Bombardiro Crocodilo, Brr Brr Patapim, Tung Tung Tung Tung Sahur.";
                }

                //Modificando os valores dos elementos do layout
                imagem.setImageResource(img);
                textoArtista.setText(txtArt);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }
        });












    }
}
