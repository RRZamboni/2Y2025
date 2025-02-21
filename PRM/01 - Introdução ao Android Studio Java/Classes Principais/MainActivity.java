package com.example.meuprojetinhochuchu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // 1) Atributos
    TextView titulo;
    Button btnTestar;
    TextView resposta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2) 'Linkando' os itens da tela com os atributos
        titulo = (TextView) findViewById(R.id.Titulo);
        btnTestar = (Button) findViewById(R.id.BtnTestar);
        resposta = (TextView) findViewById(R.id.Resposta);

        // 3) Programando o evento do botão
        btnTestar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                resposta.setText("Olá queridão, acho que te amo!");
            }
        });//btnTestar
    }
}
