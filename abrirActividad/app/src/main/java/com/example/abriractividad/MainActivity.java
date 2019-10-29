package com.example.abriractividad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText texto;
    private Button verificar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        texto = findViewById(R.id.editText);
        verificar = findViewById(R.id.button);
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
        startActivityForResult(intencion, 1234);

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode==1234 && resultCode==RESULT_OK){
            String res = data.getExtras().getString("resultado");
        }
    }
}
