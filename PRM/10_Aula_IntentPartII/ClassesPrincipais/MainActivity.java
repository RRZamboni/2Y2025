package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    // 1) Atributos
    EditText txtNome, txtEmail, txtSenha, txtConfsenha;

    Button btnSalvar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // 2) Inicio
        txtNome = (EditText) findViewById(R.id.txtNome);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtSenha = (EditText) findViewById(R.id.txtSenha);
        txtConfsenha = (EditText) findViewById(R.id.txtConfSenha);
        btnSalvar= (Button) findViewById(R.id.btnSalvar);


        //3) Botao salvar
        btnSalvar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //Recuperar valores
                String nome = txtNome.getText().toString();
                String email = txtEmail.getText().toString();
                String senha = txtSenha.getText().toString();
                String confSenha = txtConfsenha.getText().toString();

                // Confirmar a senha
                if(senha.equals(confSenha))
                {
                    //Intent
                    Intent it = new Intent(MainActivity.this,
                                            Tela2.class);

                    //Passando os valores
                    it.putExtra("Valor1",nome);
                    it.putExtra("Valor2",email);
                    it.putExtra("Valor3",senha);

                    //Iniciando a outra tela
                    startActivity(it);



                }
                else
                {
                    //Deu ruim
                }

            }
        });

    }
}