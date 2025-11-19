package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

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
    Button btnSalvar, btnSelecionar, btnDeletar, btnAtualizar;

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

        //Abrindo o BD
        AbrirCriarBD();

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
        
    }


    public void Deletar()
    {

    }

    public void Atualizar()
    {

    }


    public void Selecionar()
    {

    }
}