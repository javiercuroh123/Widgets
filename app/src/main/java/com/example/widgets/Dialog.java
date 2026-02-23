package com.example.widgets;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Dialog extends AppCompatActivity {

    Button btnPregunta;

    private void loadUi(){
        btnPregunta = findViewById(R.id.btnPreguntar);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dialog);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        loadUi();

        btnPregunta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarPregunta();
            }
        });
    }
    private void mostrarPregunta(){
        AlertDialog.Builder builder = new AlertDialog.Builder(Dialog.this);
        builder.setTitle("Confirmacion");
        builder.setMessage("Estas seguro de guardar");

        builder.setPositiveButton("Si", (dialog, which) ->{
            Log.i("Respuesta", "Aceptando");
        });

        builder.setNegativeButton("No", null);

        AlertDialog dialog = builder.create();
        dialog.show();
    }

}