package com.example.siguiendoejemplo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
	private TextView tituloVentana;
	ArrayList<Titular> titulares;
	MiAdaptador adaptador;
	ListView vistas;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		titulares = new ArrayList<>();
		titulares.add(new Titular("Prueba 1", "Esto es una prueba"));
		titulares.add(new Titular("Prueba 2", "Esto es una prueba"));
		titulares.add(new Titular("Prueba 3", "Esto es una prueba"));
		titulares.add(new Titular("Prueba 4", "Esto es una prueba"));
		titulares.add(new Titular("Prueba 5", "Esto es una prueba"));

		vistas = findViewById(R.id.lstTitulos);
		adaptador = new MiAdaptador(titulares);
		vistas.setAdapter(adaptador);
		tituloVentana = findViewById(R.id.tituloMain);

		vistas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Titular titular = (Titular) parent.getItemAtPosition(position);

				String frase = "Tienes seleccionado el titulo " + titular.getTitulo();
				tituloVentana.setText(frase);
			}
		});

	}
}
