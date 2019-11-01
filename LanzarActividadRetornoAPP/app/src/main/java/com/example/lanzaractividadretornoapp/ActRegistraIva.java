package com.example.lanzaractividadretornoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ActRegistraIva extends AppCompatActivity {
	private RadioGroup grupo;
	private RadioButton cuatro;
	private RadioButton diez;
	private RadioButton veintiUno;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_act_registra_iva);

		Intent intencion = getIntent();

		grupo = findViewById(R.id.grupo);
		cuatro = findViewById(R.id.cuatro);
		diez = findViewById(R.id.diez);
		veintiUno = findViewById(R.id.veintiUno);

		grupo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				int numero;
				if(cuatro.isChecked()){
					numero = 4;
				} else if(diez.isChecked()){
					numero = 10;
				} else {
					numero = 21;
				}
				Intent vuelta = new Intent();
				vuelta.putExtra("iva", numero);
				setResult(RESULT_OK, vuelta);
				finish();

			}
		});
	}
}
