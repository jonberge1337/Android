package com.example.holdertraduccionesapp;

import android.app.Activity;
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
	static class ViewHolder{
		protected TextView titulo;
		protected TextView descripcion;
	}
	public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
		Traduccion traduccion;
		traduccion = datos[position];
		View item = null;

		if (convertView == null){
			LayoutInflater inflater = contexto.getLayoutInflater();
			item = inflater.inflate(R.layout.idioma, null);
			final ViewHolder holder = new ViewHolder();
			holder.titulo = item.findViewById(R.id.txtIdioma);
			holder.descripcion = item.findViewById(R.id.txtTraduccion);
			item.setTag(holder);
		} else {
			item = convertView;
		}

		ViewHolder holder = (ViewHolder) item.getTag();
		holder.titulo.setText(traduccion.getPais());
		holder.descripcion.setText(traduccion.getTraduccion());

		return item;
	}
}
