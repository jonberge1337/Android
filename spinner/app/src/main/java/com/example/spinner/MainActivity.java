package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
	private TextView titulo;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Spinner elementos = findViewById(R.id.spinnerElementos);
		titulo = findViewById(R.id.lblSpinnerSeleccionado);

		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.elementos, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		elementos.setAdapter(adapter);

		elementos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				String sentencia = "Tienes seleccionado " + parent.getItemAtPosition(position).toString();
				titulo.setText(sentencia);
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				titulo.setText("");
			}
		});
	}
}
