package com.example.abriractividad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText texto;
    private Button verificar;
    private TextView resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        texto = findViewById(R.id.editText);
        verificar = findViewById(R.id.button);
        resultado = findViewById(R.id.respuesta);
        verificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzarActividad();
            }
        });



    }
    public void lanzarActividad(){

        Intent intencion = new Intent(this, Datos.class);
        intencion.putExtra("nombre", texto.getText().toString());
        startActivityForResult(intencion, 1);

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode==1 && resultCode==RESULT_OK){
            Log.e("Ha entrado", "");
            boolean res = data.getExtras().getBoolean("resultado");
            String res1 = res ? "Aceptado" : "Rechazado";
            resultado.setText(res1);
        }
    }
}
