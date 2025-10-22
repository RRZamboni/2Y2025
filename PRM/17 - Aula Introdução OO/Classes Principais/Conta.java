package com.example.myapplication;

public class Conta
{
    //Atributos - simulando um valor!!!
    double saldo = 10000;

    //Método Saque
    public double Saque(double valorS)
    {
         saldo = saldo - valorS;
         return saldo;
    }


}
