package com.example.duolingo_ciobotarueliza;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MeniuAdapter {

    private List<Curs> lista;

    public MeniuAdapter(List<Curs> lista){this.lista=lista;}

    public int getCount(){return lista.size();}

    public Object getItem(int position) {
        return lista.get(position);
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater infl = LayoutInflater.from(parent.getContext());
        View itemView = infl.inflate(R.layout.item_languages, parent, false); //bool false adica punem la root adica la noi la linear layout
        TextView t_nume = itemView.findViewById(R.id.limba);
        TextView t_pret = itemView.findViewById(R.id.nivel);
        TextView t_desc = itemView.findViewById(R.id.nrOre);
        Curs current = lista.get(position);
        t_nume.setText(current.getLimba());
        t_pret.setText(String.valueOf(current.getNivel()));
        t_desc.setText(current.getNrOre());

        return itemView;
    }

    public void update_list(List<Curs> lista_noua){
        this.lista.clear();
        this.lista.addAll(lista_noua);
      //  notifyDataSetChanged(); //anunta ca sa nu modificam iar elementele?
    }



}
