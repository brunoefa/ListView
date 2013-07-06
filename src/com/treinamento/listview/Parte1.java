package com.treinamento.listview;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Parte1 extends ListActivity {

	private String[] lstEstados;

	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);

		//Criar um array de Strings, que ser� utilizado em seu ListActivity
		lstEstados = new String[] {"S�o Paulo", "Rio de Janeiro", "Minas Gerais", "Rio Grande do Sul", "Santa Catarina", "Paran�", "Mato Grosso", "Amazonas", "Cear�", "Bahia", "Acre"};

		//Criar um ArrayAdapter, que vai fazer aparecer as Strings acima em seu ListView
		this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lstEstados));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);

		//Pegar o item clicado
		Object o = this.getListAdapter().getItem(position);
		String lstrEstado = o.toString();

		//Apresentar o item clicado
		Toast.makeText(this, "Voc� clicou no estado : " + lstrEstado, Toast.LENGTH_SHORT).show();
	}

}
