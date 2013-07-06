package com.treinamento.listview;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class Parte2 extends ListActivity {
	
	private String[] lstEstados;
	private ListView lista;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		lstEstados = new String[] {"São Paulo", "Rio de Janeiro", "Minas Gerais", "Rio Grande do Sul", "Santa Catarina", "Paraná", "Mato Grosso", "Amazonas", "Ceará", "Bahia", "Acre"};
		
		//Criar um ArrayAdapter, que vai fazer aparecer as Strings acima em seu ListView do tipo que checked
        this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, lstEstados));
        
        lista = getListView();
        lista.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);		
		
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		
		int tamanho = lista.getCount();
		String listaEstadosSelecionados = "";
		
		SparseBooleanArray itensSelecionados = lista.getCheckedItemPositions();
		
		for (int i = 0; i < itensSelecionados.size(); i++) {
			listaEstadosSelecionados += lstEstados[itensSelecionados.keyAt(i)] + ", ";
		}
		
		Log.i("LISTA", "Você selecionaou " 
					   + itensSelecionados.size() 
					   + " de " 
					   + tamanho 
					   + " estados: " 
					   + listaEstadosSelecionados);
		
	}
}











