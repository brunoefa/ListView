package com.treinamento.listview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void parte1(View view) {
		Intent intent = new Intent(this, Parte1.class);
		startActivity(intent);
	}
	
	public void parte2(View view) {
		Intent intent = new Intent(this, Parte2.class);
		startActivity(intent);
	}
	
	public void parte3(View view) {
		Intent intent = new Intent(this, Parte3.class);
		startActivity(intent);
	}
	
	public void parte4(View view) {
		Intent intent = new Intent(this, Parte4.class);
		startActivity(intent);
	}
	
	public void parte5(View view) {
		Intent intent = new Intent(this, Parte5.class);
		startActivity(intent);
	}

}
