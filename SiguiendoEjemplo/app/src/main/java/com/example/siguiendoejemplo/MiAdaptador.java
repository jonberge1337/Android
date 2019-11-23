package com.example.siguiendoejemplo;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MiAdaptador extends BaseAdapter {
	ArrayList<Titular> titulares;

	public MiAdaptador(ArrayList<Titular> titulares){
		this.titulares = titulares;
	}
	@Override
	public int getCount() {
		return titulares.size();
	}

	@Override
	public Object getItem(int position) {
		return titulares.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View viewProduct;
		if(convertView == null){
			viewProduct = View.inflate(parent.getContext(), R.layout.lista_layout, null);
		} else {
			viewProduct = convertView;
		}

		Titular titular = (Titular) getItem(position);
		((TextView) viewProduct.findViewById(R.id.txtTitulo)).setText(titular.getTitulo());
		((TextView) viewProduct.findViewById(R.id.txtSubtitulo)).setText(titular.getSubTitulo());

		return viewProduct;
	}
}
