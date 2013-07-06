package com.treinamento.listview;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class EstadoAdapter extends BaseAdapter {

	private List<Estado> listEstados;
	 
    //Classe utilizada para instanciar os objetos do XML
    private LayoutInflater inflater;
     
    public EstadoAdapter(Context context, List<Estado> plistEstados) {
        this.listEstados = plistEstados;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
 
    public void addItem(final Estado item) {
        this.listEstados.add(item);
        //Atualizar a lista caso seja adicionado algum item
        notifyDataSetChanged();
    }    
     
    @Override
    public int getCount() {
        return listEstados.size();
    }
 
    @Override
    public Object getItem(int position) {
        return listEstados.get(position);
    }
 
    @Override
    public long getItemId(int position) {
        return position;
    }
 
    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        //Pega o registro da lista e trasnfere para o objeto estadoVO
        Estado estadoVO = listEstados.get(position);
         
        //Utiliza o XML estado_row para apresentar na tela
        convertView = inflater.inflate(R.layout.estado_row, null);
         
        //Instância os objetos do XML
        ImageView bandeira = (ImageView)convertView.findViewById(R.id.bandeira);
        TextView tvEstado = (TextView)convertView.findViewById(R.id.tvEstado);
        TextView tvCapital = (TextView)convertView.findViewById(R.id.tvCapital);
             
        //pega os dados que estão no objeto estadoVO e transfere para os objetos do XML
        bandeira.setImageResource(estadoVO.getBandeira());
        tvEstado.setText(estadoVO.getEstado());
        tvCapital.setText(estadoVO.getCapital());
         
        return convertView;
    }	

}
