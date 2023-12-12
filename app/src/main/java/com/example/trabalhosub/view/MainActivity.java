package com.example.trabalhosub.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.trabalhosub.R;

public class MainActivity extends AppCompatActivity {

    Button btRequisitarDados;
    Button btMostrarDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btRequisitarDados = findViewById(R.id.btRequisitarDados);
        btMostrarDados = findViewById(R.id.btMostrarDados);

        // Método para solicitar os dados para a API


        // Método para mostrar os dados depois de solicitar para a API
        btMostrarDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}