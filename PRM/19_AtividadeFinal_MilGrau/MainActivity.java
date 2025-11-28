package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    //atributos
    EditText txtID, txtNome, txtCurso;
    Button btnSalvar, btnSelecionar, btnDeletar, btnAtualizar, btnListar;

    //Classe SQLiteDatabase -> Resp. por todas operações do BD
    SQLiteDatabase dbShow;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //linkando
        txtID = (EditText) findViewById(R.id.txtID);
        txtCurso = (EditText) findViewById(R.id.txtCurso);
        txtNome = (EditText) findViewById(R.id.txtNome);
        btnSalvar = (Button) findViewById(R.id.btnSalvar);
        btnSelecionar = (Button) findViewById(R.id.btnSelecionar);
        btnDeletar = (Button) findViewById(R.id.btnDeletar);
        btnAtualizar = (Button) findViewById(R.id.btnAtualizar);
        btnListar = (Button) findViewById(R.id.btnListar);

        //Abrindo o BD
        AbrirCriarBD();

        //btnSalvar
        btnSalvar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Salvar();

            }
        });

        //btnSelecionar
        btnSelecionar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                SelecionarUnico();
            }
        });

        //btnListar
        btnListar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent it = new Intent(MainActivity.this,
                                    ListaActivity.class);
                startActivity(it);
            }
        });


    }

    public void AbrirCriarBD()
    {
        //1) Variável para receber a query
        String sql;

        //2) Tentando abrir/Criar o BD
        try {

            //3) Criando a tabela caso a mesma não exista
            sql = "CREATE TABLE IF NOT EXISTS Alunos (" +
                "Matricula INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "Nome TEXT," +
                    "Curso TEXT)";

            //4) Criar/Abrir o BD
            dbShow = openOrCreateDatabase("ETEC",
                                         MODE_PRIVATE
                                          ,null);

            //5) Executando a query
            dbShow.execSQL(sql);

            //6) Mostrando mens
            Toast.makeText(MainActivity.this,
                                  "Sistema carregado com Sucesso!",
                                        Toast.LENGTH_LONG).show();

        }
        catch (Exception erro)
        {
            //Se ocorreu um erro... mens. de erro
            Toast.makeText(MainActivity.this,
                             "Erro ao carregar o Sistema"
                                     + erro.getMessage(),
                                      Toast.LENGTH_LONG).show();
        }
    }//AbrirCriarDB()


    public void Salvar()
    {
        //Iniciando os EditText
        txtNome = (EditText) findViewById(R.id.txtNome);
        txtCurso = (EditText) findViewById(R.id.txtCurso);

        //Var.p/ query
        String sql;

        try
        {
            //Criando a query
            sql = "INSERT INTO Alunos(Nome,Curso)VALUES(" +
                    "'"+txtNome.getText().toString()+"'," +
                    "'"+txtCurso.getText().toString()+"')";

            //Executar a query, colocamos tdo o query aq dentro pela variável sql
            dbShow.execSQL(sql);

            //Mens de sucesso
            Toast.makeText(MainActivity.this,
                    "Alunos Cadstrados com Sucesso! bjus",
                    Toast.LENGTH_LONG).show();
        }
        catch (Exception erro)
        {
            //Mens de Erro
            Toast.makeText(MainActivity.this,
                        "Erro ao cadastrar aluno. " +
                            erro.getMessage(),
                            Toast.LENGTH_LONG).show();
        }
    }


    public void Deletar()
    {

    }

    public void Atualizar()
    {

    }


    public void SelecionarUnico()
    {
        //1) Recuperando valor do ID
        txtID = (EditText) findViewById(R.id.txtID);

        //2) Query para select
        String sql = "SELECT * FROM Alunos WHERE Matricula = " +
                     txtID.getText().toString();

        try
        {
            //3) Criando um cursor para anarmazenar os dados
            Cursor cursor;

            //4) Executando a query e salvando os resultados
            cursor = dbShow.rawQuery(sql,null);

            //5) Montando uma mensagem babaca
            String mensagem = "Nome: " + cursor.getString(1);

            Toast.makeText(MainActivity.this,
                            mensagem,
                         Toast.LENGTH_LONG).show();

        }
        catch (Exception erro)
        {
            Toast.makeText(MainActivity.this,
                            "ERRO:" + erro.getMessage(),
                            Toast.LENGTH_LONG).show();
        }
    }
}