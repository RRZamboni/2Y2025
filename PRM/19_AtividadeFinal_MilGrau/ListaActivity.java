package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListaActivity extends AppCompatActivity
{
    //1) Atributo
    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        //2) Iniciando a lista (Layout)
        lista = (ListView) findViewById(R.id.lista);

        //3) ArrayList<>
        ArrayList<Aluno> listaAlunos = new ArrayList<Aluno>();

        //4) Banco de dados
        SQLiteDatabase bcoDados =
                openOrCreateDatabase("ETEC",MODE_PRIVATE,null);

        //5) Cursor para receber os dados
        Cursor resultado = bcoDados.rawQuery("SELECT * FROM Alunos",
                                            null);
        //6) Percorrendo o Cursor
        while(resultado.moveToNext())
        {
            //Preenchendo a entidade Aluno
            Aluno aluno = new Aluno();
            aluno.setMatricula(resultado.getInt(0));
            aluno.setNome(resultado.getString(1));
            aluno.setCurso(resultado.getString(2));

            //Adiciono o aluno no ArrayList
            listaAlunos.add(aluno);
        }

        //7) Adaptando o ArrayList
        ArrayAdapter<Aluno> adaptador = new
                      ArrayAdapter<Aluno>(ListaActivity.this,
                                 android.R.layout.simple_list_item_1,
                                    listaAlunos);

        //8) Inserindo a lista adaptada no ListView
        lista.setAdapter(adaptador);
    }
}