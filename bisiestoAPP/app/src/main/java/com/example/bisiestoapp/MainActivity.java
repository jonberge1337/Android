package com.example.bisiestoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
	private Button botonVerificar;
	private EditText aino;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		verificar();
	}

	public void verificar(){
		botonVerificar = findViewById(R.id.botonVerifica);
		aino = findViewById(R.id.textAino);

		botonVerificar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				int calculo;
				String respuesta;
				boolean bisiesto = false;
				calculo = Integer.parseInt(aino.getText().toString());
				if (calculo % 4 == 0 && calculo % 100 != 0){
					bisiesto = true;
				} else if (calculo % 4 == 0 && calculo % 400 == 0){
					bisiesto = true;
				}
				respuesta = bisiesto ? "Es bisiesto" : "No es bisiesto";
				Toast.makeText(getApplicationContext(), respuesta, Toast.LENGTH_SHORT).show();
			}
		});
	}
}
