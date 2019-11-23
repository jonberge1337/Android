package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
	private ListView listav;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		listav = findViewById(R.id.listID);

		String[] s = getResources().getStringArray(R.array.opciones);
		ArrayAdapter<String> adapter;
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, s);
		listav.setAdapter(adapter);

		listav.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				String seleccionado = parent.getItemAtPosition(position).toString();
				Toast.makeText(getApplicationContext(), seleccionado + " esta seleccionado", Toast.LENGTH_SHORT).show();
			}
		});
	}
}
