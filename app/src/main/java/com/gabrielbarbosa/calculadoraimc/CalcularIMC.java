package com.gabrielbarbosa.calculadoraimc;

import java.io.Serializable;

public class CalcularIMC implements Serializable {
    private double altura;
    private double peso;
    private String situacao;
    private double resultado;


    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getAltura() {
        return altura;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getPeso() {
        return peso;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    public void calculo(){
        resultado = ((peso / (altura * altura)));
    }

    public void situacao(){
        if ( resultado < 18.5) {
            situacao = "Magreza";

        }else if (resultado < 24.9 ){
            situacao = "Peso Normal";

        }else if (resultado < 29.9){
            situacao = "Sobrepeso";

        }else if (resultado <39.9){
            situacao = "Obesidade";

        }else if (resultado >= 40.0){
            situacao = "Obesidade grave";
        }
    }

}










