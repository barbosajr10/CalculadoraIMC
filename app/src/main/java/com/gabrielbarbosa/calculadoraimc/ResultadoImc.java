package com.gabrielbarbosa.calculadoraimc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultadoImc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_imc);

        TextView tVSituacao = findViewById(R.id.tVSituacao);
        TextView tVResultado = findViewById(R.id.tVResultado);

        ImageView magreza = findViewById(R.id.magreza);
        ImageView pesonormal = findViewById(R.id.pesonormal);
        ImageView sobrepeso = findViewById(R.id.sobrepeso);
        ImageView obesidade = findViewById(R.id.obesidade);
        ImageView obesidadegrave = findViewById(R.id.obesidadegrave);


        CalcularIMC c = (CalcularIMC) getIntent().getSerializableExtra("calcular");

        tVSituacao.setText((c.getSituacao()));
        tVResultado.setText(String.valueOf(c.getResultado()));

            c.calculo();
            c.situacao();

            if (c.getResultado() < 18.5) {
                tVSituacao.setTextColor(getResources().getColor(R.color.Magreza));
                tVResultado.setTextColor(getResources().getColor(R.color.Magreza));
                // imagem
                magreza.setVisibility(View.VISIBLE);
            } else if (c.getResultado() < 24.9) {
                tVSituacao.setTextColor(getResources().getColor(R.color.PesoNormal));
                tVResultado.setTextColor(getResources().getColor(R.color.PesoNormal));
                // imagem
                pesonormal.setVisibility(View.VISIBLE);
            } else if (c.getResultado() < 29.9) {
                tVSituacao.setTextColor(getResources().getColor(R.color.Sobrepeso));
                tVResultado.setTextColor(getResources().getColor(R.color.Sobrepeso));
                // imagem
                sobrepeso.setVisibility(View.VISIBLE);
            } else if (c.getResultado() < 39.9) {
                tVSituacao.setTextColor(getResources().getColor(R.color.Obesidade));
                tVResultado.setTextColor(getResources().getColor(R.color.Obesidade));
                // imagem
                obesidade.setVisibility(View.VISIBLE);
            } else if (c.getResultado() >= 40.0) {
                tVSituacao.setTextColor(getResources().getColor(R.color.Obesidadegrave));
                tVResultado.setTextColor(getResources().getColor(R.color.Obesidadegrave));
                // imagem
                obesidadegrave.setVisibility(View.VISIBLE);
            }

        tVResultado.setText("Seu IMC: " + (String.format("%.2f",c.getResultado())));

        tVSituacao.setText(String.valueOf(c.getSituacao()));

    }
}
