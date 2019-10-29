package com.example.validarfecha;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
	private EditText fecha;
	private Button verificar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


		alRellenar();
		alVerificar();

	}

	private void alVerificar() {
		verificar = findViewById(R.id.botonVerificar);
		verificar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				int año = 0;
				int actual = Calendar.getInstance().get(Calendar.YEAR);

				String años;
				fecha = findViewById(R.id.fechaAño);
				if(fecha.getText().length() > 0){
					try {
						año = Integer.parseInt(fecha.getText().toString().split("/")[2]);
						Toast.makeText(getApplicationContext(), "Tienes " + (actual - año) + " años", Toast.LENGTH_SHORT).show();
					} catch (Exception e){
						Toast.makeText(getApplicationContext(), "No has metido un formato correcto", Toast.LENGTH_SHORT).show();
					}
				}
			}
		});
	}

	public void alRellenar(){
		fecha = findViewById(R.id.fechaAño);
		verificar = findViewById(R.id.botonVerificar);
		fecha.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
				if(fecha.getText().length() > 0){
					verificar.setEnabled(true);
					verificar.setBackgroundColor(Color.parseColor("#3F51B5"));
					verificar.setTextColor(Color.WHITE);
				} else {
					verificar.setEnabled(false);
					verificar.setBackgroundColor(Color.BLACK);
				}

			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {

			}

			@Override
			public void afterTextChanged(Editable s) {

			}
		});
	}

}
