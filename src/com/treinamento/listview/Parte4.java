package com.treinamento.listview;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class Parte4 extends Activity {

	private ListView lv;
	private EditText et;
	private String[] lstEstados;
	private ArrayList<String> lstEstados_Encontrados = new ArrayList<String>();

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.parte4);

		lv = (ListView) findViewById(R.id.lvEstados);
		et = (EditText) findViewById(R.id.etProcurar);

		lstEstados = new String[] {"São Paulo", "Rio de Janeiro", "Minas Gerais", "Rio Grande do Sul", "Santa Catarina", "Paraná", "Mato Grosso", "Amazonas", "Ceará", "Bahia", "Acre"};

		//Carrega o listview com todos os itens
		lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lstEstados));
		CarregarEncontrados();

		//Adiciona um TextWatcher ao TextView cujos métodos são chamados sempre que este EditText sofra alterações.
		et.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable s) {
				// Abstract Method of TextWatcher Interface.
			}

			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
				// Abstract Method of TextWatcher Interface.
			}

			//Evento acionado quando o usuário teclar algo na caixa de texto "Procurar"
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				CarregarEncontrados();

				//Carrega o listview com os itens encontrados
				lv.setAdapter(new ArrayAdapter<String>(Parte4.this, android.R.layout.simple_list_item_1, lstEstados_Encontrados));
			}
		});

		lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int position, long index) {
				Mensagem("Você clicou no estado : " + lstEstados_Encontrados.get(position).toString());
			}
		});

	}

	public void CarregarEncontrados() {
		int textlength = et.getText().length();

		//Limpa o array com os estados encontrados para poder efetuar nova busca
		lstEstados_Encontrados.clear();

		for (int i = 0; i < lstEstados.length; i++) {
			if (textlength <= lstEstados[i].length()) {
				//Verifica se existe algum item no array original caso encontre é adicionado no array de encontrados
				if(et.getText().toString().equalsIgnoreCase((String)lstEstados[i].subSequence(0, textlength))) {
					lstEstados_Encontrados.add(lstEstados[i]);
				}
			}
		}
	}

	private void Mensagem(String msg) {
		Toast.makeText (getApplicationContext(), msg, Toast.LENGTH_SHORT).show ();
	} 

}
