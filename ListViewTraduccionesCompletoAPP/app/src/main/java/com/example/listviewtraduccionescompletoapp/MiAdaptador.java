package com.example.listviewtraduccionescompletoapp;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MiAdaptador extends ArrayAdapter<Traduccion> {
	private Activity contexto;
	private Traduccion[] datos;

	public MiAdaptador(Activity context, Traduccion[] datos) {
		super(context, R.layout.idioma, datos);
		this.contexto = context;
		this.datos = datos;
	}
	public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
		LayoutInflater inflater = contexto.getLayoutInflater();
		View item = inflater.inflate(R.layout.idioma, null);

		TextView titulo;
		TextView descripcion;

		titulo = item.findViewById(R.id.txtIdioma);
		descripcion = item.findViewById(R.id.txtTraduccion);

		String p = datos[position].getPais();
		String t = datos[position].getTraduccion();
		int cantdad = datos.length;
		Log.e("variable", p);
		Log.e("Cantidad", String.valueOf(cantdad));
//			try{
		titulo.setText(p);
		descripcion.setText(t);
//			} catch (Exception e){
//				Toast.makeText(contexto.getApplicationContext(), "Fallo" ,Toast.LENGTH_SHORT).show();
//			}

		return item;
	}
}
