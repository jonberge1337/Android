package com.example.lanzaractividadretornoapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
	private EditText articulo;
	private EditText importe;
	private Button iva;
	private LinearLayout result;
	private TextView conIva;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		articulo = findViewById(R.id.articulo);
		importe = findViewById(R.id.importe);
		iva = findViewById(R.id.iva);
		result = findViewById(R.id.layoutInvisible);
		conIva = findViewById(R.id.resultado);


		clickIva();
	}

	public void clickIva(){
		iva.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (articulo.length() > 0 && importe.length() > 0){
					Intent intencion = new Intent(MainActivity.this, ActRegistraIva.class);
					startActivityForResult(intencion, 1 );
				} else {
					Toast.makeText(getApplicationContext(), "Primero tienes que rellenar los campos", Toast.LENGTH_SHORT).show();
				}
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if (requestCode == 1){

			if(resultCode == RESULT_OK){
				result.setVisibility(View.VISIBLE);
				float vuelta = data.getIntExtra("iva", 0);
				Log.e("resultado", String.valueOf(vuelta));
				float imp = Float.parseFloat(importe.getText().toString());
				float iva = imp * (vuelta / 100);
				float total = imp + iva;
				Log.e("Iva", String.valueOf(iva));
				vuelta += iva;
				if(vuelta % 1 == 0){
					int totalEntero = (int) total;
					conIva.setText(String.valueOf(totalEntero));
				} else {
					conIva.setText(String.valueOf(total));
				}

			}
		}
	}
}
