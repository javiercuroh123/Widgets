package com.example.widgets;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Switchs extends AppCompatActivity {

    SwitchCompat switchTerminos;

    Button btnContinuar;

    private void loadUi(){
        switchTerminos = findViewById(R.id.switchTerminos);
        btnContinuar = findViewById(R.id.btnContinuar);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_switchs);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            //v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        loadUi();

        btnContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validarTerminos();

            }

            private void validarTerminos() {
                if (switchTerminos.isChecked()) {
                    Toast.makeText(getApplicationContext(), "Gracias por aceptar", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "No aceptaste el contrato", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}