package com.example.listviewtraduccionescompletoapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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

		MiAdaptador adaptador = new MiAdaptador(this);
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

	class MiAdaptador extends ArrayAdapter<Traduccion>{
		Activity context;
		MiAdaptador(Activity context){
			super(context, R.layout.idioma, datos);
			this.context = context;
		}

		@NonNull
		@Override
		public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
			LayoutInflater inflater = getLayoutInflater();
			View item = inflater.inflate(R.layout.idioma, null);

			TextView titulo;
			TextView descripcion;

			titulo = findViewById(R.id.txtIdioma);
			descripcion = findViewById(R.id.txtTraduccion);

			String p = datos[position].getPais();
			String t = datos[position].getTraduccion();
			int cantdad = datos.length;
			Log.e("variable", p);
			Log.e("Cantidad", String.valueOf(cantdad));
			try{
				titulo.setText(p);
				descripcion.setText(t);
			} catch (Exception e){
//				Toast.makeText(getApplicationContext(), "Fallo" ,Toast.LENGTH_SHORT).show();
			}

			return item;
		}
	}
}
