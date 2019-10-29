package com.example.abriractividad;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class Datos extends Activity {
    private TextView texto;
    private Button aceptar;
    private Button rechazar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datos);

        Bundle extras = getIntent().getExtras();
        texto = findViewById(R.id.textView2);
        aceptar = findViewById(R.id.btnAceptar);
        rechazar = findViewById(R.id.btnRechazar);

        texto.setText("Hola "+ extras.getString("nombre"));

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                devolver(true);
            }
        });

        rechazar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                devolver(false);
            }
        });
    }
    public void devolver(boolean resultado){
        Intent intent = new Intent();
        intent.putExtra("resultado", resultado);
        setResult(RESULT_OK, intent);
        finish();
    }
}

