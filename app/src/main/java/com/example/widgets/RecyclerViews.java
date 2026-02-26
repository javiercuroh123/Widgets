package com.example.widgets;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViews extends AppCompatActivity {

    ArrayList<String> listaAlumnos = new ArrayList<>();

    RecyclerView recyclerAlumnos;

    private void loadUi(){
        recyclerAlumnos = findViewById(R.id.recyclerAlumnos);
    }

    private void alumnosLista(){
        listaAlumnos.add("Juan");
        listaAlumnos.add("Pedro");
        listaAlumnos.add("Ivan");
        listaAlumnos.add("Juanita");
        listaAlumnos.add("Lucero");
        listaAlumnos.add("Brian");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recycler_views);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        loadUi();
        alumnosLista();
        recyclerAlumnos.setLayoutManager(new LinearLayoutManager(this));

        AdapterDatos adaptador = new AdapterDatos(listaAlumnos);

        recyclerAlumnos.setAdapter(adaptador);
    }
}