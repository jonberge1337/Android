package com.example.listviewtraduccionescompletoapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
	private ListView idiomas;
	private TextView seleccionado;
	private Traduccion datos[];


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		int cantidad = getResources().getStringArray(R.array.paises).length;
		datos = new Traduccion[cantidad];
		for (int i = 0; i < cantidad ; i++) {
			datos[i] = new Traduccion(getResources().getStringArray(R.array.paises)[i], getResources().getStringArray(R.array.traducciones)[i]);
		}

		MiAdaptador adaptador = new MiAdaptador(this, datos);
		seleccionado = findViewById(R.id.txtSeleccionado);
		idiomas = findViewById(R.id.listaTraducciones);
		idiomas.setAdapter(adaptador);
		idiomas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				seleccionado.setText(datos[position].getTraduccion());
			}
		});

	}

}
