Para abrir nueva ventana:
```java
calcular.setOnClickListener(new View.OnClickListener() {
	@Override
	public void onClick(View v) {
		if (numero.length() > 0) {
			int n = Integer.parseInt(numero.getText().toString());
			Intent intencion = new Intent(MainActivity.this, receptor.class); // se crea la intencion 
			intencion.putExtra("valor", n * 2); // se añaden todos los valores que quieras mandas con putExtra ("variable", valor)
	    	startActivity(intencion); // lanzamos la ventana
		}
	}
});
```
recibimos de esta manera:
```java
Intent intencion = getIntent();
int duplicado = intencion.getIntExtra("valor", 0); // aqui al recoger es el nombre de la variable y en caso de que no haya el valor por defecto
```

---

Si queremos mandar para que despues venda devuelta cambian alguna cosa:
```java
calcular.setOnClickListener(new View.OnClickListener() {
	@Override
	public void onClick(View v) {
		if (numero.length() > 0) {
			int n = Integer.parseInt(numero.getText().toString());
			Intent intencion = new Intent(MainActivity.this, receptor.class);
			intencion.putExtra("valor", n * 2);
			startActivityForResult(intencion, 1);
		}
	}
});

```
Esto va en la segunda pantalla
```java
Intent intencion = getIntent();
int duplicado = intencion.getIntExtra("valor", 0);

texto.setText(String.valueOf(duplicado));
devolver.setOnClickListener(new View.OnClickListener() {
	@Override
	public void onClick(View v) {
		Intent devuelve = new Intent();
		devuelve.putExtra("vuelta", Integer.parseInt(texto.getText().toString())); // variable y valor
		setResult(RESULT_OK, devuelve);
		finish();
	}
});

```

Esto al recibir lo que viene de vuelta
```java

@Override //Esto despues de el on create
protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
	super.onActivityResult(requestCode, resultCode, data);

	if (requestCode == 1) {
		if (resultCode == RESULT_OK) { // comprobamos que ha llegado bien y en vez de recoger con el Intent lo recogemos con el data
			int resultado = data.getIntExtra("vuelta", 0);// variable y valor por defecto
			numero.setText(String.valueOf(resultado + 1));
		}
	}
}

```
---

