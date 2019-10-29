package com.example.operacionapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
	private Button limpiar;
	private Button calcular;
	private EditText n1;
	private EditText n2;
	private RadioButton suma;
	private RadioButton resta;
	private RadioButton multi;
	private RadioButton divi;
	private float numero1;
	private float numero2;
	private float total;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		limpiando();
		calculando();
	}

	public void limpiando(){
		limpiar = findViewById(R.id.lim);
		calcular = findViewById(R.id.cal);
		n1 = findViewById(R.id.editText);
		n2 = findViewById(R.id.editText2);
		limpiar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				n1.setText("");
				n2.setText("");
				calcular.setEnabled(false);
			}
		});

	}

	public void calculando(){
		calcular = findViewById(R.id.cal);
		n1 = findViewById(R.id.editText);
		n2 = findViewById(R.id.editText2);
		suma = findViewById(R.id.suma);
		resta = findViewById(R.id.resta);
		multi = findViewById(R.id.multi);
		divi = findViewById(R.id.divi);

		calcular.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (n1.getText().length() == 0 || n2.getText().length() == 0){
					Log.e("Ha entrado", " ");
					Toast.makeText(getApplicationContext(), "rellena los campos", Toast.LENGTH_SHORT).show();
				} else {
					numero1 = Float.valueOf(n1.getText().toString());
					numero2 = Float.valueOf(n2.getText().toString());

					if(suma.isChecked()){
						total = numero1 + numero2;
					} else if(resta.isChecked()){
						total = numero1 - numero2;
					} else	if(multi.isChecked()){
						total = numero1 * numero2;
					} else {
						if(numero2 != 0){
							total = numero1 / numero2;
						} else {
							Toast.makeText(getApplicationContext(), "no se puede dividir entre 0", Toast.LENGTH_SHORT).show();
						}
					}

					Toast.makeText(getApplicationContext(), "El resultado es " + total, Toast.LENGTH_SHORT).show();
				}
			}
		});
	}

}

