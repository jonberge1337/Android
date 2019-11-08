package com.example.aciertaminumerocheckboxapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
	private Button verificar;
	private EditText numero;
	private CheckBox intentos;
	private CheckBox ayuda;
	private int incognita;
	private int inte;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		verificar = findViewById(R.id.btnVerificar);
		numero = findViewById(R.id.numero);
		intentos = findViewById(R.id.intentos);
		ayuda = findViewById(R.id.ayuda);
		this.inte = 0;

		this.incognita = (int) (Math.random() * 101);

		verificar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				int n;
				if (numero.length() > 0){
					n = Integer.parseInt(numero.getText().toString());
					Log.e("El numero aleatorio es", String.valueOf(incognita));

					if (intentos.isChecked() && inte > 9) {
						Toast.makeText(getApplicationContext(), "Has pasado el limite de intentos", Toast.LENGTH_SHORT).show();
					} else {
						if (n == incognita) {
							Toast.makeText(getApplicationContext(), "Has acertado", Toast.LENGTH_SHORT).show();
						} else {
							if (intentos.isChecked()){
								inte += 1;
							}
							if (ayuda.isChecked()) {
								if (n > incognita) {
									Toast.makeText(getApplicationContext(), "Es menor", Toast.LENGTH_SHORT).show();
								} else {
									Toast.makeText(getApplicationContext(), "Es mayor", Toast.LENGTH_SHORT).show();
								}
							} else {
								Toast.makeText(getApplicationContext(), "No has acertado", Toast.LENGTH_SHORT).show();
							}
						}
					}
				} else {
					if (intentos.isChecked() && inte > 9) {
						Toast.makeText(getApplicationContext(), "Has pasado el limite de intentos", Toast.LENGTH_SHORT).show();
					} else {
						Toast.makeText(getApplicationContext(), "No has introducido ningun numero", Toast.LENGTH_SHORT).show();
					}
				}
			}
		});
	}
}
