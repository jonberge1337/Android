package com.example.hipotenusaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
	private EditText catetoC;
	private EditText catetoB;
	private Button limpiar;
	private Button calcular;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		catetoB = findViewById(R.id.editText2);
		catetoC = findViewById(R.id.editText);
		limpiar=findViewById(R.id.boton0);
		calcular=findViewById(R.id.boton1);

		activacionBoton(catetoB, limpiar);
//		activacionBoton(catetoC, limpiar);
		clickandoBoton(limpiar);
	}

	public void activacionBoton(EditText cateto, final Button boton){
		cateto.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {

			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				if (s.toString().trim().length() == 0){
					boton.setEnabled(false);
					Log.e("Desactivado", "boton");
				} else {
					boton.setEnabled(true);
					Log.e("Activado", "Boton");
				}
			}

			@Override
			public void afterTextChanged(Editable s) {

			}
		});
	}

	public void clickandoBoton(Button boton){
		boton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.e("Llega", "evento");
				Toast.makeText(getApplicationContext(), "Prueba", Toast.LENGTH_SHORT).show();
			}
		});
	}
}
