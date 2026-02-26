package com.example.widgets;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Toats extends AppCompatActivity {

    Button lento, rapido;

    private void loadUi() {
        lento = findViewById(R.id.lento);
        rapido = findViewById(R.id.rapido);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_toats);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        loadUi();

        lento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notificar("Lento", false);
            }
        });

        rapido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notificar("Rapido", false);

            }
        });
    }

    private void notificar(String mensaje, boolean tiempoExtendido) {
        int duration = (tiempoExtendido) ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT;
        Toast.makeText(getApplicationContext(), mensaje, duration).show();
    }
}