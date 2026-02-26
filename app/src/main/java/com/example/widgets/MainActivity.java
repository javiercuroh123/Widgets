package com.example.widgets;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnButton, btnCheckBox, btnDialog, btnRadioButtons, btnRViews, btnSwitchs, btnToats;

    private void loadUi() {
        btnButton = findViewById(R.id.btnButtons);
        btnCheckBox = findViewById(R.id.btnCheckBox);
        btnDialog = findViewById(R.id.btnDialog);
        btnRadioButtons = findViewById(R.id.btnRadioButton);
        btnRViews = findViewById(R.id.btnRViews);
        btnSwitchs = findViewById(R.id.btnSwitch);
        btnToats = findViewById(R.id.btnToast);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        loadUi();

        btnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Buttons.class);
                startActivity(intent);
            }
        });

        btnCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Checkboxs.class);
                startActivity(intent);
            }
        });

        btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Dialog.class);
                startActivity(intent);
            }
        });

        btnRadioButtons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RadioButtons.class);
                startActivity(intent);
            }
        });

        btnRViews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RecyclerViews.class);
                startActivity(intent);
            }
        });

        btnSwitchs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Switchs.class);
                startActivity(intent);
            }
        });

        btnToats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Toats.class);
                startActivity(intent);
            }
        });
    }
}