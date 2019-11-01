package com.example.multiplicardosapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ActCalcular2 extends AppCompatActivity {
	private Button multiplica;
	private EditText numero;
	private EditText duplicado;
	protected LinearLayout layout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_act_calcular2);

		multiplica = findViewById(R.id.duplicar);
		numero = findViewById(R.id.numero);
		duplicado = findViewById(R.id.duplicado);
		layout = findViewById(R.id.layoutID);


		Bundle parametros = this.getIntent().getExtras();
		if(parametros !=null){
			String datos = parametros.getString("nombre");
			TextView nombre = new TextView(this);
			layout.addView(nombre);
			nombre.setText(datos);
		}

		multiplica.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				float contenido;
				int entero;
				if(numero.length() > 0){
					contenido = Float.parseFloat(numero.getText().toString()) * 2;
					Log.e("prueba", "llega");
					if(contenido % 1 == 0){
						entero = Integer.parseInt(numero.getText().toString()) * 2;
						duplicado.setText(String.valueOf(entero));
					} else {
						duplicado.setText(String.valueOf(contenido));
					}
				} else {
					Toast.makeText(getApplicationContext(), "El campo esta vacio", Toast.LENGTH_SHORT).show();
				}
			}
		});
	}
}

