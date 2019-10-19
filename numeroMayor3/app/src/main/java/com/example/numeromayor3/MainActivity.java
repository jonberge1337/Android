package com.example.numeromayor3;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
	private EditText t1;
	private EditText t2;
	private EditText t3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mayor();
	}

	public void mayor(){
		Button boton = findViewById(R.id.boton0);
		t1 = findViewById(R.id.txt1);
		t2 = findViewById(R.id.txt2);
		t3 = findViewById(R.id.txt3);

		boton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				EditText[] array = {t1, t2, t3};
				int maximo = Integer.parseInt(array[0].getText().toString());
				int number;
				boolean vacio = false;

				for (int j = 0; j < array.length; j++) {

						if(array[j].getText().toString().matches("")){
							vacio = true;
						}
				}
				if (vacio){
					AlertDialog alerta = new AlertDialog.Builder(MainActivity.this).create();
					alerta.setTitle("Alerta");
					alerta.setMessage("Tienes algun campo vacio");
					alerta.setButton(AlertDialog.BUTTON_NEUTRAL, "Aceptar", new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							dialog.dismiss();
						}
					});
					alerta.show();
				} else{
					for (int i = 1; i < array.length; i++){
						number = Integer.parseInt(array[i].getText().toString());
						if (number > maximo) {
							maximo = number;
							Log.i("El valor de maximo", String.valueOf(maximo));
						}
					}
					Toast.makeText(getApplicationContext(), "El maximo es " + maximo, Toast.LENGTH_SHORT).show();
				}
			}
		});
	}

}
