package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    //1) Atributos
        EditText txtLogin, txtSenha;
        Button btnEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2) Linkando os itens
        txtLogin = (EditText) findViewById(R.id.txtLogin);
        txtSenha = (EditText) findViewById(R.id.txtSenha);
        btnEntrar = (Button) findViewById(R.id.btnEntrar);

        // 3) Evento do botão
        btnEntrar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //Recuperar os valores das txt
                String login = txtLogin.getText().toString();
                String senha = txtSenha.getText().toString();

                // Verificando senha e login
                if(login.equals("admin") && senha.equals("admin"))
                {
                    //Login
                    //Intent
                    Intent it = new Intent(MainActivity.this,
                                                        Tela2.class);
                    startActivity(it);

                }
                else
                {
                    //Deu ruim
                    Toast.makeText(MainActivity.this,
                                   "Usuário Inexistente!!!",
                                    Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}