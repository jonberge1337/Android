package com.example.calificacionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
	private Button botonMostrar;
	private Button botonLimpiar;
	private EditText alumno;
	private  EditText calificacion;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		limpiar(botonLimpiar);
		mostrar(botonMostrar);
	}

	public void limpiar(View view){
		botonLimpiar = findViewById(R.id.limpiar);
		alumno = findViewById(R.id.alumno);
		calificacion = findViewById(R.id.calificacion);
		botonLimpiar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				calificacion.setText("");
				alumno.setText("");
			}
		});
	}

	public void mostrar(View view){
		botonMostrar = findViewById(R.id.mostrar);
		calificacion = findViewById(R.id.calificacion);
		botonMostrar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				float numero;
				String cantidad;
				String respuesta;
				cantidad = calificacion.getText().toString();
				numero = Float.parseFloat(cantidad);
				if (numero > 0 && numero <= 10.5){
					respuesta = "Malo";
				} else if (numero > 10.5 && numero <= 14){
					respuesta = "Regular";
				} else if (numero > 14 && numero <= 18){
					respuesta = "Bueno";
				} else if (numero > 18 && numero <= 20){
					respuesta = "Excelente";
				} else {
					respuesta = "No has introducido una nota correcta";
					calificacion.setText("");
				}
				Toast.makeText(getApplicationContext(), respuesta, Toast.LENGTH_SHORT).show();
			}
		});
	}
}
