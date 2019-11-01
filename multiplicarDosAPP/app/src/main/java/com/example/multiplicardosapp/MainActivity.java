package com.example.multiplicardosapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
	private EditText nombre;
	private Button calcular;
	private Button salir;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		nombre = findViewById(R.id.txtUsuario);
		calcular = findViewById(R.id.btnCalcular);
		salir = findViewById(R.id.btnSalir);

		salir.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});

		calcular.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(nombre.length() > 0){
					Intent actividad = new Intent(getApplicationContext(), ActCalcular2.class);
					actividad.putExtra("nombre", nombre.getText().toString());
					startActivity(actividad);
				} else {
					Toast.makeText(getApplicationContext(), "El campo del usuario es obligatorio", Toast.LENGTH_SHORT).show();
				}
			}
		});
	}
}
