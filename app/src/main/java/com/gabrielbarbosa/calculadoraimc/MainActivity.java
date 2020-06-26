package com.gabrielbarbosa.calculadoraimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CalcularIMC c = new CalcularIMC();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // seek bar
        SeekBar seekBarA = findViewById(R.id.seekBarAltura);
        SeekBar seekbarP = findViewById(R.id.seekBarPeso);

        seekBarA.setOnSeekBarChangeListener(seekBarAltura);
        seekbarP.setOnSeekBarChangeListener(seekBarPeso);

        // Text view
        final TextView eTAltura = findViewById(R.id.eTAltura);
        final TextView eTPeso = findViewById(R.id.eTPeso);
        final TextView eTSituacao = findViewById(R.id.eTSituacao);
        final TextView eTResultado = findViewById(R.id.eTResultado);


        // Bottom
        Button bCalcular = findViewById(R.id.bCalcular);

        bCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalcularIMC c = new CalcularIMC();

                c.calculo();
                c.situacao();

                c.setAltura(Double.parseDouble(eTAltura.getText().toString().replace(",",".")));
                c.setPeso(Double.parseDouble(eTPeso.getText().toString().replace(",",".")));

                Intent intent = new Intent(getBaseContext(), ResultadoImc.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("calcular", c);
                intent.putExtras(bundle);

                startActivity(intent);

                // eTResultado.setText("Seu IMC: " + (String.format("%.2f",c.getResultado())));

                // eTSituacao.setText(String.valueOf(c.getSituacao()));

            }
        });

    }

    SeekBar.OnSeekBarChangeListener seekBarAltura = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            TextView eTAltura = findViewById(R.id.eTAltura);
            float progresso = progress * 0.01f;
            String altura = String.format("%.2f", progresso);
            eTAltura.setText(altura);
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }

    };

    SeekBar.OnSeekBarChangeListener seekBarPeso = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            TextView eTPeso = findViewById(R.id.eTPeso);
            float progresso = progress * 0.01f;
            String peso = String.format("%.1f", progresso);
            eTPeso.setText(peso);
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };
}