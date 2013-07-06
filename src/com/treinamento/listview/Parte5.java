package com.treinamento.listview;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class Parte5 extends Activity {

	//Criamos uma lista de Estados baseados na classe Estado
    private List<Estado> lstEstados = null;
     
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         
        setContentView(R.layout.parte5);
         
        ListView list = (ListView) findViewById(R.id.ListView12);
 
        //Iniciamos a lista de Estados
        //no m�todo add j� inserimos um novo registro de cada Estados desejado
        lstEstados = new ArrayList<Estado>();
        lstEstados.add(new Estado("Sao Paulo", "Sao Paulo", R.drawable.saopaulo));
        lstEstados.add(new Estado("Rio de Janeiro", "Rio de Janeiro", R.drawable.riodejaneiro));
        lstEstados.add(new Estado("Minas Gerais", "Belo Horizonte", R.drawable.minasgerais));
        lstEstados.add(new Estado("Rio Grande do Sul", "Porto Alegre", R.drawable.riograndedosul));
        lstEstados.add(new Estado("Santa Catarina", "Florian�polis", R.drawable.santacatarina));
        lstEstados.add(new Estado("Paran�", "Curitiba", R.drawable.bandeirapr));
        lstEstados.add(new Estado("Mato Grosso", "Cuiab�", R.drawable.matogrosso));
        lstEstados.add(new Estado("Amazonas", "Manaus", R.drawable.amazonas));
 
        //Cria��o do Adapter e passamos a nossa lista de Estados para ele
        EstadoAdapter adapter = new EstadoAdapter(this, lstEstados);
 
        //referenciamos a fun��o que ser� invocada quando o usu�rio
        //clicar em algum item da lista
        list.setOnItemClickListener(onItemClick_List);
     
        list.setAdapter(adapter);
     
        //caso seja preciso adicionar mais algum item na lista voc�
        //pode utilizar tamb�m a forma abaixo
        adapter.addItem(new Estado("Bahia", "Salvador", R.drawable.bahia));
    }
 
    OnItemClickListener onItemClick_List = new OnItemClickListener() {
        public void onItemClick(AdapterView<?> arg0, View view, int position, long index) {
            //Pegar o item clicado
            showToast("Voc� clicou no estado : " + lstEstados.get(position).getEstado());
        }
    };
     
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

}