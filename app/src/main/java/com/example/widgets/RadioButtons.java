package com.example.widgets;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RadioButtons extends AppCompatActivity {

    RadioButton i5, i3, i7;

    RadioButton m8, m16, m32;

    RadioButton gi, gin;

    TextView edCore, edMemoria, precioTotal, edGrafica;

    Button calcular;

    private void loadUi() {
        i5 = findViewById(R.id.i5);
        i3 = findViewById(R.id.i3);
        i7 = findViewById(R.id.i7);
        m8 = findViewById(R.id.m8);
        m16 = findViewById(R.id.m16);
        m32 = findViewById(R.id.m32);
        gi = findViewById(R.id.gi);
        gin = findViewById(R.id.gin);
        edCore = findViewById(R.id.edCore);
        edMemoria = findViewById(R.id.edMemoria);
        precioTotal = findViewById(R.id.precioTotal);
        calcular = findViewById(R.id.calcular);
        edGrafica = findViewById(R.id.edGrafica);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_radio_buttons);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            //v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        loadUi();

        calcular.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                calcularPago();
            }
        });
    }

    private void calcularPago() {
        double preciototal = 0, preciomemoria = 0, preciotarjeta = 0;
        double totalpagar = 0;

        if (i3.isChecked()){
            preciototal =500;
        }
        if (i5.isChecked()){preciototal =800;}
        if (i7.isChecked()){preciototal =1500;}

        if (m8.isChecked()){preciomemoria =500;}
        if (m16.isChecked()){preciomemoria =300;}
        if (m32.isChecked()){preciomemoria =600;}

        if (gin.isChecked()){preciotarjeta =800;}

        totalpagar = preciototal + preciomemoria + preciotarjeta;

        edCore.setText(String.valueOf(precioTotal));
        edMemoria.setText(String.valueOf(preciomemoria));
        edGrafica.setText(String.valueOf(preciotarjeta));

        precioTotal.setText(String.valueOf(totalpagar));
    }
}