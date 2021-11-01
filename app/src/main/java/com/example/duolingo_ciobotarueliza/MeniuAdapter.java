package com.example.duolingo_ciobotarueliza;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MeniuAdapter extends BaseAdapter {

    private List<Curs> lista;

    public MeniuAdapter(List<Curs> lista){
        this.lista=lista;}

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater infl = LayoutInflater.from(parent.getContext());
        View itemView = infl.inflate(R.layout.item_languages, parent, false);
        TextView t_limba = itemView.findViewById(R.id.limba);
        TextView t_nivel = itemView.findViewById(R.id.nivel);
        TextView t_nrOre = itemView.findViewById(R.id.nrOre);
        Curs current = lista.get(position);
        t_limba.setText(current.getLimba());
        t_nivel.setText(current.getNivel());
        t_nrOre.setText(String.valueOf(current.getNrOre()));

        return itemView;
    }

    public void update_list(List<Curs> lista_noua){
        this.lista.clear();
        this.lista.addAll(lista_noua);
        notifyDataSetChanged();
    }




}
